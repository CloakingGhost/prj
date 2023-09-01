<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<header id="header">
	<div class="container">
		헤더
		<sec:authorize access="isAuthenticated()">
			<form action="/logout" method="post">
				<input type="submit" value="Logout">
				<input name="${_csrf.parameterName}" type="hidden"
					value="${_csrf.token}" />
			</form>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">로그인하시오</sec:authorize>
		<sec:authorize access="permitAll()">어시오시오</sec:authorize>
	</div>
</header>