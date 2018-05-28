
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="panel panel-primary">
                
                <div class="panel-body ">
        <h1>Registra ahora tu empresa con nosotros</h1>
        <h4>
            Selecciona ahora entre los mejores perfiles que aplican directamente 
            a tus vacantes o busca el mejor talento en nuestra amplia base de datos de currículums .
        </h4>
    <form:form commandName="comand">
         <h1 class="alert alert-info" role="alert">Datos de Acceso</h1>
         <div class="form-group">
          <p class="col">
              <label >Usuario</label><br>
            <input  class="form-control"/>
        </p>
         <p class="col">
             <label>Contraseña</label> <br>
            <input type="password"  class="form-control"/>
        </p>
         </div>
        <hr>
        <h1 class="alert alert-info" role="alert">Datos de la Empresa</h1>
        <p>
            <form:label path="nombreComercial">NOMBRE de la Empresa</form:label>
            <form:input path="nombreComercial" cssClass="form-control" />
        </p>
       <p class="col">
            <form:label path="nit">NIT de la Empresa</form:label>
            <form:input path="nit" cssClass="form-control"/>
        </p>
        <p>
            <form:label path="razonSocial">RAZON SOCIAL</form:label>
            <form:input path="razonSocial" cssClass="form-control"/>
        </p>
        
        <p>
            <form:label path="ubicacion">UBICACION</form:label>
            <form:input path="ubicacion" cssClass="form-control"/>
        </p>
        <p>
            <form:label path="email">EMAIL</form:label>
            <form:input path="email" type="email" cssClass="form-control"/>
        </p>
        <hr>
        
        
        <h1 class="alert alert-info" role="alert">Tipo de Empresa</h1>
        <p>
            <form:label path="descripcion">DESCRIPCION</form:label>
            <form:input path="descripcion" cssClass="form-control"/>
        </p>
        <p>
            <form:label path="paginaWeb">PAGINA WEB</form:label>
            <form:input path="paginaWeb" cssClass="form-control"/>
        </p>
        <p>
            <form:label path="giroEmpresa">Giro de la Empresa</form:label>
            <form:input path="giroEmpresa" cssClass="form-control" />
        </p>
        
        
        <h1 class="alert alert-info" role="alert">Datos de Persona de Contacto</h1>
         
        <p>
            <form:label path="reclutador">RECLUTADOR</form:label>
            <form:input path="reclutador" cssClass="form-control" />
        </p>
        
        <hr>
        <form:button class="btn btn-success">Enviar</form:button>
    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
