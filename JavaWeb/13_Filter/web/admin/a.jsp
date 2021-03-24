<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/24
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("提前访问a.jsp页面");
        Object user = session.getAttribute("user");
        //若未登录，则跳转到登录页面
        if (user==null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    %>
    这是a.jsp页面
</body>
</html>
