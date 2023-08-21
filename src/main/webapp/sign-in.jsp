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
          <!--<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet"> -->

        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&family=Zilla+Slab&display=swap" rel="stylesheet">

        <!-- Lighter font
           <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&family=Zilla+Slab:wght@300&display=swap" rel="stylesheet">
        -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>      

        <title>JSP Page</title>
    </head>
      <body>
        <main>
<%@include file="WEB-INF/jspf/navigation.jspf"%>

	<h1>Sign In Account</h1>
        
        <div> <p> Please sign in to continue </p> </div>

	<fieldset>

		<legend>Account Details</legend>
<%
	String validation = (String)session.getAttribute("validation");
	validation = validation != null ? validation : "";
%>

<p><%= validation %></p>
		<form action="sign-in" method="POST">

			<label>Username:</label><input type="text" name="username"/>
			<label>Password:</label><input type="text" name="password"/>
                        

			<button type="submit">Sign in Account</button>
                        
		</form>

	</fieldset>

                <p class = "createText"> If you do not have an account please <a class="nav" href="create-account.jsp"> create one here.</a></p>
	

</main>
        
    </body>
</html>
