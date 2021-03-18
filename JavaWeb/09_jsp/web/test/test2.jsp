<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/18
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>遍历输出学生信息到表格中</title>
    <style type="text/css">
        table{
            border: 1px blue solid;
            width: 600px;
            border-collapse: collapse;
        }
        th,td{
            border: 1px blue solid;
        }
    </style>
</head>
<body>
    <%
        List<Student> list = new ArrayList<>();
        for (int i =0;i<10;i++){
            int t = i+1;
            list.add(new Student(t, "name_" + t, 18+t, "phone" + t));
        }
    %>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>phone</th>
        <th>modify</th>
    </tr>
    <% for (Student student : list) { %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getPhone()%></td>
        <td><%="删除、修改"%></td>
    </tr>
    <% }%>
</table>
</body>
</html>
