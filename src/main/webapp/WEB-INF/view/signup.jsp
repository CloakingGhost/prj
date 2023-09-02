<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Sign Up</h2>
	<div id="login-form">
		<form action="/signup" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div>
				<label for="username">아이디 : </label><input type="text" id="username"
					name="username" placeholder="Username" required autofocus />
			</div>
			<div>

				<label for="password">비밀번호 : </label><input type="password"
					id="password" name="password" placeholder="Password" required
					autofocus />
			</div>
			<div>
				<input type="submit" value="send">
			</div>
		</form>
	</div>
	<div>${result }</div>
</body>
</html>