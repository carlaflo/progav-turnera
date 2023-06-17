<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Todos for ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<H1>Your Todos</H1>
		<div>
			<table class="table table-striped">
				<caption>Your Todos are</caption>

				<thead>
					<tr>
						<th>Description</th>
						<th>Date</th>
						<th>Completed</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.desc}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a href="/delete-todo?id=${todo.id}"class="btn btn-danger">Delete</a> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
		<a class="btn btn-success" href="/add-todo">Add</a>
		</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>