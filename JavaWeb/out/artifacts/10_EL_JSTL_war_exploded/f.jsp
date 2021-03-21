<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--点运算和中括号运算--%>
    <%
        Map<String, Object> map = new HashMap<>();
        map.put("a.a.a","aaaValue");
        map.put("b+b+b","bbbValue");
        map.put("c/c/c","cccValue");

        request.setAttribute("map",map);
    %>
    <%--中括号运算可以输出Map集合中，key含有特殊字符的key的值--%>
<%--    ${map.a.a.a} <br>--%>
    ${map["a.a.a"]} <br>
    ${map["b+b+b"]} <br>
    ${map["c/c/c"]} <br>



</body>
</html>
