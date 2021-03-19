<%@ page import="bean.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Chenyang
  Date: 2021/3/19
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("person");
        person.setPhones(new String[]{"001","002","003"});
        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        person.setCities(list);
        Map<String, String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);
        pageContext.setAttribute("person",person);
    %>

    输出person对象: ${person} <br>
    输出person的name属性: ${person.name} <br>
    输出person的phones数组属性: ${person.phones[0]} <br>
    输出person的cities集合中的元素: ${person.cities} <br>
    输出person的List集合中的个别元素: ${person.cities[0]} <br>
    输出person的map集合中的元素: ${person.map} <br>
    输出person的Map结合中的个别元素: ${person.map.key1} <br>
    输出person的Map结合中的个别元素: ${person.map.get("key2")} <br>
    输出person的Map结合中的个别元素: ${person.map["key3"]} <br>

    <%--EL表达式获取对象属性是通过调用对应get方法获取的--%>
<%--    输出person的age属性: ${person.age} <br>--%>
</body>
</html>
