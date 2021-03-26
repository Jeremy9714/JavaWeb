<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>结算页面</title>
    <%@ include file="/common/header.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">结算</span>
    <%@ include file="/common/login_success_menu.jsp"%>
</div>

<div id="main">


    很抱歉，您访问的地址不存在，或已被删除！！！<br>
    <a href="index.jsp">返回首页</a>


</div>

<%@ include file="/common/footer.jsp"%>
</body>
</html>