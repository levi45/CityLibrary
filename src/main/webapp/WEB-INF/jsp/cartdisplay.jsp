<html>
<head>
	<title>Shopping Cart UI</title>
    <link href="css/cartdisplay.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,900" rel="stylesheet">
</head>
<body>


<% int final_price = 0; %>
<% int final_quantity = 0; %>
<%@ page  import="model.Product" %>
<%@ page  import="model.ShoppingBasket" %>
<%@ page  import="model.Contains"%>

   <div class="CartContainer">
   	   <div class="Header">
   	   	<h1 class="Heading">Borrowed</h1>
   	   	<h1 class="Heading" href="http://localhost:8080/bookstore/productpage">Home</h1>
   	   </div>
<% for(Contains element: (java.util.ArrayList<Contains>)request.getAttribute("containlist")){ %>
<%
  Product product = null;
  ShoppingBasket shb = null;
  product = element.getProduct();
  shb = element.getShoppingBasket();
  final_price+= ((product.getPrice()).intValue()*element.getQuantity());
  final_quantity+= element.getQuantity();
%>
   	   <div class="Cart-Items pad">
   	   	  <div class="image-box">
   	   	  	<img src="resources/img/<%=product.getISBN()%>.jpg" style={{ height="120px" }} />
   	   	  </div>
   	   	  <div class="about">
   	   	  	<h1 class="title"><%=product.getTitle()%></h1>
   	   	  	<h3 class="subtitle"><%=product.getPublisher_name()%></h3>
   	   	  </div>
   	   </div>
   	    <% } %>
   	 <hr>
   	 <div class="checkout">
   	 <div class="total">
   	 	<div>
   	 		<div class="Subtotal">Sub-Total</div>
   	 		<div class="items"><%=final_quantity%></div>
   	 	</div>
   	 	<div class="total-amount">$<%=final_price%></div>
   	 </div>
   	 <button class="button">Checkout</button></div>
   </div>
</body>
</html>