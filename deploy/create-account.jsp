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
<%@include file="WEB-INF/jspf/navigation.jspf"%>

	<h1>Create Account</h1>

	<fieldset>

		<legend>Account Details</legend>
<%
        String validation = (String)session.getAttribute("validation");
	validation = validation != null ? validation : ""; 
        // test
        session.removeAttribute("validation");
%>

<p><%= validation %></p>
		<form action="create-account" method="POST">

			<label>Username:</label><input type="text" name="username" required/>
                        <label>Password:</label><input type="text" name="password" required/>

			<label>First Name:</label><input type="text" name="firstname" required/>
                        <label>Surname</label><input type="text" name="surname" require />
			<label>Address:</label><textarea name="address"></textarea>
			<label>Phone Number:</label><input name="phoneNumber" required/>
			<label>Email Address:</label><input name="email" required/>

			<button type="submit">Create Account</button>
                            <button type="reset">Clear</button>

		</form>

	</fieldset>

	<a class="nav" href="index.jsp">Back to Home</a>

</main>
        
    </body>
</html>
