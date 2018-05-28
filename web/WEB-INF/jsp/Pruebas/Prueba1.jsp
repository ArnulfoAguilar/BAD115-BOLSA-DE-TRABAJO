<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>
        
    </head>
    <body>
        <h1>No introduzca ni verga!</h1>
        
        <input name="id_a_buscar">
    
        <h1><c:out value="${Lugar}"/></h1>
        <h2><c:out value="${Fecha}"/></h2>
        <h3><c:out value="${Error}"/></h3>
        
    </body>
</html>
