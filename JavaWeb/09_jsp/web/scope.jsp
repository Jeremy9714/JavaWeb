<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/18
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope页面</h1>
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>

    pageContext域的值: <%=pageContext.getAttribute("key")%><br>
    request域的值: <%=request.getAttribute("key")%><br>
    session域的值: <%=session.getAttribute("key")%><br>
    application域的值: <%=application.getAttribute("key")%><br>

    <%
        //request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>

    <%--
        <jsp:forward page=""></jsp:forward>是请求转发标签，用于请求转发
    --%>
    <jsp:forward page="/scope2.jsp"></jsp:forward>

</body>
</html>
