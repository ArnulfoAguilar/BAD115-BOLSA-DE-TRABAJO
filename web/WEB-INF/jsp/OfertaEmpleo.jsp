
<%-- 
    Document   : OfertaEmpleo
    Created on : 05-31-2018, 12:33:35 PM
    Author     : Juan Murcia
--%>
<%@include file="/WEB-INF/jsp/include/Principal/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <title>Bolsa en linea - Oferta Empleo</title>
    </head>
      <body class="login-body">

    <div class="container">

      <form class="form-signin" action="index.html">
        <h2 class="form-signin-heading">sign in now</h2>
        <div class="login-wrap">
            <input type="text" class="form-control" placeholder="User ID" autofocus>
            <input type="password" class="form-control" placeholder="Password">
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
                <span class="pull-right">
                    <a data-toggle="modal" href="#myModal"> Forgot Password?</a>

                </span>
            </label>
            <button class="btn btn-lg btn-login btn-block" type="submit">Sign in</button>
           
            <div class="registration">
                Aun no tienes una cuenta?
                <a class="" href="signup.htm">
                    Crea una!
                </a>
            </div>

        </div>

          <!-- Modal -->
          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
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
       <%-- <div class="container-fluid">
            <div class="panel panel-primary">
                
                <div class="panel-body ">
        <h1>Registra la oferta de empleo</h1>
    <form:form commandName="comand">
         <hr>
         <div class="form-group">
          <p class="col">
              <label >Fecha de expiracion</label><br>
            <input  type="date" class="form-control"/>
        </p>
         <p>
            <form:label path="descripcion">Descripcion</form:label>
            <form:input path="descripcion" cssClass="form-control"/>
        </p>
        <p>
        <form:label path="lugar">Lugar</form:label>
            <form:input path="lugar" cssClass="form-control"/>
        
        <form:label path="vacante">Vacantes</form:label>
            <form:input path="vacante" cssClass="form-control"/>
        
            <form:label path="tipoContrato">Tipo de Contrato</form:label>
            <form:input path="tipoContrato" cssClass="form-control"/>
        </p>
        <p>
            <form:label path="salario">Salario</form:label>
            <form:input path="salario" cssClass="form-control" />
        </p>
        <hr>
            </div> 
        <form:button class="btn btn-success">Enviar</form:button>
    </form:form>
              </div>
          </div>
       </div>--%>
    </body>
</html>