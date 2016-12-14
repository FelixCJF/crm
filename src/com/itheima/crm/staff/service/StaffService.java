package com.itheima.crm.staff.service;

import java.util.List;

import com.itheima.crm.staff.domain.CrmStaff;

public interface StaffService {
	
	/**
	 * 员工登录
	 * @param staff
	 * @return
	 */
	public CrmStaff login(CrmStaff staff);
	
	/**
	 * 查询所有(含有条件)的员工
	 * @param staff 条件
	 * @return
	 */
	public List<CrmStaff> findAll(CrmStaff staff);

}
