<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Admin Template">
    <meta name="keywords" content="admin dashboard, admin, flat, flat ui, ui kit, app, web app, responsive">
    <link rel="shortcut icon" href="img/favicon.png">
    <title>Register</title>

    <!-- Base Styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->


</head>

  <body class="login-body">

     

      <h2 class="form-heading">Register</h2>
      <div class="container log-row">
          <form class="form-signin" action="<%=request.getContextPath()%>/registration" method="post">
              <div class="login-wrap">
              	  <input type="text" class="form-control" placeholder="First Name" autofocus name="fname">
              	  <input type="text" class="form-control" placeholder="Last Name" autofocus name="lname">
                  <input type="text" class="form-control" placeholder="User ID" autofocus name="uname">
                  <input type="password" class="form-control" placeholder="Password" name="pass">
                  <input type="radio"   name="radi" id="male" value="admin">
                  <label for="male">Admin</label>
                  <input type="radio"   name="radi" id="male" value="staff">
                  <label for="male">Staff</label>
                  <input type="hidden" name="flag" value="insert">
                  <button class="btn btn-lg btn-success btn-block" type="submit">Register</button>
               
                 

              </div>

              <!-- Modal -->
              
              <!-- modal -->

          </form>
      </div>


      <!--jquery-1.10.2.min-->
      <script src="js/jquery-1.11.1.min.js"></script>
      <!--Bootstrap Js-->
      <script src="js/bootstrap.min.js"></script>
      <script src="js/jrespond..min.js"></script>

  </body>
</html>
