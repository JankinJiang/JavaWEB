<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 17798
  Date: 2018/11/26
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="CSS/index.css?v=<%= System.currentTimeMillis()%>" type="text/css" >
<html>
<head>
    <title>用户信息管理系统</title>
</head>
<body>
<center>
    <br />
    <h3>增加成员信息</h3>
    <br/><hr/><br/>
    <s:form action="add" method="POST">
        <s:textfield name="id" label="id"/><br/>
        <s:textfield label="name" name="name" /><br/>
        <s:radio list="{'男','女'}" name="sex" label="sex" value="男" /><br/>
        <s:textfield label="phone" name="phone" /><br/>
        <s:textfield label="identity" name="identity" /><br/>
        <%--<s:reset value="reset" name="reset"/><br/>--%>
        <s:submit value="add" name="add" />
        <br/>
    </s:form>
</center>
</body>
</html>
