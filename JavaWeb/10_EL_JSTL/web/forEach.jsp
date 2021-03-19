<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border: 1px red solid;
            width: 600px;
            border-collapse: collapse;
        }
        th,td{
            border: 1px red solid;
        }
    </style>
</head>
<body>
    <%--forEach标签遍历输出--%>

    <%--1.遍历1到10，并输出--%>
    <%--
        begin属性设置开始的索引
        end属性设置结束的索引
        var属性表示循环的变量
    --%>
    <table>
    <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
    </c:forEach>
    </table>
    <hr>

    <%--2.遍历Object的数组--%>
    <%
        request.setAttribute("arr",new String[]{"string_1","String_2","String_3"});
    %>
    <%--
        items属性表示遍历的数据源(遍历的集合)
        var表示当前遍历到的数据
    --%>
    <c:forEach items="${arr}" var="item">
        ${item} <br>
    </c:forEach>
    <hr>

    <%--3.遍历Map集合--%>
    <%
        Map<String, Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        request.setAttribute("map",map);
    %>
    <c:forEach items="${requestScope.map}" var="entry">
        <h3>${entry.key} = ${entry.value}</h3>
    </c:forEach>
    <hr>

    <%--4.遍历List集合--List中存放Student类对象--%>
    <%
        List<Student> list = new ArrayList<>();
        for (int i=0;i<5;++i){
            list.add(new Student(i,"student_"+i,"pwd_"+i,18+i,"0044"+i));
        }
        request.setAttribute("list",list);
    %>
    <table>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
        </tr>
    <c:forEach items="${requestScope.list}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.username}</td>
            <td>${student.password}</td>
            <td>${student.age}</td>
            <td>${student.phone}</td>
        </tr>
    </c:forEach>
    </table>

</body>
</html>
