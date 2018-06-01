
<%-- 
    Document   : OfertaEmpleo
    Created on : 05-31-2018, 12:33:35 PM
    Author     : Juan Murcia
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <title>Bolsa en linea - Oferta Empleo</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="panel panel-primary">
                
                <div class="panel-body ">
        <h1>Registra la oferta de empleo</h1>
    <form:form commandName="comand">
         <%--<h1 class="alert alert-info" role="alert">Datos de Acceso</h1>--%>
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
        <%--<p>
            <form:label path="tipoContrato">Tipo de Contrato</form:label>
            <form:input path="tipoContrato" cssClass="form-control"/>
        </p>
        <p>
            <for    m:label path="salario">Salario</form:label>
            <form:input path="salario" cssClass="form-control" />
        </p>
        <hr>--%>
            </div> 
        <form:button class="btn btn-success">Enviar</form:button>
    </form:form>
              </div>
          </div>
       </div>
    </body>
</html>