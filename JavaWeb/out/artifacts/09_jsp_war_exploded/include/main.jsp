<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/18
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息 <br>
    主体内容 <br>
    <%
        request.setAttribute("test","test");
    %>
    <%--
        <%@ include file=""%> 就是静态包含
            file属性指定要包含的jsp页面的路径
    --%>
    <%@ include file="/include/footer.jsp"%>

    <%--
        <jsp:include page=""></jsp:include>
            page属性指定要包含的jsp页面的路径
        动态包含还可以传递参数
    --%>
<%--    <jsp:include page="footer.jsp">--%>
<%--        <jsp:param name="username" value="uesr1"/>--%>
<%--        <jsp:param name="password" value="pin"/>--%>
<%--    </jsp:include>--%>


</body>
</html>
