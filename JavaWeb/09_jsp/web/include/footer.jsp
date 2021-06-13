<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/18
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    页脚信息 <%=request.getParameter("username")%><br>
    更改 <%=request.getParameter("password")%><br>
    测试 <%=request.getAttribute("test")%><br/>
</body>
</html>
