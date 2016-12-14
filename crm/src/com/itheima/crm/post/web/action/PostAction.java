package com.itheima.crm.post.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.itheima.crm.post.domain.CrmPost;
import com.itheima.crm.post.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {
	//1封装数据
	private CrmPost post = new CrmPost();
	@Override
	public CrmPost getModel() {
		return post;
	}
	//2
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	//##########################################################3

	
	/**
	 * ajax 通过部门id查询职务，发送json
	 * @return
	 * @throws IOException 
	 */
	public String findAllWithDepartment() throws IOException{
		//1 查询
		List<CrmPost> allPost = postService.findAll(post.getCrmDepartment().getDepId());
		
		//2 jsonlib 将指定数据转发json字符串
		//JSONObject 处理java对象 （map、javabean）
		//JSONArray 处理java容器（数组、List、Set）
		// 2.1 排除不需要字段
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {"crmDepartment","crmStaffs"});
		// 2.2 转换
		String jsonStr = JSONArray.fromObject(allPost,jsonConfig).toString();
		
		// 2.3 将json数据发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonStr);
		
		return NONE; //表示没有返回值
	}
	
	
	
	
}
