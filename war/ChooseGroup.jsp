<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<%@ page import="java.util.*" %>
<%@ page import="com.lilme.jdodb.ChildAccount" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.lilme.jdodb.PMF" %>
<%@ page import="javax.jdo.Query" %>

<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Group Choice</title>
    <link href="favicon.ico" rel="shortcut icon">
    <link href="assets/css/styles.css" rel="stylesheet" >
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


	<!-- Row one of features 2 features per row -->
    <div class='row text-center'>
    	<div class='col-md-4 col-md-offset-1 well'>
        	<h3>Lunch Group 1</h3>
		  	<p><a href="ShowChild.jsp?group=${1}" class="btn btn-info" role="button"><i class='glyphicon glyphicon-user'></i></a></p>
        </div>
        
		<div class='col-md-4 col-md-offset-1 well'>
        	<h3>Lunch Group 2</h3>
  			<p><a href="ShowChild.jsp?group=${2}" class="btn btn-info" role="button"><i class='glyphicon glyphicon-user'></i></a></p>
        </div>
	</div>

	<!--  Row two of features 2 features per row -->
    <div class='row text-center'>
    	<div class='col-md-4 col-md-offset-1 well'>
        	<h3>Lunch Group 3</h3>
  			<p><a href="ShowChild.jsp?group=${3}" class="btn btn-info" role="button"><i class='glyphicon glyphicon-user'></i></a></p>
        </div>
        
		 
		<div class='col-md-4 col-md-offset-1 well'>
        	<h3>All Children</h3>
  			<p><a href="ShowChild.jsp?group=${4}" class="btn btn-info" role="button"><i class='glyphicon glyphicon-user'></i></a></p>
        </div>
	</div>
	
   <div class='navbar navbar-default navbar-static-bottom'> 
    <div class='container-fluid'>

            <center>Lil' Me Day Care &copy;2015.</center>

		</div>
	</div>

</body>

    	<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>
    	<script src='assets/js/bootstrap.min.js'></script>

    <script>
      $(function() {
        $('.nav-tabs a').click(function (e) {
          e.preventDefault();
          $(this).tab('show');
        });
      });
    </script>

</html>