<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
		$(function () {
			//给加入购物车按钮绑定单击事件
			$(".addToCart").click(function () {

				//库存为0时，无法添加该商品
				var bookStock = $(this).attr("bookStock");
				if(bookStock==0){
					alert("此商品已售罄");
					return false;
				}

				var bookId = $(this).attr("bookId");
				location.href = "${basePath}cartServlet?action=addItem&bookId=" + bookId;
			})
		})
	</script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>

		<%--如果用户还没有登录，则显示登录和注册的菜单--%>
		<c:if test="${empty sessionScope.user}">
			<div>
				<a href="pages/user/login.jsp">登录</a> |
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
		</c:if>
		<%--如果用户已经登陆，则显示用户登陆成功后的信息--%>
		<c:if test="${not empty sessionScope.user}">
			<div>
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="userServlet?action=logout">注销</a>&nbsp;
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
		</c:if>

	</div>

	<div id="main">
		<div id="book">
			<div class="book_cond">
				<%--根据价格区间分页--%>
				<form action="client/bookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice"/>
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<%--购物车为空的情况--%>
				<c:if test="${empty sessionScope.cart.items}">
				<span> </span>
				<div>
					<span style="color: red">当前购物车为空</span>
				</div>
				</c:if>
				<%--购物车不为空的情况--%>
				<c:if test="${not empty sessionScope.cart.items}">
				<span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
				<div>
					您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
				</div>
				</c:if>
			</div>

            <%--表单开始--%>
            <c:forEach items="${requestScope.page.items}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.imgPath}" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button bookStock="${book.stock}" bookid="${book.id}" class="addToCart">加入购物车</button>
					</div>
				</div>
			</div>
            </c:forEach>
            <%--表单结束--%>

		</div>

		<%--静态包含分页条--%>
		<%@ include file="/common/page_nav.jsp"%>

	</div>

	<%@ include file="/common/footer.jsp"%>
</body>
</html>