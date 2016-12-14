package com.itheima.crm.classes.domain;

import java.util.Date;

import com.itheima.crm.coursetype.domain.CrmCourseType;

public class CrmClass implements java.io.Serializable {

	private static final long serialVersionUID = -4822634630105348829L;
	
	private String classId;
	private CrmCourseType crmCourseType;
	private String name;
	private Date beginTime;
	private Date endTime;
	private String status;
	private Integer totalCount;
	private Integer upgradeCount;
	private Integer changeCount;
	private Integer runoffCount;
	private String remark;
	private String uploadFile;
	private Date uploadTime;
	private String uploadPath;
	private String uploadFilename;
	
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public CrmCourseType getCrmCourseType() {
		return crmCourseType;
	}
	public void setCrmCourseType(CrmCourseType crmCourseType) {
		this.crmCourseType = crmCourseType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getUpgradeCount() {
		return upgradeCount;
	}
	public void setUpgradeCount(Integer upgradeCount) {
		this.upgradeCount = upgradeCount;
	}
	public Integer getChangeCount() {
		return changeCount;
	}
	public void setChangeCount(Integer changeCount) {
		this.changeCount = changeCount;
	}
	public Integer getRunoffCount() {
		return runoffCount;
	}
	public void setRunoffCount(Integer runoffCount) {
		this.runoffCount = runoffCount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUploadFilename() {
		return uploadFilename;
	}
	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}

	

}