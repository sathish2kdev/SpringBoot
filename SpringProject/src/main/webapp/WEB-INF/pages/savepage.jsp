<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
<style>
body{
font-size: large;
}
label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

input[type=text], input[type=password], select {
	width: 200px;
}

input[type=radio] {
	display: inline-block;
	margin-left: 45px;
}

input[type=checkbox] {
	display: inline-block;
	margin-right: 190px;
}

button {
	padding: 10px;
	margin: 10px;
}

.imgArr {
	display: block;
}

div.a {
	word-wrap: break-word;
}

.error {
	color: red;
	font-style: italic;
}
.sup{
color: red;
}

</style>
</head>
<body>

	<div align="center">
		<br /> <br />
		<h2>User Registration</h2>
		<br /> <br />
		<form:form action="saveStudentDetails" method="post"
			enctype="multipart/form-data" modelAttribute="studentForm">
			<form:label path="departmentName">Department Name <sup class="sup">*</sup> :</form:label>
			<form:select path="departmentName" items="${deparment}" />
			<form:errors path="departmentName" cssClass="error" />
			<br />
			<br />
			<form:label path="studentRollNumber">Student Roll Number <sup class="sup">*</sup> :</form:label>
			<form:input path="studentRollNumber" />
			<div style="margin: 0px 0px 0px 236px;" class="a">
				<form:errors path="studentRollNumber" cssClass="error" />
			</div>

			<br />
			<br />
			<form:label path="studentName">Student Name <sup class="sup">*</sup> :</form:label>
			<form:input path="studentName" />
			<div style="margin: 0px 0px 0px 236px;" class="a">
				<form:errors path="studentName" cssClass="error" />
			</div>
			
			<br />
			<br />
			<form:label path="dateOfJoining" style="margin-left: -58px;">Joined Date <sup class="sup">*</sup> :</form:label>
			<form:input path="dateOfJoining" type="date" />
			<div style="margin: 0px 0px 0px 236px;" class="a">
				<form:errors path="dateOfJoining" cssClass="error" />
			</div>
			
			<br />
			<br />


			<form:label path="feesPaidStatus">Fees Paid Status <sup class="sup">*</sup> :</form:label>
			<form:radiobutton path="feesPaidStatus" value="YES" />Paid
            <form:radiobutton path="feesPaidStatus" value="NO" />Not yet
            <div style="margin: 0px 0px 0px 236px;" class="a">
				 <form:errors path="feesPaidStatus" class="error" />
			</div>
           
			<br />
			<br />

			<div class="container-fluid">
				<div class="row" style="margin: 30px;">
					<div class="col-lg-6">
						<p style="margin-left: 586px;">
							Students Photos <sup class="sup">*</sup>
							<!-- <p style="margin-left: 376px;"> -->
						<div style="margin-left: 586px;" class="a">(5 photos Any
							Educational Activity Photos)</div>
						</p>
					</div>
					<div class="col-lg-2">
						<form:input type="file" path="image"
							accept="image/png, image/jpeg" />
					</div>
					<div class="col-lg-2">
						<form:input type="file" path="image1"
							accept="image/png, image/jpeg" />
					</div>
					<div class="col-lg-2">
						<form:input type="file" path="image2"
							accept="image/png, image/jpeg" />
					</div>
					<br />
					<div class="col-lg-6"></div>
					<div class="col-lg-2">
						<form:input type="file" path="image3"
							accept="image/png, image/jpeg" />
					</div>
					<div class="col-lg-2">
						<form:input type="file" path="image4"
							accept="image/png, image/jpeg" />
					</div>

				</div>
			</div>

			<br />
			<br />
			<form:button class="btn btn-success">SAVE</form:button>
		</form:form>
		</form>

	</div>


</body>
</html>