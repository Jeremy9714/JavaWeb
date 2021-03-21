<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作用域输出数据</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1","pageContextValue1");
        pageContext.setAttribute("key2","pageContextValue2");
        request.setAttribute("key1","requestValue1");
        request.setAttribute("key2","requestValue2");
        session.setAttribute("key1","sessionValue1");
        session.setAttribute("key2","sessionValue2");
        application.setAttribute("key1","applicationValue1");
        application.setAttribute("key2","applicationValue2");
    %>
    <%--获取四个特定域中的属性--%>
<%--    ${ key1} <br>--%>
    ${ pageScope.key1 } <br>
    ${ requestScope.key2 } <br>
    ${ sessionScope.key1 } <br>
    ${ applicationScope.key2 } <br>

</body>
</html>
