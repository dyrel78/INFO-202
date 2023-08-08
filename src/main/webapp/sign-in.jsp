<%-- 
    Document   : sign-in
    Created on : 1/08/2023, 1:41:58 pm
    Author     : dyrellumiwes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="css/style.css"/>

        <title>JSP Page</title>
    </head>
      <body>
        <main>
<%@include file="WEB-INF/jspf/navigation.jspf"%>

	<h1>Sign In Account</h1>
        
        <div> <p> Please sign in to continue </p> </div>

	<fieldset>

		<legend>Account Details</legend>

		<form action="sign-in" method="POST">

			<label>Username:</label><input type="text" name="username"/>
			<label>Password:</label><input type="text" name="password"/>
                        

			<button type="submit">Sign in Account</button>
                        
		</form>

	</fieldset>

	<a class="nav" href="index.jsp">Back to Home</a>

</main>
        
    </body>
</html>
