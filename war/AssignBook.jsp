<%@ page import="java.util.*" %>
<%@ page import="com.lilme.jdodb.ParentAccount" %>
<%@ page import="com.lilme.jdodb.ChildAccount" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.lilme.jdodb.PMF" %>
<%@ page import="javax.jdo.Query" %>
<%@ page import="com.lilme.jdodb.BookObject" %>
<html lang="en">
	<head>
		<title>Show Books</title>
		<link href="assets/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="assets/css/style.css" rel='stylesheet' type='text/css' />
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script src="assets/js/jquery-1.11.0.min.js"></script>
	<link rel="stylesheet" href="assets/css/flexslider.css" type="text/css" media="screen" />
	<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
	<script src="assets/js/modernizr.js"></script>
	
	<!--Start-smoth-scrolling-->
	<script type="text/javascript" src="assets/js/move-top.js"></script>
	<script type="text/javascript" src="assets/js/easing.js"></script>	
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});
	</script>
	<!--end-smoth-scrolling-->
	<!--animated-css-->
	<link href="assets/css/animate.css" rel="stylesheet" type="text/css" media="all">
	<script src="assets/js/wow.min.js"></script>
	<script>new WOW().init();</script>
	<!--animated-css-->
	</head>
<body>
<div class="mother-grid" id="home">
    	<div class="container">
        	<div class="header clock wow bounceIn">
            	<h1><a href="index.html">Lil Me Daycare</a></h1>
                <div class="nav-top">
                	<span class="menu"><img src="assets/images/menu-icon.png" alt=""></span>
                    <ul class="navgation">
                    	<!-- <li><a class="active" href="CreateChild.jsp" class="scroll">Enroll Child</a></li>
                        <li><a class="active" href="ChooseGroup.jsp" class="scroll">View Lunch Groups</a></li>
                        <li><a class="active" href="CreateParent.jsp" class="scroll">Create Parent</a></li>
                        <li><a class="active" href="ShowParent.jsp" class="scroll">Show Parent</a></li>
                        <li><a class="active" href="EmailBook.jsp" class="scroll">Email Parent</a></li>
                        <li><a class="active" href="CreateBook.jsp" class="scroll">Create Book</a></li>-->
                        <li><a class="active" href="ProviderPage.html" class="scroll">Provider Homepage</a></li>
                    </ul>
                    <!--start-top-nav-script-->
		 			<script>
			        	$( "span.menu" ).click(function() {
			            	$( "ul.navgation" ).slideToggle( 300, function() {});
			            });
		            </script>
					<!--End-top-nav-script-->
                </div>
				<div class="clearfix"> </div>
            </div>
       </div>
   </div>
			
		<div class="mainStuff" align="center">
<form action="/assign-book" method="post">
	
	
	<% 
		String firstName = null;
		String middleInitial = null;
		String lastName = null;
		Long childID = null;
						
		List<ChildAccount> allChild = ChildAccount.getAllChild();
	%>
		<label>Add Child: <span class="required">*</span></label> 
		<select name="childID">
		<option>-Children-</option>
		<%
			for (int i = 0; i<allChild.size(); i++) {
				firstName = allChild.get(i).getFirstName();
				lastName = allChild.get(i).getLastName();
				middleInitial = allChild.get(i).getMiddleInitial();
				childID = allChild.get(i).getId();
		%>
		<option value="<%= childID %>" ><%= firstName %> <%= middleInitial %> <%= lastName %></option>
		<% } %>
	</select>
	
	<%
		String bookTitle = null;
		Long bookID = null;
		List<BookObject> allBook = BookObject.getAllBooks();
	%>
	<label>Book read: <span class="required">*</span></label>
	<select name="bookID">
	<option>--Books--</option>
	
		<%
		for(int i= 0; i< allBook.size(); i++){
			bookID = allBook.get(i).getId();
			bookTitle = allBook.get(i).getBookTitle();
		%>
		<option value="<%=bookID %>"><%=bookTitle %></option>
		<%}
	
	%>
	
	</select>
<input type="submit" value="Submit" />
</form>
</div>
<div class="footer">
			<div class="container">
				<div class="footer-text">
					<p>Lil' Me Day Care &copy;2015.</p>
				</div>
			</div>
			<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
     	</div>

</body>

</html>