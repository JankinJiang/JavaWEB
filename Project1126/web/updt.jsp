<%--
  Created by IntelliJ IDEA.
  User: 17798
  Date: 2018/11/28
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="CSS/index.css?v=<%= System.currentTimeMillis()%>" type="text/css" >
<html>
<head>
    <title>用户信息管理系统</title>
</head>
<body>
<center>
    <br />
    <h3>修改成员信息</h3>
    <br/><hr/><br/>
    <s:form action="updt" namespace="/" method="POST">
        <s:textfield name="id" label="id"/><br/>
        <s:textfield label="name" name="name" /><br/>
        <s:radio list="{'男','女'}" name="sex" label="sex" value="男" /><br/>
        <s:textfield label="phone" name="phone" /><br/>
        <s:textfield label="identity" name="identity" /><br/>
        <%--<s:reset value="reset" name="reset"/><br/>--%>
        <s:submit value="update" name="update" />
        <br/>
    </s:form>
</center>
</body>
</html>
