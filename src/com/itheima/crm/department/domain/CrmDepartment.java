package com.itheima.crm.department.domain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.post.domain.CrmPost;

public class CrmDepartment implements java.io.Serializable {

	private static final long serialVersionUID = -5015409019974778432L;
	private String depId;
	private String depName;
	private Set<CrmPost> crmPosts = new HashSet<CrmPost>();
	
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Set<CrmPost> getCrmPosts() {
		return crmPosts;
	}
	public void setCrmPosts(Set<CrmPost> crmPosts) {
		this.crmPosts = crmPosts;
	}

	

}