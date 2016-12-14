<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

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
    <td width="39%" align="left">[课程类别]</td>
   
    <td width="57%"align="right">
		<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
			<img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" />
		</a>      
    	<%--编辑前：添加类别  ,/pages/coursetype/addOrEditCourse.jsp--%>
    	<s:a namespace="/courseType" action="courseTypeAction_addOrUpdateUI">
	       	<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</s:a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<%--条件查询 start --%>
<s:form namespace="/courseType" action="courseTypeAction_findAll">
	<%--隐藏域，用于存放pageNum的值 --%>
	<s:hidden id="pageNumId" name="pageNum" value="1"></s:hidden>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">课程类别：</td>
	    <td><s:textfield name="courseName" size="30"></s:textfield></td>
	  </tr>
	  <tr>
	    <td >课程简介：</td>
	    <td ><s:textfield name="remark" size="30"></s:textfield></td>
	  </tr>
	  <tr>  
	    <td >总学时：</td>
	    <td >
	    	<s:textfield name="totalStart" size="12"></s:textfield>
	    	至  
	    	<s:textfield name="totalEnd" size="12"></s:textfield>
	    </td>
	  </tr>
	  <tr>
	    <td>课程费用：</td>
	    <td >
	    	<s:textfield name="lessonCostStart" size="12"></s:textfield>
	    	至 
	    	<s:textfield name="lessonCostEnd" size="12"></s:textfield>
	    </td>
	  </tr>
	</table>
</s:form>

<%--条件查询 end --%>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="97%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="14%" align="center">名称</td>
    <td width="33%" align="center">简介</td>
    <td width="13%" align="center">总学时</td>
    <td width="18%" align="center">收费标准</td>
	<td width="11%" align="center">编辑</td>
  </tr>
  <%--数据展示，单行：tabtd1；双行：tabtd2 --%>
  <%--如果使用var，将查询结果存放context key=var value=遍历某一项 ，标签体中获取的方式 “#key” 
  	* 注意：如果使用var iterator迭代 在context存放一份，也在root中也存放一份。
  --%>
  <s:iterator value="data" var="courseType">  
   <tr class="tabtd1">
	    <td align="center"><s:property value="#courseType.courseName" /></td>
	    <td align="center"><s:property value="#courseType.remark" /></td>
	    <td align="center"><s:property value="#courseType.total" /></td>
	    <td align="center"><s:property value="#courseType.courseCost" /></td>
	  	<td width="11%" align="center">
	  		
	  		<s:a namespace="/courseType" action="courseTypeAction_addOrUpdateUI">
	  			<s:param name="courseTypeId" value="#courseType.courseTypeId"></s:param>
	       		<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" />
    		</s:a>
	  	</td>
	  </tr>
  </s:iterator>


 
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第<s:property value="pageNum" />/<s:property value="totalPage"/>页</span>
        <span>
        	<s:if test="pageNum > 1">
        		<s:a namespace="/courseType" action="courseTypeAction_findAll">
        			<s:param name="pageNum" value="1"></s:param>
        			[首页]
        		</s:a>&nbsp;&nbsp;
        		<s:a namespace="/courseType" action="courseTypeAction_findAll">
        			<s:param name="pageNum" value="pageNum-1"></s:param>
        			[上一页]
        		</s:a>&nbsp;&nbsp;
        	</s:if>
        	<s:if test="pageNum < totalPage">
        		<s:a namespace="/courseType" action="courseTypeAction_findAll">
        			<s:param name="pageNum" value="pageNum+1"></s:param>
        			[下一页]
        		</s:a>&nbsp;&nbsp;
        		<a href="javascript:void(0)" onclick="condition(<s:property value="pageNum+1"/>)">[下一页]</a>&nbsp;&nbsp;
        		
        		<s:a namespace="/courseType" action="courseTypeAction_findAll">
        			<s:param name="pageNum" value="totalPage"></s:param>
        			[尾页]
        		</s:a>&nbsp;&nbsp;
        	</s:if>
        </span>
    </td>
  </tr>
</table>
	<script type="text/javascript">
		function condition(num){
			//点击时，提交表单，将pageNum传递
			document.getElementById("pageNumId").value = num;
			document.forms[0].submit();
		}
	</script>
</body>
</html>
