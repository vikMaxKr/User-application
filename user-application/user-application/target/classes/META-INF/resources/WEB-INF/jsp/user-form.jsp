<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Saving the customer</title>
<style type="text/css">

body {
  font-family: sans-serif;
  line-height: 1;
  font-weight: 400;
  color: #555;

  
}

.wrapper{
	text-transform:uppercase;
	font-size:24px;
	font-style:italic;
}
.register{
background-color:#fdf2e9;
}
.container{
margin-left:200px;

}
.trow{
font-size:18px;
margin-bottom:10px;
}
.btn{
font-size:16px;
cursor:pointer;
margin-top:10px;
padding:px 3px;
background-color:#fdf2e9;
}
.lbl{
font-size:18px;
}
.down{
margin-left:10px;
}
h3{
text-transform:uppercase;
}
.error{
color:red;
}
</style>
</head>
<body>

	<div class="wrapper">
			<h2 class="register">User registration application</h2>
	</div>

	<div class="container">

    <div class="main">
		<h3>Save user details</h3>
		<i>(*)is required field</i> <br>
		<br>
		<form:form action="saveuser" modelAttribute="user" method="POST">

			<table>

				<tbody>

					<tr>
						<td ><label class="lbl">User Name(*):</label></td>
						<td><form:input path="userName" class="trow" /></td>
						<td><form:errors path="userName" class="error" /></td>
					</tr>

					<tr>
						<td><label class="lbl">First Name:</label></td>
						<td><form:input path="firstName" class="trow" /></td>
					</tr>
					<tr>
						<td><label class="lbl">Last Name:</label></td>
						<td><form:input path="lastName" class="trow" /></td>
					</tr>
					<tr>
						<td><label class="lbl">Email:</label></td>
						<td><form:input path="email" class="trow" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="btn " /></td>
					</tr>
				</tbody>

			</table>

		</form:form>
	
	<div class="serachuser">
		<h3 >Search user by user-name</h3>
		<form action="getuserbyname" method="get">
			<input type="text" name="userName" placeholder="search by user name" class="trow">
			<input type="submit" value="Get" class="btn down">
		</form>
		
	</div>
	</div>
	</div>

</body>

</html>