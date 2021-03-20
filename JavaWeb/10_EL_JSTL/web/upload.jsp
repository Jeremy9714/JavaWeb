<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/20
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/10_EL_JSTL/uploadServlet" method="post" enctype="multipart/form-data">
        用户名: <input type="text" name="username"/><br>
        图片: <input type="file" name="photo"/><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
