<%@ page import="bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 20:36
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
<%--forEach标签所有属性组合使用--%>
<%
    List<Student> list = new ArrayList<>();
    for (int i=1;i<=10;++i){
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
        <th>状态</th>
    </tr>
    <%--
        step属性设置遍历的步长值(默认为1)
        varStatus属性表示当前遍历到的数据的状态
    --%>
    <c:forEach begin="0" end="7" step="2" varStatus="Status" items="${requestScope.list}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.username}</td>
            <td>${student.password}</td>
            <td>${student.age}</td>
            <td>${student.phone}</td>
            <%--
                boolean类型的属性的读方法为isXXX()
            --%>
            <td>${Status.last}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
