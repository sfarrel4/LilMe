<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="com.lilme.jdodb.ChildAccount" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.lilme.jdodb.PMF" %>
<%@ page import="javax.jdo.Query" %>

<html lang="en">
	<head>
		<title>Show Children</title>
		<link rel="shortcut icon" href="favicon.ico">
		<link rel="stylesheet" href="assets/css/styles.css">
    	<link href='assets/css/bootstrap.min.css' rel='stylesheet'>
	</head>
	<body>
		<div class='navbar navbar-default navbar-static-top'> 
			<div class='container-fluid'>
          		<a href="index.html" class='navbar-brand'>Lil' Me Day Care Logo</a>
				<ul class="nav navbar-nav navbar-right">
            		<li><a href='about.html'>About</a></li>
          		</ul>
			</div>
		</div>
			
		<div class="mainStuff" align="center">
			<%
			String firstName = null;
			String lastName = null;
			String middleInitial = null;
			String dateOfBirth = null;
			int lunchGroup = 0;
			String[] allergies = null;
			int groupNum = Integer.parseInt(request.getParameter("group"));
			
			List<ChildAccount> allChild = ChildAccount.getAllChild();
			
			if (allChild!=null) {%>
				<% switch(groupNum){
					case 1:
						%><center><h2>Lunch Group 1</h2></center><%	
						break;
					case 2:
						%><center><h2>Lunch Group 2</h2></center><%
						break;
					case 3:
						%><center><h2>Lunch Group 3</h2></center><%
						break;
					case 4:
						%><center><h2>All Children</h2></center><%
						break;
				}%>
				
			
			
				<table border="2">
				<tr>
					<td>Last Name</td>
					<td>First Name</td>
					<td>Middle Initial</td>
					<td>Date of Birth</td>
					<td>Allergies</td>
					<td>Lunch Group</td>
				</tr>
			<%	for(int i = 0; i < allChild.size(); i++){
					if (allChild.get(i).getLunchGroup() == groupNum){
						firstName = allChild.get(i).getFirstName();
						lastName = allChild.get(i).getLastName();
						middleInitial = allChild.get(i).getMiddleInitial();
						dateOfBirth = allChild.get(i).getDOB();
						lunchGroup = allChild.get(i).getLunchGroup();
						allergies = allChild.get(i).getAllergies();%>
						<tr>
							<td><%=lastName %></td>
							<td><%=firstName %></td>
							<td><%=middleInitial %></td>
							<td><%=dateOfBirth %></td>
							<td>
					<%	for(int x=0; x < allergies.length; x++ ){
							if(x==allergies.length-1){%>
							<%=	allergies[x]%>
						<%	}else{ %>
							<%=	allergies[x] + ", " %>
						<% 	}
						}%>
						</td>
						<td>Lunch Group <%=lunchGroup %></td>
						</tr><%
					} else if (groupNum == 4){
						firstName = allChild.get(i).getFirstName();
						lastName = allChild.get(i).getLastName();
						middleInitial = allChild.get(i).getMiddleInitial();
						dateOfBirth = allChild.get(i).getDOB();
						lunchGroup = allChild.get(i).getLunchGroup();
						allergies = allChild.get(i).getAllergies();%>
						<tr>
						<td><%=lastName %></td>
						<td><%=firstName %></td>
						<td><%=middleInitial %></td>
						<td><%=dateOfBirth %></td>
						<td>
						<%	for(int x=0; x < allergies.length; x++ ){
								if(x==allergies.length-1){%>
								<%=	allergies[x]%>
							<%	}else{ %>
								<%=	allergies[x] + ", " %>
							<% 	}
							}%>
						</td>
						<td>Lunch Group <%=lunchGroup %></td>
						</tr>
				<%	}
				}%>
			</table>
		<%	}else if(allChild == null){%>
				<h1>No child data found</h1><%
			}	%>
		</div>
		
		<div class='navbar navbar-default navbar-static-bottom'> 
    		<div class='container-fluid'>
            	<center>Lil' Me Day Care &copy;2015.</center>
			</div>
		</div>
	</body>
</html>