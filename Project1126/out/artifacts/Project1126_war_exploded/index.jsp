<%--
  Created by IntelliJ IDEA.
  User: 17798
  Date: 2018/11/9
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="CSS/index.css?v=<%= System.currentTimeMillis()%>" type="text/css" >
<html>
  <head>
    <title>用户信息管理系统</title>
  </head>
  <body >
  <center>
      <br />
      <h2>登录</h2>
      <br />
      <hr/>
      <br/>
      <div>
          <s:form action="login" method="POST">
              <s:textfield name="user.name" label="name" /><br/>
              <s:property value="error.usesr.name" />
              <s:password name="user.identity" label="password" /><br/>
              <s:property value="error.user.identity" />
              <center>
                  <div id="login">
                      <s:submit value="login" name="login" action="login" /><br />
                  </div>
              </center>
          </s:form>
      </div>
  </center>
  </body>
</html>
