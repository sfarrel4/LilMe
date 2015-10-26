<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Add Parent</title>
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
	
			<div class="mainStuff" role="form">
				<img src='assets/images/childhandssmall.jpg' alt='Day Care Fun' 
					style="float:left;"/>	
					<center><h2>New Parent</h2></center>
			
					<form action="/add-parent" method="post" class="form-inline">
					
					<div class="form-group">
						Parent First Name: <input class="form-control" placeholder="Enter First Name" type="text" name="firstName" style="width: 15em;height:2em;" />
						<br />
						Parent Middle Initial: <input class="form-control" placeholder="Enter Middle Initial" type ="text" name="middleInitial" maxlength="1" style="width: 15em;height:2em;" />
						<br />					
						Parent Last Name: <input class="form-control" placeholder="Enter Last Name" type="text" name="lastName" style="width: 15em;height:2em;" />
						<br />					
						Parent Email Address: <input class="form-control" placeholder="Enter Email Address" type="text" name="email" style="width: 15em;height:2em;" />
					
					</div>

					<div>
						Add Children: <select name="childrenList">
									<option>-Lunch Group-</option>
									<option value="1">Lunch Group 1</option>
									<option value="2">Lunch Group 2</option>
									<option value="3">Lunch Group 3</option>
						</select>
					</div>
					
					<div>
					
					<input type="submit" value="submit"/>
					</div>	
				</form>
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