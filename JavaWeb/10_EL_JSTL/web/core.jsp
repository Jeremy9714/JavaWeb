<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--set标签可以往域中保存数据--%>
    保存之前: ${requestScope.abc} <br>
    <%--
        相当于域对象.setAttribute(key,value)
            scope属性设置保存到哪个域
            var属性设置key是多少
            value属性设置值
    --%>
    <c:set scope="request" var="abc" value="abcValue"/>
    保存之后: ${requestScope.abc} <br>
    <hr>

    <%--if标签用来做if判断--%>
    <%--test属性表示判断的条件(用EL表达式输出)--%>
    <c:if test="${11 eq 11}">
        <h1>表达式正确</h1>
    </c:if>
    <hr>

    <%--多路判断--%>
    <%
        pageContext.setAttribute("key",0);
    %>
    <%--choose标签表示开始选择判断--%>
    <c:choose>
        <%--when标签表示每一种判断情况；test属性表示当前情况的值--%>
        <c:when test="${pageScope.key>10}">
            <h2>很高的分数</h2>
        </c:when>
        <c:when test="${pageScope.key>5}">
            <h2>及格的分数</h2>
        </c:when>
        <%--otherwise标签表示剩下的判断情况--%>
        <c:otherwise>
            <%--when标签的父标签必须为choose标签--%>
            <c:choose>
                <c:when test="${pageScope.key>0}">
                    <h3>危险的分数</h3>
                </c:when>
                <c:when test="${pageScope.key==0}">
                    <h3>神奇的分数</h3>
                </c:when>
            </c:choose>
        </c:otherwise>
    </c:choose>
    <hr>


</body>
</html>
