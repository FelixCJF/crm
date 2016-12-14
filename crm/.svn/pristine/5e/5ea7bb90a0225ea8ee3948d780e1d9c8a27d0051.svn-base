package com.itheima.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.itheima.crm.coursetype.domain.CrmCourseType;
import com.itheima.crm.coursetype.service.CourseTypeService;
import com.itheima.crm.page.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.commons.digester.SetNextRule;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {
	// 1 封装数据
	private CrmCourseType courseType = new CrmCourseType();
	@Override
	public CrmCourseType getModel() {
		return courseType;
	}
	
	//2 service 
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	
	//#################################
	
	private int pageSize = 2;		//每页显示（固定值）
	private int pageNum = 1;		//当前页
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	/**
	 * 查询所有 + 分页
	 * @return
	 */
	public String findAll(){
		/*
		// 通知service查询
		List<CrmCourseType> allCourseType = this.courseTypeService.findAll();
		// action 存放 root(List)  set(key,value)  ，jsp 获得 “key”
		// * set 底层使用Map，将数据先存放到Map中，然后将Map压入到栈顶
		// * 如果此map在栈顶，将共享Map对象。如果不在栈顶将创建一个新的map。
		ActionContext.getContext().getValueStack().set("allCourseType", allCourseType);
		*/
		
		//分页
		PageBean<CrmCourseType> pageBean = this.courseTypeService.findAll(courseType, pageNum, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll";
	}
	
	/**
	 * 添加或编辑 页面显示
	 * @return
	 */
	public String addOrUpdateUI(){
		//如果有id表示更新 -- 通过id查询类别
		if(StringUtils.isNotBlank(courseType.getCourseTypeId())){
			// 通过id查询
			CrmCourseType findCourseType = courseTypeService.findById(courseType.getCourseTypeId());
			// 必须将对象压入到指定
			ActionContext.getContext().getValueStack().push(findCourseType);
		}
		
		return "addOrUpdateUI";
	}
	
	/**
	 * 添加或更新操作
	 * @return
	 */
	public String addOrUpdate(){
		courseTypeService.saveOrUpdateCourseType(courseType);
		return "addOrUpdate";
	}
	
	
	

}
