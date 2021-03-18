<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/18
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
    <style type="text/css">
        table{
            width: 700px;
            height: 300px
        }
    </style>
</head>
<body>
<h1 align="center">九九乘法表</h1>
<table align="center">
    <%
        for (int i =1;i<10;++i){
    %>
    <tr>
    <%
            for (int j=1;j<=i;++j){
    %>
        <td><%=j + "x" + i + "=" + (i*j)%></td>
            <%}%>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
