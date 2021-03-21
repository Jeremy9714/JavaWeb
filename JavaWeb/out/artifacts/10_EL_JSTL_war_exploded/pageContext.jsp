<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //使得使用EL表达式时，代码更简洁
        pageContext.setAttribute("req",request);
        pageContext.setAttribute("session",session);
    %>
    <%--request.getScheme() 获取请求的协议--%>
    1.协议: ${pageContext.request.scheme} <br>
    <%--request.getServerName() 获取请求的服务器ip地址--%>
    2.服务器ip: ${pageContext.request.serverName} <br>
    <%--request.getServerPort() 获取请求的服务器的端口号--%>
    3.服务器端口号: ${pageContext.request.serverPort} <br>
    <%--request.getContextPath() 获取当前工程路径--%>
    4.获取工程路径: ${req.contextPath} <br>
    <%--request.getMethod() 获取请求的方式--%>
    5.获取请求方法: ${req.method} <br>
    <%--request.getRemoteHost() 获取客户端的ip地址--%>
    6.获取客户端ip地址: ${req.remoteHost} <br>
    <%--session.getId() 获取会话的唯一标识符--%>
    7.获取会话的id: ${session.id} <br>

</body>
</html>
