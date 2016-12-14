package com.itheima.crm.staff.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.department.domain.CrmDepartment;
import com.itheima.crm.staff.dao.StaffDao;
import com.itheima.crm.staff.domain.CrmStaff;
import com.itheima.crm.staff.service.StaffService;
import com.itheima.crm.utils.MyStringUtils;

public class StaffServiceImpl implements StaffService {

	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	@Override
	public CrmStaff login(CrmStaff staff) {
		//登录密码需要加密
		staff.setLoginPwd(MyStringUtils.getMD5Value(staff.getLoginPwd()));
		return staffDao.find(staff);
	}

	@Override
	public List<CrmStaff> findAll(CrmStaff staff) {
		//拼凑条件
		//* 条件
		StringBuilder sqlBuilder = new StringBuilder();
		//* 参数
		List<Object> paramsList = new ArrayList<Object>();
		
		//有可能有条件
		if(staff.getCrmPost() != null){
			//2  选择职务(有职务就不添加部门)
			if(StringUtils.isNotBlank(staff.getCrmPost().getPostId())){
				sqlBuilder.append(" and crmPost = ?");
				paramsList.add(staff.getCrmPost());
			} else {
				//1 选中部门
				CrmDepartment department = staff.getCrmPost().getCrmDepartment();
				if(department != null && StringUtils.isNotBlank(department.getDepId())){
					sqlBuilder.append(" and crmPost.crmDepartment = ?");
					paramsList.add(staff.getCrmPost().getCrmDepartment());
				}
			}
		}
		
		
		//3员工姓名 null  ""
		if(StringUtils.isNotBlank(staff.getStaffName())){
			sqlBuilder.append(" and staffName like ?");
			paramsList.add("%"+staff.getStaffName()+"%");
		}
		
		// 将转成需要数据
		String condition = sqlBuilder.toString();
		Object[] params = paramsList.toArray();
		
		
		
		return staffDao.findAll(condition , params);
	}
	

}
