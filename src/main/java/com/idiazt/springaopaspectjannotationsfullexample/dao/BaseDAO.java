package com.idiazt.springaopaspectjannotationsfullexample.dao;

import java.util.Collection;

import com.idiazt.springaopaspectjannotationsfullexample.entities.BaseEntity;

public abstract class BaseDAO<E extends BaseEntity> {

	public abstract E persist(E entity);

	public abstract Collection<E> list();

	public abstract E findById(Long id);

	public abstract boolean delete(Long id);
}
