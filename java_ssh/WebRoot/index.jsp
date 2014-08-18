<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台登入...</title>
	</head>
	<body>
		<form action="login" method="post">
		<h2>登录:</h2>
		
			<table align="center">
				<tr>
					<td>
						账号:
						<input type="text" name="userName" width="50">
						<br />
					</td>
				</tr>
				<tr>
					<br />
					<br />
					<br />
					<td>
						密码:
						<input type="password" name="password">
					</td>
				</tr>
				<table align="center">
					<input type="submit" value="登陆">
				</table>
			</table>
		</form>
		
		
		<hr>
		
		提示信息:<font color="red">${msg}</font>
		
		
		<hr>
		
		
		
		<form action="register" method="post">
		<h2>注册一个用户:</h2>
		
			<table align="center">
				<tr>
					<td>
						账号:
						<input type="text" name="userName" width="50">
						<br />
					</td>
				</tr>
				<tr>
					<br />
					<br />
					<br />
					<td>
						密码:
						<input type="password" name="password">
					</td>
				</tr>
				<table align="center">
					<input type="submit" value="注册">
				</table>
			</table>
		</form>
		
	</body>
</html>