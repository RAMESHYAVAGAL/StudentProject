<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.heading {
	color: #000080;
}

.sub {
	color: #1e90ff;
}
.success{
color: green;
}
.failure{
color: red;
}
</style>
</head>
<body bgcolor='#add8e6'>
	<div align="center">
		<h1 class="heading">Pentagon Space</h1>
		<h3 class="sub">Welcome to Login Page</h3>
		<%String success=(String)request.getAttribute("success"); 
		if(success!=null){%>
		<h3 class="success"><%=success %></h3>
		<%}%>
		<%String failure=(String)request.getAttribute("failure"); 
		if(failure!=null){%>
		<h3 class="failure"><%=failure%></h3>
		<%}%>
		<form action="login" method="post">
			<table>
				<tr>
					<td><b>Enter your MailId:</b></td>
					<td><input type="email" name="mail"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Password:</b></td>
					<td><input type="password" name="password"></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Login"></td>
					<td><b>Forgot the password:  </b><a href="Forgot.html">Forgot</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>