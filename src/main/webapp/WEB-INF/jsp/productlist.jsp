<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head> <link href="css/productlist.css" rel="stylesheet" type="text/css"> </head>

<nav class="navbar">
 <h1>Library</h1>

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

  <div class="sort">
    <div class="collection-sort">
      <label>Filter by:</label>
      <form action = "productpage", method = "get">
      <select class="dropdown" name = "sort" onchange="this.form.submit()">
        <option value="/">All Books</option>
        <option value="price">Title</option>
        <option value="price DESC">Publisher</option>
      </select>
      </form>
    </div>

    <div class="collection-sort">
      <label>Sort by:</label>
      <select class="dropdown">
        <option value="/">Featured</option>
      </select>
    </div>


     <ul class="nav-links">
       <li class="nav-item"><a href="http://localhost:8080/bookstore/logout" action = "post">Sign out</a></li>
       <li class="nav-item"><a href="http://localhost:8080/bookstore/shoppingcartlist">Borrowed</a></li>
       <li class="nav-item"><a href="http://localhost:8080/bookstore/shoppingcartlist">Reserved</a></li>

 </nav>


<main class="cards">
<%@ page  import="model.Product" %>
<% for(Product element: (java.util.ArrayList<Product>)request.getAttribute("list")){ %>
  <article class="card">
    <img src="resources/img/<%=element.getISBN()%>.jpg" alt="Sample photo">
    <div class="text">
      <h3><a href="http://localhost:8080/bookstore/productpage?isbn=<%=element.getISBN()%>"><%=element.getTitle()%></a></h3>
      <form action = "checkout" method = "post">
      <input type = "hidden" name = "isbn" value = "<%=element.getISBN()%>">
      <button type = "submit">Add to cart</button>
      </form>
    </div>
  </article>
  <% } %>
  </main>

  </html>