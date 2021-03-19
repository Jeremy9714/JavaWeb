<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>

    <%--表达式脚本输出null值时，会输出null字符串--%>
    表达式脚本输出数据: <%=request.getAttribute("key1")%><br>
    <%--EL表达式输出null值时，会输出空串--%>
    EL表达式输出数据: ${key1}
</body>
</html>
