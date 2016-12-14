package com.itheima.crm.coursetype.service.impl;

import java.util.List;

import com.itheima.crm.coursetype.dao.CourseTypeDao;
import com.itheima.crm.coursetype.domain.CrmCourseType;
import com.itheima.crm.coursetype.service.CourseTypeService;
import com.itheima.crm.page.PageBean;

public class CourseTypeServiceImpl implements CourseTypeService {
	
	private CourseTypeDao courseTypeDao;
	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}
	@Override
	public void addCourseType(CrmCourseType courseType) {
		this.courseTypeDao.save(courseType);
	}
	@Override
	public void updateCourseType(CrmCourseType courseType) {
		this.courseTypeDao.update(courseType);
	}
	@Override
	public void deleteCourseType(CrmCourseType courseType) {
		this.courseTypeDao.delete(courseType);
	}
	@Override
	public List<CrmCourseType> findAll() {
		return this.courseTypeDao.findAll();
	}
	@Override
	public CrmCourseType findById(String id) {
		return this.courseTypeDao.findById(id);
	}
	@Override
	public void saveOrUpdateCourseType(CrmCourseType courseType) {
		this.courseTypeDao.saveOrUpdate(courseType);
	}
	@Override
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType, int pageNum,
			int pageSize) {
		//拼凑条件
		
		
		//1 总记录数
		int totalRecord = this.courseTypeDao.getTotalRecord();
		
		//2 将查询结果封装 javabean
		PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);
		
		//3 查询分页数
		List<CrmCourseType> data = this.courseTypeDao.findAll("",null, pageBean.getStartIndex(), pageSize);
		pageBean.setData(data);
		
		return pageBean;
	}
}
