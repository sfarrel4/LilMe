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
						String lastName = null;
						String middleInitial = null;
						String dateOfBirth = null;
						int lunchGroup = 0;
						List<ChildAccount> allChild = ChildAccount.getAllChild();
						
						
						if (allChild!=null) {
						
						
						
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
						<%	for(int i = 0; i < allChild.size(); i++){
							firstName = allChild.get(i).getFirstName();
							lastName = allChild.get(i).getLastName();
							middleInitial = allChild.get(i).getMiddleInitial();
							dateOfBirth = allChild.get(i).getDOB();
							lunchGroup = allChild.get(i).getLunchGroup();
							
						
						
						%>
						<tr>
						<td>
							<%=lastName %>
						</td>
						<td>
							<%=firstName %>
						</td>
						<td>
							<%=middleInitial %>
						</td>
						<td>
							<%=dateOfBirth %>
						</td>
						<td>
						</td>
						<td>
							Lunch group <%=lunchGroup %>
						</td>
					</tr>
					
				<%
						}
					%>
					</table>
						<% }else if(allChild == null){
						
						
				%>
				<h1>No child data found</h1>
				<%} %>
		</div>
			<div class="footer">
				<center>Demo 10/1/2015 -- IT 390</center>
			</div>
		</div>
	</body>
</html>