<%-- 
    Document   : view-products
    Created on : 1/08/2023, 1:42:07 pm
    Author     : dyrellumiwes
--%>

<%@page import="dao.DaoFactory"%>
<%@page import="domain.Product"%>
<%@page import="java.util.Collection"%>
<%@page import="dao.ProductDAO"%>
<%@page import="dao.ProductCollectionsDAO"%>
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
        <title>View Products</title>
    </head>
    <body>
       <main>
           <%@include file="WEB-INF/jspf/navigation.jspf"%>

            <h1>Products</h1>



            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>In Stock</th>

<!--                        <th>In Stock</th>-->
                    </tr>
                </thead>

               
                <tbody>


                    <%
                        //ProductDAO dao = new ProductCollectionsDAO();
                ProductDAO dao = DaoFactory.getProductDAO();

                        // get the major from the query parameter
                        String selectedCategory = request.getParameter("category");

// declare the students collection
                        Collection<Product> products;

// if there is no major parameter, or "All" is requested, return all students
                        if (selectedCategory == null || selectedCategory.equals("All")) {
                            products = dao.getProducts();
                        } else {
                            // otherwise, get the students for the requested major
                            products = dao.filterByCategory(selectedCategory);
                        }
                        

                        for (Product product : products) {
                    %>
                    <tr>
                        <td><%= product.getProductId()%></td>
                        <td><%= product.getName()%></td>
                        <td><%= product.getCategory()%></td>
                        <td><%="$" + product.getListPrice()%></td>
                        <td><%= product.getQuantityInStock()%></td>


                        
                        <td> 
                        <form action="view-product" method="POST">
                        <input type="hidden" name="id" value="<%= product.getProductId() %>">
                        <button>Buy</button>
                        </form>
                        </td>
                      
                    </tr>
                    <%
                        }
                    %>
                </tbody>

                <a href="view-products.jsp?category=All"><button class="categoryButton">All</button></a>

                <%
                    Collection<String> categories = dao.getCategories();

                    for (String category : categories) {
                %>

                <a href="view-products.jsp?category=<%= category%>"><button class="categoryButton"><%= category%></button></a>

                <%
                    }
                %>



            </table>

            <a class="nav" href="index.jsp">Back to Menu</a>
        </main>
    </body>
    
    
    
    
    
</html>
