package com.itheima.crm.coursetype.service;

import java.util.List;

import com.itheima.crm.coursetype.domain.CrmCourseType;
import com.itheima.crm.page.PageBean;

public interface CourseTypeService {
	
	public void addCourseType(CrmCourseType courseType);
	
	public void updateCourseType(CrmCourseType courseType);
	
	public void deleteCourseType(CrmCourseType courseType);
	
	public List<CrmCourseType> findAll();
	
	public CrmCourseType findById(String id);

	public void saveOrUpdateCourseType(CrmCourseType courseType);
	
	/**
	 * 
	 * @param courseType 条件查询
	 * @param pageNum 当前页
	 * @param pageSize 每页显示个数
	 * @return 分页封装对象
	 */
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType,int pageNum,int pageSize);
}
