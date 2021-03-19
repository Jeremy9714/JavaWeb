<%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--EL表达式关系运算--%>
    ${12 == 11} 或 ${12 eq 11} <br>
    ${12 != 11} 或 ${12 ne 11} <br>
    ${12 > 11} 或 ${12 gt 11} <br>
    ${12 < 11} 或 ${12 lt 11} <br>
    ${12 >= 11} 或 ${12 ge 11} <br>
    ${12 <= 11} 或 ${12 le 11} <br><hr/>

    <%--EL表达式逻辑运算--%>
    ${12 == 11 && 12 > 11} 或 ${12 == 11 and 12 > 11} <br>
    ${12 == 11 || 12 > 11} 或 ${12 == 11 or 12 > 11} <br>
    ${!true} 或 ${not true} <br><hr/>

    <%--EL表达式算术运算--%>
    ${18 + 12} <br>
    ${18 - 12} <br>
    ${18 * 12} <br>
    ${18 / 12} 或 ${18 div 12} <br>
    ${18 % 12} 或 ${18 mod 12} <br>


</body>
</html>
