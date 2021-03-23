<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/23
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/12_Cookie_session/loginServlet">
        用户名: <input type="text" name="username" value="${cookie.username.value}"/> <br>
        密码: <input type="password" name="password"/> <br>
        <input type="submit" value="登录"/> <br>
    </form>
</body>
</html>
