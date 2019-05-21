<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>极客学院-Java无限级分销管理系统</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/login.css" type="text/css">
</head>

<body>
	<div class="wrapper">

			<div class="admin_login_main">
				<div class="admin_login_logo">无限级分销管理系统</div>
				<div class="admin_login_wrap">
					<input id="account" class="admin_login_name inputs"
						type="text" value="" /> <input id="password" type="password" class="admin_login_pwd inputs" value=""
						autocomplete="off" />
					<div class="tips_wrap">
						<span class="tips"><a href="getpass.jsp">忘记密码？</a></span>
						<button type="submit" class="admin_login_btn"></button>
						<span class="link_pwd"></span>
					</div>
				</div>
			</div>


	</div>

	<div id="Bottom">&copy;极客学院 2015</div>

    <script type="text/javascript" src = "js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src = "js/login.js"></script>
</body>
</html>