package com.itheima.crm.post.domain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.department.domain.CrmDepartment;
import com.itheima.crm.staff.domain.CrmStaff;

public class CrmPost implements java.io.Serializable {

	private static final long serialVersionUID = 3178143598522199176L;
	private String postId;
	private CrmDepartment crmDepartment;
	private String postName;			//职务名称
	private Set<CrmStaff> crmStaffs = new HashSet<CrmStaff>();
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public CrmDepartment getCrmDepartment() {
		return crmDepartment;
	}
	public void setCrmDepartment(CrmDepartment crmDepartment) {
		this.crmDepartment = crmDepartment;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public Set<CrmStaff> getCrmStaffs() {
		return crmStaffs;
	}
	public void setCrmStaffs(Set<CrmStaff> crmStaffs) {
		this.crmStaffs = crmStaffs;
	}
	
	

}