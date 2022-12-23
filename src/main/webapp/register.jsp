<html>
<head> <link href="css/register.css" rel="stylesheet" type="text/css"></head>
<body>
<div class="container">
  <div class="row justify-content-center">
  <div class="col-md-5">
   <div class="card">
     <h2 class="card-title text-center">Register</h2>
      <div class="card-body py-md-4">
       <form action="registration" method = "post">
          <div class="form-group">
             <input type="text" class="form-control" id="name" name="name" placeholder="Name" (required)>
        </div>
        <div class="form-group">
             <input type="email" class="form-control" id="email" name="email" placeholder="Email" (required)>
                            </div>
        <div class="form-group">
                     <input type="text" class="form-control" id="address" name = "address" placeholder="Address" (required)>
                                    </div>
        <div class="form-group">
                             <input type="text" class="form-control" id="phone" name = "phone" placeholder="Phone" (required)>
                                            </div>
   <div class="form-group">
     <input type="password" class="form-control" id="password" placeholder="Password" (required)>
   </div>
   <div class="form-group">
      <input type="password" class="form-control" id="confirm-password" placeholder="confirm-password" (required)>
   </div>
   <div class="d-flex flex-row align-items-center justify-content-between">
                                <button type="submit" class="btn btn-primary">Create Account</button>
          </div>
       </form>
     </div>
  </div>
</div>
</div>
</div>
</body>
</html>