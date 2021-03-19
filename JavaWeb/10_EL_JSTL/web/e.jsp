<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--empty运算: 用于判断一个数据是否为空--%>
    <%
        //数据为空的情况
        //1.值为null的时候
        request.setAttribute("emptyNull",null);
        //2.值为空串的时候
        request.setAttribute("emptyStr","");
        //3.Object类型的数组长度为0的时候
        request.setAttribute("emptyArr",new Object[]{});
        //4.List集合的元素个数为0的时候
        request.setAttribute("emptyList",new ArrayList<>());
        //5.Map集合的元素个数为0的时候
        request.setAttribute("emptyMap",new HashMap<>());
    %>
    ${empty emptyNull} <br>
    ${empty emptyStr} <br>
    ${empty emptyArr} <br>
    ${empty emptyList} <br>
    ${empty emptyMap} <br><hr/>

    <%--三元表达式--%>
    ${12 ne 12 ? "不相等的表达式" : "相等的表达式"}
</body>
</html>
