<%-- 
    Document   : create-account
    Created on : 1/08/2023, 1:41:46 pm
    Author     : dyrellumiwes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Create Account</title>
    </head>
  <body>
        <main>

	<h1>Create Account</h1>

	<fieldset>

		<legend>Account Details</legend>

		<form action="create-account" method="POST">

			<label>Username:</label><input type="text" name="username"/>
                        <label>Password:</label><input type="text" name="password"/>

			<label>First Name:</label><input type="text" name="firstname"/>
                        <label>Surname</label><input type="text" name="surname"/>
			<label>Address:</label><textarea name="address"></textarea>
			<label>Phone Number:</label><input name="phoneNumber"/>
			<label>Email Address:</label><input name="email"/>

			<button type="submit">Create Account</button>
		</form>

	</fieldset>

	<a class="nav" href="index.jsp">Back to Home</a>

</main>
        
    </body>
</html>
