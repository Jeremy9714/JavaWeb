<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/common/header.jsp"%>
	<script type="text/javascript">
		$(function () {

			//给注册按钮绑定单击事件
			$("#sub_btn").click(function () {
				//验证用户名: 必须由字母、数字、下划线组成，长度在5~12位
				var $usernameText = $("#username").val();
				var pattText = /^\w{5,12}$/;
				if(!pattText.test($usernameText)){
					$("span.errorMsg").text("用户名不合法!");
					return false;
				}
				//验证密码: 必须由字母、数字、下划线组成，长度在5~12位
				var $passwordText = $("#password").val();
				var pattPwd = /^\w{5,12}$/;
				if(!pattPwd.test($passwordText)){
					$("span.errorMsg").text("密码不合法!");
					return false;
				}
				//验证确认密码: 和密码相同
				var $rePwd = $("#repwd").val();
				if($passwordText!=$rePwd){
					$("span.errorMsg").text("密码不一致!");
					return false;
				}
				//验证邮箱: xxxxx@xxx.com
				var $emailText = $("#email").val();
				var pattEmail = /^[A-z\d]+@[A-z\d]+\.com$/;
				if(!pattEmail.test($emailText)){
					$("span.errorMsg").text("邮箱不合法!");
					return false;
				}
				//验证码: 暂时只需要验证用户已输入
				var $codeText = $("#code").val();
				//alert("去空格前: " + $codeText);
				$codeText = $.trim($codeText);
				//alert("去空格后: " + $codeText);
				if($codeText==null|$codeText==""){
					$("span.errorMsg").text("请输入验证码!");
					return false;
				}
				$("span.errorMsg").text("");
			});

			//给验证码的图片绑定单击事件
			$("#code_img").click(function () {
				/*
				* src属性用于设置图片的路径
				* 在请求中加上唯一的参数，用来解决缓存问题
				* */
				this.src = "${basePath}kaptcha.jpg?=" + new Date();
			})

		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}

</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
										   value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
                                           value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 80px;" name="code" id="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 110px; heigth: 30px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />

								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@ include file="/common/footer.jsp"%>
</body>
</html>