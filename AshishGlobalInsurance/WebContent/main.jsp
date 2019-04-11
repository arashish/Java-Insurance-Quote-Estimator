<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>ASHISH GLOBAL INSURANCE</title>
		<style>
			#tit {color:White; border-style:solid; text-align:center; background: #ff0000; vertical-align:middle; opacity:0.8; font-size: 24px;}	 /* used for the table title */
			label {color:Black;font-weight:Regular;font-size:16px;text-align:right;}	 /* used to display the field names */
			#tbox {font-size:16px;}	 /* used to set the text size inside the text box */
			#email {font-size:16px;}  /* used to set the size of email textbox*/
			.button {	 
			  background-color: #ff0000;
			  border: none;
			  color: white;
			  padding: 7px 16px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 16px;
			  margin: 4px 2px;
			  cursor: pointer;
			} /* gives css stying to the button */
			
			#topTit{	
				border-radius:1%/100%;
				border:1px solid #000;
				color:White; 
				border-style:solid; 
				text-align:center; 
				background: #ff0000; 
				vertical-align:middle; 
				opacity:0.8; 
				font-size: 24px;
			}  /* used for the top title */
			
			div {
			position: absolute;
			top:0;
			bottom: 0;
			left: 0;
			right: 0;
			margin: auto;
			width: 400px;
			height: 400px;
			}	 /* used to set the table in the middle of the screen */
			
		</style>
		
		<script>
			function myFunction() {
				
				if (document.forms["formhtml"]["first_name"].value == "") { 	//checks to see if first name field is empty
						alert("Error: First name field cannot be empty!");
						return false;
				}
				
				if (document.forms["formhtml"]["last_name"].value == "") { 		//checks to see if last name field is empty
						alert("Error: Last name field cannot be empty!");
						return false;
				}
				
				if (document.forms["formhtml"]["email"].value == "") {			//checks to see if email field is empty
						alert("Error: Email field cannot be empty!");
						return false;
				}
				
				var at = document.getElementById("email").value.indexOf("@");	//checks to see if the entered email is valid
				if (at == -1) {
					alert("Error: The entered email is invalid!!");
					return false;
				}
				
				if (document.forms["formhtml"]["age"].value == "") {			//checks to see if the age field is empty
						alert("Error: Age field cannot be empty!");
						return false;
				}
				
				if (document.getElementById("male").checked == false && document.getElementById("female").checked == false ){	//checks to see if the gender is selected
					alert("Error: Please select your gender status!");
					return false;
				}
			}
		</script>
	</head>
	
	<body>
		<br><br>
						
		<div align="center">	<!-- Aligns the table in the middle of the screen -->
			<h2>Let us help you calculate your 	
				<%= request.getParameter("insuranceType")%> 
				insurance cost!
			</h2>
			<form name="formhtml" action="temp" onsubmit="return myFunction()" method="post">	<!-- This form will let the user enter their information and pas the values to Servlet AshishServlet1.java where temp is the url/shortcut mapping to the servlet-->
				<table bgcolor="#D3D3D3">
					<col width="150">
					<col width="250">
					
					<tr>
					<th colspan="2" id="tit">
						Please enter your information below:
					</th>
					</tr>
					
					<tr>
						<td valign="top">
							<label for="first_name">First Name: </label>
						</td>
						<td valign="top">
							<input type="text" id="tbox" name="first_name" maxlength="50" size="30">
						</td>
					</tr>

					<tr>
						<td valign="top">
							<label for="last_name">Last Name: </label>
						</td>
						<td valign="top">
							<input type="text" id="tbox" name="last_name" maxlength="50" size="30">
						</td>
					</tr>

					<tr>
						<td valign="top">
							<label for="email">Email Id: </label>
						</td>
						<td valign="top">
							<input type="text" id="email" name="email" maxlength="80" size="30">
						</td>
					</tr>

					<tr>
						<td valign="top">
							<label for="age">Age: </label>
						</td>
						<td valign="top">
							<input type="text" id="tbox" name="age" maxlength="3" size="1">
						</td>
					</tr>

					<tr>
						<td valign="top">
							<label for="gender">Gender: </label>
						</td>
						<td valign="top">
							<input type="radio" id="male" name="gender" value="Male"> <label for="male">Male</label> 
							<input type="radio" id="female" name="gender" value="Female"> <label for="female">Female</label>
						</td>
					</tr>

					<tr>
						<td valign="top">
							<label for="healthIssues">Health Issues: </label>
						</td>
						<td valign="top">
							<input type="radio" id = "yes1" name="healthIssues" value="Yes"> <label for="yes1">Yes</label> 
							<input type="radio" id = "no1" name="healthIssues" value="No" checked="checked"> <label for="no1">No</label>
						</td>
					</tr>

					<tr>
						<td valign="top">
							<label for="badHabbits">Bad Habbits: </label>
						</td>
						<td valign="top">
							<input type="radio" id = "yes2" name="badHabbits" value="Yes"> <label for="yes2">Yes</label> 
							<input type="radio" id = "no2" name="badHabbits" value="No" checked="checked"> <label for="no2">No</label>
						</td>
					</tr>

					<tr>
						<td></td>
						<td style="text-align:Left">
							<input type="submit" class= "button" value="Submit">				<!-- submits the form to AshishServlet1 -->
							<button type="reset" class= "button" value="reset">Clear</button>	<!-- Clear the form -->
						</td>
					</tr>
					
				</table>
				<input type="hidden" id="01" name="insuranceType" value="<%= request.getParameter("insuranceType")%>">	<!-- To pass the selected value from home page to the final page -->
			</form>
		</div>
	</body>
</html>
