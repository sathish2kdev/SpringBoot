
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">

</style>
</head>
<body>
	<div align="center">
		<br />
		<br />
		<h1>Student List</h1>
		<br />
		<br />
		<table border="1" cellpadding="10">
			<thead>
				<tr>
					<th>S NO</th>
					<th>Student Name</th>
					<th>Roll Number</th>
					<th>Joined Date</th>
					<th>Fees Paid Status</th>
					<th>Department</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="x" value="${1}" />
				<c:forEach var="v" items="${listStudents}">
					<tr>
						<td>${x}</td>
						<td>${v.studentName}</td>
						<td>${v.studentRollNumber}</td>
						<td>${v.dateOfJoining}</td>
						<td>${v.feesPaidStatus}</td>
						<td>${v.departmentName}</td>
						<td><button type="button" class="btn btn-primary"
								onclick="location.href='http://localhost:8080/StudentDetailsBasedOnId?id=${v.studentId}'">CLICK</button></td>
						<c:set var="x" value="${x + 1}" />
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>