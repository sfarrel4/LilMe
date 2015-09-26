<%@ page import="java.util.*" %>
<html>
<head>
</head>

<body>
<%
	List<String> firstNameList = new ArrayList<String>();
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



</body>




</html>