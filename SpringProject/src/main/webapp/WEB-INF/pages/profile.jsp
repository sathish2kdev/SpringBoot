
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
.photo {
	padding: 30px;
	border: 1px solid;
}

.value {
	padding: 30px;
	font-size: large;
	text-align: justify;
	color: blue;
}

.value label {
	color: black;
}
.img{
    padding: 5px 45px 5px 45px;
}
body {
	min-height: 100vh;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div align="center">
			<br />
			<h1>Student Profile</h1>
			<br />
			<div class="row" style="margin: 30px;">
				<div class="col-lg-8 photo">
					<c:forEach var="img" items="${studentData.imagePath}">
						<img src="${img}" alt="empty" width="360" class="img" height="250" />
					</c:forEach>

				</div>
				<div class="col-lg-4 value">
				<br />
				<br />
					<label>Student Roll Number : </label> <a>${studentData.studentRollNumber}</a><br />
					<label>Student Name : </label> <a>${studentData.studentName}</a><br />
					<label>Joined Date : </label> <a>${studentData.dateOfJoining}</a><br />
					<label>Department Name : </label> <a>${studentData.departmentName}</a><br />
					<label>Fees Paid Status : </label> <a>${studentData.feesPaidStatus}</a>
				</div>
			</div>

		</div>
	</div>

</body>
</html>