
<html>
<head> <link href="css/register.css" rel="stylesheet" type="text/css"></head>
<body>
<div class="container">
  <div class="row justify-content-center">
  <div class="col-md-5">
   <div class="card">
     <h2 class="card-title text-center">Login</h2>
      <div class="card-body py-md-4">
       <form action="LoginServlet" method = "post">
          <div class="form-group">
             <input type="text" class="form-control" id="name" name="Email" placeholder="Name">
        </div>
   <div class="form-group">
      <input type="password" class="form-control" name = "pwd" placeholder="password">
   </div>
   <div class="d-flex flex-row align-items-center justify-content-between">
                                <button type="submit" class="btn btn-primary">Login</button>
          </div>
       </form>
     </div>
  </div>
</div>
</div>
</div>
</body>
</html>