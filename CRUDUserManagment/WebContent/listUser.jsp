
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
</head>
<body>
	<p>
		<a href="UserController?action=insert">Add User</a>
		<a href="UserController?action=searchUser">Search User</a>
	</p>
	<table border=1>
		<thead>
			<tr>

				<td>firstName</td>
				<td>lastName</td>
				<td>dateOfBirth</td>
				<td>phoneNumber</td>
				<td><center>email</center></td>
				<td colspan=4><center>Action</center></td>

			</tr>

		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.dateOfBirth}" /></td>
					<td><c:out value="${user.phoneNumber}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><a
						href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
					<td><a
						href="UserController?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
					<td><a
						href="UserController?action=sort&userId=<c:out value="${user.userid}"/>">SortLastName</a></td>
					<td><a
						href="UserController?action=sort&userId=<c:out value="${user.userid}"/>">SortDateOfBirth</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</body>
</html>