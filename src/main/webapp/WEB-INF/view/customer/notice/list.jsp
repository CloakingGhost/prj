<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="container">
	List <br> <a href="/">Index Page</a> <br> <a
		href="/customer/notice/detail">Detail Page</a>
	<table>
		<c:forEach var="item" items="${list}">
			<tr>
				<%-- <td>${item.id }</td> --%>
				<td>${item.title }</td>
				<td>${item.writerId }</td>
				<%-- <td>${item.entryDate }</td>
				<td>${item.modifyDate }</td> --%>
			</tr>
		</c:forEach>
	</table>
</main>