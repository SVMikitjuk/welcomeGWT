package com.mik.gwt.server.dao;

import com.mik.gwt.shared.model.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by mikitjuk on 16.12.15.
 */
@Repository("userDAO")
public class UserDAO{

    @PersistenceContext(unitName = "logoPersistenceUnit")
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Users create(Users entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Users read(Integer id) {
        return getEntityManager().find(Users.class, id);
    }

    public Users update(Users entity) {
        getEntityManager().refresh(entity);
        return entity;
    }

    public void delete(Users entity) {
        getEntityManager().remove(entity);
    }

    public Users flush(Users entity) {
        getEntityManager().flush();
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<Users> findAll() {
        return getEntityManager()
                .createQuery("select x from Users x")
                .getResultList();
    }

    public Integer removeAll() {
        return getEntityManager()
                .createQuery("delete from Users h")
                .executeUpdate();
    }

    public Users getUsersByLogin(String login) {
        Users users = null;
        Query query = entityManager
                .createQuery("from Users where login =:login")
                .setParameter("login", login);
        List list = query.getResultList();
        if (list.size() > 0)
            users = (Users) list.get(0);

        return users;
    }

}