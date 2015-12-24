package com.mik.gwt.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by mikitjuk on 16.12.15.
 */
public abstract class GenericAbstractDAO<T, PK> implements GenericDAO<T, PK> {

    protected Class<T> entityClass;

    protected abstract EntityManager getEntityManager();

    @SuppressWarnings("unchecked")
    public GenericAbstractDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
    }

    public T create(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public T read(PK id) {
        return getEntityManager().find(entityClass, id);
    }

    public T update(T entity) {
        getEntityManager().refresh(entity);
        return entity;
    }

    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public T flush(T entity) {
        getEntityManager().flush();
        return entity;
    }

    public List<T> findAll() {
        return getEntityManager()
                .createQuery("select x from " + entityClass.getSimpleName() + " x")
                .getResultList();
    }

    public Integer removeAll() {
        String queryStr = "delete from " + entityClass.getName() + " h";
        Query query = getEntityManager().createQuery(queryStr);
        return query.executeUpdate();
    }
}
