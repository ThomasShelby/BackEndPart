package com.elect.dao;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/16/17.
 */
public interface BaseDao<E> {

    E save(E e);

    E getById(Integer id);

    List<E> getAll();

    void delete(E e);

    void deleteById(String id);

    E update(E e);
}
