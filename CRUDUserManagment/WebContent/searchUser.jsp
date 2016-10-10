<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action='UserController' name="SearchUser">
		<table cellpadding="5" cellspacing="5">
			<tr>
				<td>Search User</td>
				<td><input type="text" name="search" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="search" /></td>
			</tr>

		</table>
		
		<table border=1>
			<thead>
				<tr>
					<td>firstName</td>
					<td>lastName</td>
					<td>dateOfBirth</td>
					<td>phoneNumber</td>
					<td>email</td>
				</tr>

			</thead>
			<tbody>
				<c:forEach var="search" items="${user}">
					<tr>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.dateOfBirth}" /></td>
						<td><c:out value="${user.phoneNumber}" /></td>
						<td><c:out value="${user.email}" /></td>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>