package com.itheima.crm.page;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class PageHibernateCallBack<T> implements HibernateCallback<List<T>> {
	
	private String hql;			//hql语句
	private Object[] params;	//hql对应实际参数
	private int firstResult;	//开始索引
	private int maxResults;		//每页显示个数
	
	public PageHibernateCallBack(String hql, Object[] params, int firstResult,
			int maxResults) {
		super();
		this.hql = hql;
		this.params = params;
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}



	@Override
	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {
		//1 创建Query对象
		Query queryObject = session.createQuery(hql);
		//2 设置实际参数
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				queryObject.setParameter(i, params[i]);
			}
		}
		//3 分页
		// 3.1 开始索引
		if (firstResult >= 0) {
			queryObject.setFirstResult(firstResult);
		}
		// 3.2 每页显示个数
		if (maxResults > 0) {
			queryObject.setMaxResults(maxResults);
		}
		return queryObject.list();
	}

}
