<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/18
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

</body>
</html>
