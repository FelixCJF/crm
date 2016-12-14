<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
		function showPost(obj) {
			//1 获得选中的部门id
			var depId = obj.value;
			//2 发送ajax数据，通过部门的id查询职务
			// * 路径参考 /crm/post/postAction_findAllWithDepartment?crmDepartment.depId=
			// 2.1 创建对象（ajax引擎）
			var xmlhttp = null;
			if (window.XMLHttpRequest){
				xmlhttp=new XMLHttpRequest();
			} else if (window.ActiveXObject){
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			// 2.2 设置回调
			xmlhttp.onreadystatechange = function(){
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
					// # 获得select对象
					var selectObj = document.getElementById("postSelectId");
					selectObj.innerHTML = "<option value=''>--请选择职务--</option>";
					//1)获得数据（字符串）
					var data = xmlhttp.responseText;
					//2) 转成json对象
					var jsonData = eval("("+data+")");
					//3)遍历
					for(var i = 0 ; i < jsonData.length ; i ++){
						var postObj = jsonData[i];
						// 3.1)获得id
						var postId = postObj.postId;
						// 3.2)获得名称
						var postName = postObj.postName;
						
						// #添加数据
						selectObj.innerHTML += "<option value='"+postId+"'>"+postName+"</option>";
						
					}
				}
			};
			// 2.3 建立连接
			var url = "${pageContext.request.contextPath}/post/postAction_findAllWithDepartment?crmDepartment.depId=" + depId;
			xmlhttp.open("get",url);
			// 2.4 发送请求
			xmlhttp.send(null);
			
		}
	</script>
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="document.forms[0].submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<a href="${pageContext.request.contextPath}/pages/staff/addStaff.jsp">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<s:form namespace="/staff" action="staffAction_findAll">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
			<s:select list="#allDepartment" name="crmPost.crmDepartment.depId"  onchange="showPost(this)"
				headerKey="" headerValue="--请选择部门--"
				listKey="depId"  listValue="depName" 
				></s:select>
	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	    	
			<s:select list="allPost != null ? allPost : {}"  name="crmPost.postId" id="postSelectId" 
				headerKey="" headerValue="--请选择职务--"
				listKey="postId" listValue="postName"></s:select>

	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><s:textfield name="staffName" size="12"></s:textfield></td>
	    <td ></td>
	  </tr>
	</table>
</s:form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>
  
    	<%--遍历数据，奇偶行样式不同   
    		class="tabtd1" ，class="tabtd2"
    	--%>
    <s:iterator value="allStaff" status="vs">  <%--将遍历每一项压入到栈顶（root），可以通过javabean 属性获得值 --%>
	  <tr class="<s:property value="#vs.odd ? 'tabtd1' : 'tabtd2' "/>"> 
	    <td align="center"><s:property value="staffName"/> </td>
	    <td align="center"><s:property value="gender"/></td>
	    <td align="center"><s:date name="onDutyDate" format="yyyy年MM月dd日" /> </td>
	    <td align="center"><s:property value="crmPost.crmDepartment.depName"/></td>
	    <td align="center"><s:property value="crmPost.postName"/></td>
	  	<td width="7%" align="center">
	  		
	  		<a href="${pageContext.request.contextPath}/pages/staff/editStaff.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>	
	  	</td>
	  	
	  </tr>
    </s:iterator>
</table>


<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>
</body>
</html>
