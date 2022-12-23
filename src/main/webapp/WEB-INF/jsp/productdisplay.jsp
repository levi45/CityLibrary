<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head> <link href="css/productdisplay.css" rel="stylesheet" type="text/css"> </head>
<nav class="navbar">
 <h1>Books</h1>
 <div class="wrap">
    <div class="search">
    <form action="productpage",method="get">
       <input type="text" name = "search" class="searchTerm" placeholder="What are you looking for?">
       <button type="submit" class="searchButton">
         <i class="fa fa-search"></i>
         </form>
      </button>
    </div>
 </div>


     <ul class="nav-links">
      <li class="nav-item"><a href="http://localhost:8080/bookstore/productpage" action = "post">Home</a></li>
       <li class="nav-item"><a href="http://localhost:8080/bookstore/logout" action = "post">Sign out</a></li>
       <li class="nav-item"><a href="http://localhost:8080/bookstore/shoppingcartlist">Cart</a></li>

 </nav>



<main class="container">
<%@ page  import="model.Product" %>
<%
  Product product = null;
  product = (Product)request.getAttribute("book");
%>
  <div class="left-column">
    <img src="resources/img/<%=product.getISBN()%>.jpg" alt="No Image">
  </div>

  <div class="right-column">

    <div class="product-description">
      <span><%=product.getPublisher_name()%></span><br>
      <span><%=product.getAuthor()%></span>
      <h1><%=product.getTitle()%></h1>
      <p><%=product.getYear()%></p>
    </div>

    <div class="product-price">
        <form action = "addtocart" method = "post">
        <span>$<%=product.getPrice()%></span><br>
        <label for="quantity">Quantity<label>
        <input type = "text" placeholder = "Quantity" value = "1" name = "quantity">
      <input type = "hidden" name = "isbn" value = "<%=product.getISBN()%>">
      <button type = "submit">Add to cart</button>
    </form>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div style="position: absolute; bottom: 5px;">
    <c:set value="${quantity}" var="stock"/>
    <c:choose>
    <c:when test="${quantity==0}">
    <p style="font-size:40px;">Out Of Stock</p>
    </c:when>
    <c:otherwise>
        <p style="font-size:40px;">In Stock</p>
    </c:otherwise>
    </c:choose>
        </div>
    </div>
  </div>
</main>

</html>