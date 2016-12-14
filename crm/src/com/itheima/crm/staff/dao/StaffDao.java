package com.itheima.crm.staff.dao;

import java.util.List;

import com.itheima.crm.staff.domain.CrmStaff;

public interface StaffDao {
	
	/**
	 * 通过 登录名 和 密码 查询员工
	 * @param staff
	 * @return
	 */
	public CrmStaff find(CrmStaff staff);
	
	/**
	 * 查询所有
	 * @param condition  条件 (所有的拼凑条件格式 “and 属性  = ?”)
	 * @param params 对应参数
	 * @return
	 */
	public List<CrmStaff> findAll(String condition , Object[] params);

}
