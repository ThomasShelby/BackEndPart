package com.elect.dao.impl;

import com.elect.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/16/17.
 */
public abstract class BaseDaoImpl<E> implements BaseDao<E> {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
        LOG.info("Executing getAll() method. ");
        Criteria criteria = createEntityCriteria();
        return (List<E>) criteria.list();
    }

    @Override
    public void delete(E entity) {
        LOG.info("Executing delete() method. ");
        getSession().delete(entity);
    }

    @Override
    public void deleteById(String id) {
        LOG.info("Executing deleteById() method. ");
        LOG.debug("Executing deleteById() method for id: {} ", id);
        getSession().delete(getSession().get(persistentClass, id));
    }

    @Override
    public E update(E entity) {
        LOG.info("Executing update() method. ");
        getSession().update(entity);
        return entity;
    }
}
