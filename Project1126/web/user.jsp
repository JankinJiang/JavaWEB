<%--
  Created by IntelliJ IDEA.
  User: 17798
  Date: 2018/11/26
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="CSS/success.css?v=<%= System.currentTimeMillis()%>" type="text/css">
<html>
<head>
    <title>用户信息管理</title>
</head>
<body >
<center>
    <br />
    <h2>欢迎来到用户管理系统！</h2>
    <br/>
    <div align="center">
        <form action="userfind.jsp">
            <input type = "button" value = "查找" onclick = "window.location.href = 'userfind.jsp'">
        </form>
    </div>
    <br /><hr/><br/>
    <table  id="customers">
        <%--border="1" width="61.8%"--%>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>sex</th>
            <th>phone</th>
        </tr>
        <%--<tr>--%>
        <%--<td><s:property value="id" /> </td>--%>
        <%--<td><s:property value="name" /> </td>--%>
        <%--<td><s:property value="sex" /> </td>--%>
        <%--<td><s:property value="phone" /> </td>--%>
        <%--</tr>--%>
        <s:iterator value="users" var="user">
            <tr class="alt">
                <td><s:property value="#user.id" /> </td>
                <td><s:property value="#user.name" /> </td>
                <td><s:property value="#user.sex" /> </td>
                <td><s:property value="#user.phone" /> </td>
            </tr>
        </s:iterator>
    </table>
    <%--name:${name}<br/>--%>
    <%--sex:${sex}<br/>--%>
    <%--phone:${phone}<br/>--%>
</center>
</body>
</html>

