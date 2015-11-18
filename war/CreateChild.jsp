<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Add Child</title>
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
		<!--end-animated-css-->
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
		<div class="mainStuff" role="form">
			<img src='assets/images/childhandssmall.jpg' alt='Day Care Fun' style="max-height: 27em; max-width: 18em; float:left; padding-right: 2em;"/>
			<h1>Add New Child</h1>
			<h3>${param.message}</h3>
			
			<form action="/add-child" method="post" class="form-style-1">
				<ul>
    				<li><label>First Name <span class="required">*</span></label><input type="text" name="firstName" class="field-long" placeholder="First Name" /></li>
					<li><label>Middle Initial</label><input type="text" name="middleInitial" class="field-divided" placeholder="Middle Initial" maxlength="1" /></li>
					<li><label>Last Name <span class="required">*</span></label><input type="text" name="lastName" class="field-long" placeholder="Last Name" /></li>
    				<li>
        				<label>Date of Birth <span class="required">*</span></label>
        				<select name="DOBMonth" class="field-select">
        					<option> - Month - </option>
							<option value="01">January</option>
							<option value="02">February</option>
							<option value="03">March</option>
							<option value="04">April</option>
							<option value="05">May</option>
							<option value="06">June</option>
							<option value="07">July</option>
							<option value="08">August</option>
							<option value="09">September</option>
							<option value="10">October</option>
							<option value="11">November</option>
							<option value="12">December</option>
						</select>
   		     			<select name="DOBDay">
							<option> - Day - </option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
							<option value="24">24</option>
							<option value="25">25</option>
							<option value="26">26</option>
							<option value="27">27</option>
							<option value="28">28</option>
							<option value="29">29</option>
							<option value="30">30</option>
							<option value="31">31</option>
						</select>
						<select name="DOBYear">
							<option> - Year - </option>
							<option value="2003">2003</option>
							<option value="2004">2004</option>
							<option value="2005">2005</option>
							<option value="2006">2006</option>
							<option value="2007">2007</option>
							<option value="2008">2008</option>
							<option value="2009">2009</option>
							<option value="2010">2010</option>
							<option value="2011">2011</option>
							<option value="2012">2012</option>
							<option value="2013">2013</option>
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
						</select>
					</li>
					<li>
						<label>Any Allergies?</label><br />
						<input type=checkbox name="allergies" value="Cow Milk">Cow's Milk
						<input type=checkbox name="allergies" value="Eggs">Eggs
						<input type=checkbox name="allergies" value="Peanuts">Peanuts
						<input type=checkbox name="allergies" value="Fish">Fish
						<br />
						<input type=checkbox name="allergies" value="Shellfish">Shellfish
						<input type=checkbox name="allergies" value="Tree Nuts">Tree Nuts
						<input type=checkbox name="allergies" value="Wheat">Wheat
						<input type=checkbox name="allergies" value="Soy">Soy
					</li>
					<li>
   		     			<label>Lunch Group: <span class="required">*</span></label> 
       		 			<select name="lunchGroup">
							<option>-Lunch Group-</option>
							<option value="1">Lunch Group 1</option>
							<option value="2">Lunch Group 2</option>
							<option value="3">Lunch Group 3</option>
						</select>
    				</li>
    				<li>
    					<input type="hidden" name="url" value="CreateChild.jsp">
    				</li>
    				<li>
        				<input type="submit" value="Submit" />
    				</li>
				</ul>
			</form>
			<br />
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