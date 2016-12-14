package com.itheima.crm.post.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima.crm.post.dao.PostDao;
import com.itheima.crm.post.domain.CrmPost;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

	@Override
	public List<CrmPost> findAll(String depId) {
		return this.getHibernateTemplate().find("from CrmPost where crmDepartment.depId = ? " , depId);
	}

}
