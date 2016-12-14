package com.itheima.crm.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class<T> baseClass;
	
	public BaseDaoImpl() {
		//运行时，获得T具体的 类型，由子类传递(this 当前运行类，也就是子类)
		//1 获得父类的泛型信息 （被参数化的类型）
		ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
		//2 获得第一个实际参数
		baseClass = (Class<T>)paramType.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public List<T> findAll() {
		// baseClass.getName() --> com.itheima....CrmCourseType
		// hibernate --> session.createQuery("from CrmCourseType");
		// hibernate --> session.createQuery("from com.itheima.crm.coursetype.domain.CrmCourseType");
		return this.getHibernateTemplate().find("from " + baseClass.getName());
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(baseClass, id);
	}

}
