<%@include file="/WEB-INF/jsp/include/Principal/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Arnulfo">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Work Zone Login</title>

    <!-- Bootstrap core CSS -->
   <%@include file="/WEB-INF/jsp/include/Admin/cssAdmin.jsp" %>
    <!-- Custom styles for this template -->
    <link href="<c:url value="/public/Admin/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/public/Admin/css/style-responsive.css"/>" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

  <body class="login-body">

    <div class="container">
        <div class="btn btn-danger">
            ${ERRORS}
        </div>
        <form class="form-signin" action="<c:url value='validarLogin.htm'/>"  method="POST">
        <h2 class="form-signin-heading">sign in now</h2>
        <div class="login-wrap">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
            <input type="email" class="form-control" placeholder="E-mail" id="username" name="username" autofocus>
            <input type="password" class="form-control" placeholder="password" id="password" name="password">
        
                
            <button class="btn btn-lg btn-login btn-block" type="submit" value="validarLogin.htm">Entra</button>
           
            <div class="registration">
                Aun no tienes una cuenta?
                <a class="" href="signup.htm">
                    Crea una!
                </a>
            </div>

        </div>

          <!-- Modal -->
          <!--div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
              <div class="modal-dialog">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          <h4 class="modal-title">Forgot Password ?</h4>
                      </div>
                      <div class="modal-body">
                          <p>Enter your e-mail address below to reset your password.</p>
                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                      </div>
                      <div class="modal-footer">
                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                          <button class="btn btn-success" type="button">Submit</button>
                      </div>
                  </div>
              </div>
          </div>
          <!-- modal -->

      </form>

    </div>



    <!-- js placed at the end of the document so the pages load faster -->
    <%@include file="/WEB-INF/jsp/include/Admin/jsAdmin.jsp" %>


  </body>
</html-->
    
