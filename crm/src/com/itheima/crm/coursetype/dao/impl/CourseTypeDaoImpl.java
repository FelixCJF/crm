package com.itheima.crm.coursetype.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima.crm.coursetype.dao.CourseTypeDao;
import com.itheima.crm.coursetype.domain.CrmCourseType;
import com.itheima.crm.page.PageHibernateCallBack;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {

	@Override
	public void save(CrmCourseType courseType) {
		this.getHibernateTemplate().save(courseType);
	}

	@Override
	public void update(CrmCourseType courseType) {
		this.getHibernateTemplate().update(courseType);
	}

	@Override
	public void delete(CrmCourseType courseType) {
		this.getHibernateTemplate().delete(courseType);
	}

	@Override
	public List<CrmCourseType> findAll() {
		return this.getHibernateTemplate().find("from CrmCourseType");
	}

	@Override
	public CrmCourseType findById(String id) {
		return this.getHibernateTemplate().get(CrmCourseType.class, id);
	}

	@Override
	public void saveOrUpdate(CrmCourseType courseType) {
		this.getHibernateTemplate().saveOrUpdate(courseType);
	}

	@Override
	public List<CrmCourseType> findAll(String condition, Object[] params,
			int startIndex, int pageSize) {
		String hql = "from CrmCourseType where 1=1 " + condition;
		return this.getHibernateTemplate().execute(new PageHibernateCallBack<CrmCourseType>(hql,params,startIndex,pageSize));
	}

	@Override
	public int getTotalRecord(String condition ,Object[] params) {
		String hql = "select count(*) from CrmCourseType where 1=1 " + condition;
		List<Long> all = this.getHibernateTemplate().find(hql ,params);
		return all.get(0).intValue();
	}
	
	
	

}
