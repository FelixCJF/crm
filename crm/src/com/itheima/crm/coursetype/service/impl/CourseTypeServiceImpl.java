package com.itheima.crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
		//#1 准备对象
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		//#2 拼凑
		//#2.1 类别名称 
		if(StringUtils.isNotBlank(courseType.getCourseName())){
			builder.append(" and courseName like ? ");
			paramsList.add("%"+courseType.getCourseName()+"%");
		}
		//#2.2 简介
		if(StringUtils.isNotBlank(courseType.getRemark())){
			builder.append(" and remark like ? ");
			paramsList.add("%"+courseType.getRemark()+"%");
		}
		//#2.3 总学时--条件都是字符串，需要的整形
		int totalStart = 0;
		int totalEnd = 0;
		if(StringUtils.isNotBlank(courseType.getTotalStart())){  //200
			totalStart = Integer.parseInt(courseType.getTotalStart());
		}
		if(StringUtils.isNotBlank(courseType.getTotalEnd())){   //100
			totalEnd = Integer.parseInt(courseType.getTotalEnd());
		}
		// * 处理start <= end
		int temp = 0;
		if(totalStart > totalEnd){
			/*
			totalStart = totalStart + totalEnd;
			totalEnd = totalStart - totalEnd;
			totalStart = totalStart - totalEnd;
			*/
			temp = totalStart;
			totalStart = totalEnd;
			totalEnd = temp;
			//查询条件中没有交换
		}
		// * 拼凑sql
		if(totalStart > 0){
			builder.append(" and total >= ?");
			paramsList.add(totalStart);
		}
		
		if(totalEnd > 0){
			builder.append(" and total <= ?");
			paramsList.add(totalEnd);
		}
		
		//#2.4 费用
		if(StringUtils.isNotBlank(courseType.getLessonCostStart())){
			builder.append(" and courseCost >= ?");
			paramsList.add(Double.parseDouble(courseType.getLessonCostStart()));
		}
		if(StringUtils.isNotBlank(courseType.getLessonCostEnd())){
			builder.append(" and courseCost <= ?");
			paramsList.add(Double.parseDouble(courseType.getLessonCostEnd()));
		}
		
		//#3 转换
		String condition = builder.toString();
		Object[] params = paramsList.toArray();
		
		
		
		//1 总记录数
		int totalRecord = this.courseTypeDao.getTotalRecord(condition,params);
		
		//2 将查询结果封装 javabean
		PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);
		
		//3 查询分页数
		List<CrmCourseType> data = this.courseTypeDao.findAll(condition,params, pageBean.getStartIndex(), pageSize);
		pageBean.setData(data);
		
		return pageBean;
	}
}
