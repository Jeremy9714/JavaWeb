<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@ include file="/common/header.jsp"%>
<script type="text/javascript">
	$(function(){

		//给删除的a标签绑定单击事件，用于删除的确认提示
		$("a.deleteClass").click(function(){
			var name = $(this).parent().siblings().first().text();
			return confirm("确定要删除 ["+name+"] 吗?");
		})

	})
</script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@ include file="/common/manager_menu.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${requestScope.page.items}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
				<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
				<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
			</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>
		</table><br>

		<div id="page_nav">
			<%--如果已经是第一页，则不显示上一页和首页--%>
			<c:if test="${requestScope.page.pageNo > 1}">
			<a href="manager/bookServlet?action=page&pageNo=1">首页</a>
			<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>

			<%--页码输出的开始--%>
			<c:choose>
				<%--情况一: 总页码数小于等于5-- 页码范围[1,总页码数] --%>
				<c:when test="${requestScope.page.pageTotal <= 5}">
					<c:set var="begin" value="1"/>
					<c:set var="end" value="${requestScope.page.pageTotal}"/>
				</c:when>
				<c:when test="${requestScope.page.pageTotal > 5}">
					<c:choose>
						<%--情况二: 总页码数大于5，且当前页码在前三页-- 页码范围[1,5] --%>
						<c:when test="${requestScope.page.pageNo <= 3}">
							<c:set var="begin" value="1"/>
							<c:set var="end" value="5"/>
						</c:when>
						<%--情况三: 总页码数大于5，且当前页码在后三页-- 页码范围[总页码数-4,总页码数] --%>
						<c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
							<c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
							<c:set var="end" value="${requestScope.page.pageTotal}"/>
						</c:when>
						<%--剩余情况-- 页码范围[当前页码数-2,当前页码数+2] --%>
						<c:otherwise>
							<c:set var="begin" value="${requestScope.page.pageNo-2}"/>
							<c:set var="end" value="${requestScope.page.pageNo+2}"/>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>

			<c:forEach begin="${begin}" end="${end}" var="index">
				<c:if test="${index == requestScope.page.pageNo}">
					【${index}】
				</c:if>
				<c:if test="${index != requestScope.page.pageNo}">
					<a href="manager/bookServlet?action=page&pageNo=${index}">${index}</a>
				</c:if>
			</c:forEach>
			<%--页码输出的结束--%>

			<%--如果已经是最后一页，则不显示下一页和末页--%>
			<c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
			<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
			<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>

			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
			到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
			<input id="searchPageBtn" type="button" value="确定">

			<script type="text/javascript">

				$(function (){
					$("#searchPageBtn").click(function () {
						var pageNo = $("#pn_input").val();

						<%--//保证跳转的页面是存在的--%>
						<%--if (pageNo<1 || pageNo>${requestScope.page.pageTotal}){--%>
						<%--	alert("无效的范围");--%>
						<%--	return false;--%>
						<%--}--%>

						//javascript语言中提供了一个location地址栏对象
						//它有一个属性href,可以获取或设置地址栏中的地址
						location.href = "${pageScope.bathpath}manager/bookServlet?action=page&pageNo="
								+ pageNo;
					})
				})

			</script>
		</div>

	</div>

	<%@ include file="/common/footer.jsp"%>
</body>
</html>