package com.itheima.crm.coursetype.dao;

import java.util.List;

import com.itheima.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {
	
	public void save(CrmCourseType courseType);
	
	public void update(CrmCourseType courseType);
	
	public void delete(CrmCourseType courseType);
	
	public List<CrmCourseType> findAll();
	
	public CrmCourseType findById(String id);
	
	public void saveOrUpdate(CrmCourseType courseType);
	
	/**
	 * 
	 * @param condition 条件查询
	 * @param params 条件参数
	 * @param startIndex 开始索引
	 * @param pageSize 每页显示个数
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition ,Object[] params ,int startIndex,int pageSize);

	/**
	 * 查询总记录数
	 * @return
	 */
	public int getTotalRecord();
	
}
