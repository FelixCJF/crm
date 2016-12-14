package com.itheima.crm.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//登录拦截器
public class LoginInterceptor extends MethodFilterInterceptor {
	
	/*
	private String methodName;
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	*/

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		/*
		String method = invocation.getProxy().getMethod();
		if(methodName.equals(method)){
			//放行
			return invocation.invoke();
		}
		*/
		
		//判断用户登录状态
		Object loginStaff = ActionContext.getContext().getSession().get("loginStaff");
		if(loginStaff == null){
			/**友好提示 start*/
			Object action = invocation.getAction();
			if(action instanceof ActionSupport){
				ActionSupport actionSupport = (ActionSupport) action;
				actionSupport.addFieldError("", "请登录");
			}
			/**友好提示 end*/
			//没有登录
			return "login";
		}
		//放行
		return invocation.invoke();
	}

}
