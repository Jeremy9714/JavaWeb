<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/18
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--声明脚本, 可以给jsp翻译出来的java类定义属性、方法、静态代码块、内部类等--%>
<%--1.声明类属性--%>
    <%!
        private Integer id;
        private String name;
        private static Map<String, Object> map;
    %>

<%--2.声明静态代码块--%>
    <%!
        static{
            map = new HashMap<>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }
    %>

<%--3.声明方法--%>
    <%!
        public int getNumber(){
            return 12;
        }
    %>

<%--4.声明内部类--%>
    <%!
        private class innerClass{
            private Integer id = 10;
            private String name = "innerName";
        }
    %>

<%--表达式脚本--%>
<%--1.输出整型--%>
    <%=10%><br/>

<%--2.输出浮点型--%>
    <%=1.23%><br/>

<%--3.输出字符串--%>
    <%="这是一句话"%><br/>

<%--4.输出对象--%>
    <%=map%><br/>
    <%=request.getHeader("Accept-Encoding")%><br/>
    <%=request.getParameter("username")%>

<%--代码脚本--%>
<%--1.if语句--%>
    <%
        boolean flag = true;
        if(flag){
            System.out.println("flag is true");
        }
    %><br/>

<%--for循环语句; 代码脚本可以由都多个代码脚本，组合完成一个完整的java语句--%>
    <%
        for (int i = 0; i < 10; ++i){
    %>
    <%        System.out.println("当前为" + i);
        }
    %><br/>

<%--_jspService()方法中的代码都可以写--%>
    <%
        System.out.println(getNumber());
    %>

<%--代码脚本可以和表达式脚本组合使用--%>
    <%
        for (int i =0; i< 10; ++i){
    %>
        <%=i%><br/>
    <%
        }
    %>

<table border="1">
    <%
        for (int i =0;i<9;++i){
    %>
    <tr><td>这是第<%=i+1%>行</td></tr>
    <%
        }
    %>
</table>

</body>
</html>
