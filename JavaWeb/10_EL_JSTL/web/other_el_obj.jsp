<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    输出请求参数username的值: ${param.username} <br>
    输出请求参数password的值: ${param.password} <br>

    输出请求参数username的值: ${paramValues.username[0]} <br>
    输出请求参数hobby的值: ${paramValues.hobby[0]} <br>
    输出请求参数hobby的值: ${paramValues.hobby[1]} <br>
    <hr>

    输出请求头[User-Agent]的值: ${header["User-Agent"]} <br>
    输出请求头[Host]的值: ${header["Host"]} <br>
    输出请求头[User-Agent]的值: ${headerValues["User-Agent"][0]} <br>
    <hr>

    cookie: ${cookie} <br>
    获取cookie的名称: ${cookie.JSESSIONID.name} <br>
    获取cookie的值: ${cookie.JSESSIONID.value} <br>
    <hr>

    context_param: ${initParam} <br>
    输出&ltcontext-param&gt的值: ${initParam.username} <br>
    输出&ltcontext-param&gt的值: ${initParam.url} <br>
</body>
</html>
