

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME PAGE</title>
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
<style>
h1 {
	padding: 62px;
}
</style>
</head>
<body>

	<div align="center">

		<div class="row d-flex align-items-center justify-content-center">
			<div class="col-lg-6 ">
				<h1>Welcome to Student Register Form</h1>
				<br />
				<div class="col-lg-12">
					<button type="button" class="btn btn-primary"
						onclick="location.href='http://localhost:8080/addStudents'">
						Add Student Details</button>
				</div>
				<br />
				<br />
				<div class="col-lg-12">
					<button type="button" class="btn btn-primary"
						onclick="location.href='http://localhost:8080/ListOfStudents'">
						List Student Details</button>
				</div>


			</div>
		</div>
	</div>


</body>
</html>
