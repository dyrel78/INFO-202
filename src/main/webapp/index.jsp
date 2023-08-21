<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />

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

            <nav>
                <!--                   <a href="create-account.jsp">Create Account</a>
                                   <a href="sign-in.jsp">Sign-in</a>
                                   <a href="view-products.jsp">View Products</a>-->
                <%@include file="WEB-INF/jspf/navigation.jspf"%>

            </nav>
            <h1>Welcome to Gadgets R Us!</h1>



        </main>
    </body>

</html>
