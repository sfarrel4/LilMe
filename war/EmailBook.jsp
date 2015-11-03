<%@ page import="java.util.*" %>
<%@ page import="com.lilme.jdodb.ParentAccount" %>
<%@ page import="com.lilme.jdodb.ChildAccount" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.lilme.jdodb.PMF" %>
<%@ page import="javax.jdo.Query" %>
<%@ page import="com.lilme.jdodb.BookObject" %>
<html>
<head>
<title></title>
</head>
<body>
<form action="/email-book" method="post">
	<select name="email">
	<option>--Parents--</option>
	<%
			String firstName = null;
			String lastName = null;
			String middleInitial = null;
			String email = null;
			Long childID = null;
			List<ParentAccount> allParent= ParentAccount.getAllParent();
			
			String bookTitle = null;
			String bookSynop = null;
			String bookImageURL = null;
			Long bookID = null;
			List<BookObject> allBook = BookObject.getAllBooks();
	
	
			for(int i = 0; i < allParent.size(); i++){
				firstName = allParent.get(i).getFirstName();
				lastName = allParent.get(i).getLastName();
				middleInitial = allParent.get(i).getMiddleInitial();
				email = allParent.get(i).getEmail();
			%>	
				<option value="<%=email %>"><%= firstName %>" "<%= middleInitial %>" "<%= lastName %></option>
				
			<%}
			
				
	
	%>
	</select>
	<select name="book">
	<option>--Books--</option>
	
	<%
		for(int i= 0; i< allBook.size(); i++){
			bookID = allBook.get(i).getId();
			bookTitle = allBook.get(i).getBookTitle();
	%>
		<option value="<%=bookID %>"><%=bookTitle %>"</option>
		<%}
	
	%>
	
	</select>
<input type="submit" value="Submit" />
</form>



</body>

</html>