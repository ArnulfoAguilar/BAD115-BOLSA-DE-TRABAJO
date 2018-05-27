
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EMPRESA</h1>
    <form:form commandName="comand">
       <p>
            <form:label path="nit">NIT</form:label>
            <form:input path="nit" />
        </p>
         <p>
            <form:label path="giroEmpresa">GIRO</form:label>
            <form:input path="giroEmpresa" />
        </p>
        <p>
            <form:label path="reclutador">RECLUTADOR</form:label>
            <form:input path="reclutador" />
        </p>
        <p>
            <form:label path="razonSocial">RAZON SOCIAL</form:label>
            <form:input path="razonSocial" />
        </p>
        <p>
            <form:label path="nombreComercial">NOMBRE</form:label>
            <form:input path="nombreComercial" />
        </p>
        <p>
            <form:label path="ubicacion">UBICACION</form:label>
            <form:input path="ubicacion" />
        </p>
        <p>
            <form:label path="descripcion">DESCRIPCION</form:label>
            <form:input path="descripcion" />
        </p>
        <p>
            <form:label path="paginaWeb">PAGINA WEB</form:label>
            <form:input path="paginaWeb" />
        </p>
        <p>
            <form:label path="email">EMAIL</form:label>
            <form:input path="email" />
        </p>
        <hr>
        <form:button>Enviar</form:button>
    </form:form>
    </body>
</html>
