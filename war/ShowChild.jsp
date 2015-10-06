<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="com.lilme.jdodb.ChildAccount" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.lilme.jdodb.PMF" %>
<%@ page import="javax.jdo.Query" %>

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
					<%
					
						String firstName = null;
						
						List<ChildAccount> allChild = ChildAccount.getAllChild();
						
						
						if (allChild!=null) {
							
							for(int i = 0; i < allChild.size(); i++){
								firstName = allChild.get(i).getFirstName();
							
						
						}}
						
					%>
					<table border="1">
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
							<%=firstName %>
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