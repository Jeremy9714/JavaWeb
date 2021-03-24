<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
		$(function(){

			//给【删除】绑定单击事件
			$("a.deleteItem").click(function(){
				var name = $(this).parent().siblings().first().text();
				return confirm("确定要删除 ["+name+"] 吗?");
			})

			//给【清空购物车】绑定单击事件
			$("a.clearCart").click(function(){
				return confirm("确定要清空购物车吗?");
			})

			//给【修改商品数量】绑定内容发生改变事件事件
			$(".updateCount").change(function(){
				var name = $(this).parent().prev().text();
				var count = this.value;
				var id = $(this).attr("bookId");
				var flag = confirm("确定要修改 [" + name + "] 数量为"+count+"吗?");
				if (flag){
					location.href = "${basePath}cartServlet?action=updateItem&count="+count+"&bookId="+id;
				}else{
					//defaultValue属性表示默认的value属性值
					this.value = this.defaultValue;
					return flag;
				}
			})

		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
		<%--购物车为空的情况--%>
		<c:if test="${empty sessionScope.cart.items}">
			<tr>
				<td colspan="5"><a href="index.jsp">当前购物车为空，点击此处去浏览商品</a></td>
			</tr>
		</c:if>
		<%--购物车非空的情况--%>
		<c:if test="${not empty sessionScope.cart.items}">
			<c:forEach items="${sessionScope.cart.items}" var="cartItem">
				<tr>
					<td>${cartItem.value.name}</td>
					<%--修改当前商品项的数量--%>
					<td>
						<input bookId="${cartItem.value.id}" class="updateCount" style="width: 80px" type="text" value ="${cartItem.value.count}">
					</td>
					<td>${cartItem.value.price}</td>
					<td>${cartItem.value.totalPrice}</td>
					<td><a class="deleteItem" href="cartServlet?action=deleteItem&bookId=${cartItem.value.id}">删除</a></td>
				</tr>
			</c:forEach>
		</c:if>

		</table>
		<%--购物车非空才显示下面的信息--%>
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a class="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
		</div>
		</c:if>

	</div>

	<%@ include file="/common/footer.jsp"%>
</body>
</html>