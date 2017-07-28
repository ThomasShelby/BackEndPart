package com.elect.dao.impl;

import com.elect.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/16/17.
 */
public abstract class BaseDaoImpl<E> implements BaseDao<E> {

    private final Class<E> persistentClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
//        this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(E entity) {
        getSession().persist(entity);
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass);
    }


    @Override
    public E save(E entity) {
        persist(entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public E getById(Integer id) {
        return (E) getSession().get(persistentClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<E> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<E>) criteria.list();
    }

    @Override
    public void delete(E entity) {
        getSession().delete(entity);
    }

    @Override
    public void deleteById(String id) {
//        Query query = getSession().createSQLQuery("delete from user_card where id = :id");
//        query.setString("id", id);
//        query.executeUpdate();
        getSession().delete(getSession().get(persistentClass, id));
    }

    @Override
    public E update(E entity) {
        getSession().update(entity);
        return entity;
    }
}
