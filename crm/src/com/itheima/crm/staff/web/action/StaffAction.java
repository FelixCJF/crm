package com.itheima.crm.staff.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.itheima.crm.department.domain.CrmDepartment;
import com.itheima.crm.department.service.DepartmentService;
import com.itheima.crm.post.domain.CrmPost;
import com.itheima.crm.post.service.PostService;
import com.itheima.crm.staff.domain.CrmStaff;
import com.itheima.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {  //1.1 实现接口

	//1 封装数据
	private CrmStaff staff = new CrmStaff(); //1.2 提供javabean实例（一定要new）
	@Override
	public CrmStaff getModel() {	//1.3 实现方法
		return staff;
	}
	
	//2 spring 自动按照名称进行注入
	// 2.1 员工service
	// 2.1 员工service
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	// 2.2部门service
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	// 2.3 职务
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	//##########################################33

	
	public String login(){
		
		// 登录
		CrmStaff loginStaff = staffService.login(staff);
		// 处理
		if(loginStaff != null){
			//登录成功 -- session作用域数据，重定向首页
			ActionContext.getContext().getSession().put("loginStaff", loginStaff);
			return "success";
		} else {
			//不成功 -- 登录页给出提示
			this.addFieldError("", "登录用户和密码不匹配");
			return "login";
		}
	}
	
	/**
	 * 登录成功页面
	 * @return
	 */
	public String home(){
		return "home";
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		// 1 查询所有员工
		// 查询
		List<CrmStaff> allStaff = staffService.findAll(staff);
		// 将查询结果存放 值栈中 -- root  --> jsp页面获取，  key 或 属性名  获得内容
		// * 如果一组数据（List） ，使用root set方法 ，设置key
		// * 如果一个对象（javabean），使用root push方法 ，javabean属性
		ActionContext.getContext().getValueStack().set("allStaff", allStaff);
		
		//2 查询所有的部门
		List<CrmDepartment> allDepartment = this.departmentService.findAll();
		// * 将数据存放到context  , jsp获取 “#key”
		ActionContext.getContext().put("allDepartment", allDepartment);
		//3 如果选中部门，将查询部门的所有的职务
		String depId = null;
		if(staff.getCrmPost() != null && staff.getCrmPost().getCrmDepartment() != null){
			depId = staff.getCrmPost().getCrmDepartment().getDepId();
			if(StringUtils.isNotBlank(depId)){
				//选中部门
				List<CrmPost> allPost = postService.findAll(depId);
				ActionContext.getContext().getValueStack().set("allPost", allPost);
			}
		}
		return "findAll";
	}
	
	
}
