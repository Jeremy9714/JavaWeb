<%@ page import="org.apache.jasper.runtime.JspWriterImpl" %><%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/18
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
//        out.write("out输出一<br>");
//        //释放out流缓冲区, 将数据追加到response缓冲区末尾
//        out.flush();
//        out.write("out输出二<br>");
//
//        //当jsp页面中所有代码执行完后，会自动执行out.flush()方法
//        response.getWriter().write("response输出一<br>");
//        response.getWriter().write("response输出二<br>");

        //write()输出字符串；底层会把数据转换为char型，并保存到缓冲区char[] cb中
        out.write(12);
        //print()可以输出任何类型的数据(内部先将数据转换为字符串，在调用write()方法)
        out.print(12);
    %>
</body>
</html>
