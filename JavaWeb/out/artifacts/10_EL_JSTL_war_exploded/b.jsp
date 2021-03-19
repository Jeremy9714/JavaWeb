<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    <%-- 当四个域中都存在相同的key时，EL表达式会按照域的范围以从小到大的顺序进行搜索，找到就输出--%>
    ${key}
</body>
</html>
