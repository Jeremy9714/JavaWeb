<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/25
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("这里是target.jsp页面");
    System.out.println("执行target.jsp页面的线程: " + Thread.currentThread().getName());
    System.out.println("target.jsp获取filter1保存在Request域中的数据: " + request.getAttribute("param"));
%>
</body>
</html>
