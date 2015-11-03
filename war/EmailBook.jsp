<%@ page import="java.util.*" %>
<%@ page import="com.lilme.jdodb.ParentAccount" %>
<%@ page import="com.lilme.jdodb.ChildAccount" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.lilme.jdodb.PMF" %>
<%@ page import="javax.jdo.Query" %>
<html>
<head>
<title></title>
</head>
<body>
<form action="/email-book" method="post">

	<%
			String firstName = null;
			String lastName = null;
			String middleInitial = null;
			String email = null;
			Long childID = null;
			List<ParentAccount> allParent= ParentAccount.getAllParent();
	
	
	
			for(int i = 0; i < allParent.size(); i++){
					
				
				
			}
				
	
	%>


</form>



</body>

</html>