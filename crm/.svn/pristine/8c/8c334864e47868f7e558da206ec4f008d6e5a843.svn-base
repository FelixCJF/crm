package com.itheima.crm.staff.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima.crm.staff.dao.StaffDao;
import com.itheima.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

	@Override
	public CrmStaff find(CrmStaff staff) {
		List<CrmStaff> list = this.getHibernateTemplate().find("from CrmStaff where loginName = ? and loginPwd = ?", staff.getLoginName(),staff.getLoginPwd());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<CrmStaff> findAll(String condition, Object[] params) {
		String hql = "from CrmStaff where 1=1 " + condition;
		return this.getHibernateTemplate().find(hql , params);
	}

}
