<!DOCTYPE html>
<%@ page import="java.util.*" %>
<html lang="en">
	<head>
		<title>Show Child</title>
		<link rel="shortcut icon" href="favicon.ico">
		<link rel="stylesheet" href="assets/css/styles.css">
	</head>
	<body>
		<div class="container">
			<div class="header">
				<h1>Lil Me Daycare</h1>
			</div>
			<div class="mainStuff" align="center">
					<center><h2>Show Child</h2></center>
					<%List<String> firstNameList = new ArrayList<String>();
						firstNameList = (ArrayList<String>)request.getAttribute("firstNameList");
					%>
					<table>
						<tr>
							<td>Last Name</td>
							<td>First Name</td>
							<td>Middle Initial</td>
							<td>Date of Birth</td>
							<td>Allergies</td>
							<td>Lunch Group</td>
						</tr>
						<tr>
							<td>blah</td>
						<td>
					<%
					System.out.println(firstNameList.get(0));
					%>
					</td>
					</tr>
					</table>

		</div>
			<div class="footer">
				<center>Demo 10/1/2015 -- IT 390</center>
			</div>
		</div>
	</body>
</html>