package com.itheima.crm.coursetype.domain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.classes.domain.CrmClass;

//vo bo  po
public class CrmCourseType implements java.io.Serializable {

	private static final long serialVersionUID = -9138521375488386023L;
	private String courseTypeId;
	private Double courseCost;	//费用
	private Integer total;		//总学时
	private String courseName;	//名称
	private String remark;		//简介
	private Set<CrmClass> crmClasses = new HashSet<CrmClass>();
	
	//条件查询
	private String totalStart;		//总学时开始
	private String totalEnd;		//总学时结束
	private String lessonCostStart;	//费用开始
	private String lessonCostEnd;	//费用结束
	
	
	public String getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public Double getCourseCost() {
		return courseCost;
	}
	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<CrmClass> getCrmClasses() {
		return crmClasses;
	}
	public void setCrmClasses(Set<CrmClass> crmClasses) {
		this.crmClasses = crmClasses;
	}
	public String getTotalStart() {
		return totalStart;
	}
	public void setTotalStart(String totalStart) {
		this.totalStart = totalStart;
	}
	public String getTotalEnd() {
		return totalEnd;
	}
	public void setTotalEnd(String totalEnd) {
		this.totalEnd = totalEnd;
	}
	public String getLessonCostStart() {
		return lessonCostStart;
	}
	public void setLessonCostStart(String lessonCostStart) {
		this.lessonCostStart = lessonCostStart;
	}
	public String getLessonCostEnd() {
		return lessonCostEnd;
	}
	public void setLessonCostEnd(String lessonCostEnd) {
		this.lessonCostEnd = lessonCostEnd;
	}

	
	

}