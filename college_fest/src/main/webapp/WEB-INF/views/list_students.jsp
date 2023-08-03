<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>student</title>
</head>

<body>

	<div class="container">

		<h3>Students Debate Directory</h3>
		<hr>

		<!-- Add a search form -->




		<!-- Add a button -->
		<a href="/student/new" class="btn btn-primary btn-sm mb-3"> Add
			Student </a> 
			
		<a href="/logout" class="btn btn-primary btn-sm mb-3 mx-auto">
			Logout </a>

		</form>


		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Student Id</th>
					<th>First Name</th>
					<th>Last name</th>
					<th>Course</th>
					<th>Country</th>

					<th>Action</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${stu_list}" var="tempstudent">
					<tr>
						<td><c:out value="${tempstudent.s_id}" /></td>
						<td><c:out value="${tempstudent.firstName}" /></td>
						<td><c:out value="${tempstudent.lastName}" /></td>
						<td><c:out value="${tempstudent.course}" /></td>
						<td><c:out value="${tempstudent.country}" /></td>

						<td>
							<!-- Add "update" button/link --> <a
							href="/student/update?s_id=${tempstudent.s_id}"
							class="btn btn-info btn-sm"> Update </a> 
							
							<!-- Add "delete" button/link -->
							<a href="/student/delete?del_id=${tempstudent.s_id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
								Delete </a>

						</td>


					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>