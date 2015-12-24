package com.mik.gwt.server.dao;

import java.util.List;

public interface GenericDAO<T, PK> {

    T create(T entity);

    T read(PK id);

    T update(T entity);

    void delete(T entity);

    List<T> findAll();

    T flush(T entity);

    Integer removeAll();

}
