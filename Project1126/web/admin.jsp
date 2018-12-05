<%--
  Created by IntelliJ IDEA.
  User: 17798
  Date: 2018/11/10
  Time: 14:59
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
        <table>
            <%--border="1" width="61.8%"--%>
            <tr>
                <th><input type = "button" value = "增加" onclick = "window.location.href = 'add.jsp'"></th>
                <th><input type = "button" value = "删除" onclick = "window.location.href = 'del.jsp'"></th>
                <th><input type = "button" value = "更改" onclick = "window.location.href = 'updt.jsp'"></th>
                <th><input type = "button" value = "查找" onclick = "window.location.href = 'adminfind.jsp'"></th>
            </tr>
        </table>
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
        <s:iterator value="users">
            <tr class="alt">
                <td><s:property value="id" /> </td>
                <td><s:property value="name" /> </td>
                <td><s:property value="sex" /> </td>
                <td><s:property value="phone" /> </td>
            </tr>
        </s:iterator>
    </table>
    <%--name:${name}<br/>--%>
    <%--sex:${sex}<br/>--%>
    <%--phone:${phone}<br/>--%>
</center>

</body>
</html>
