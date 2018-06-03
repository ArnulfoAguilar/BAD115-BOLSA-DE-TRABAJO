<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Nuevo Candidato</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-reset.css" rel="stylesheet"/>
        <link href="resources/css/style-responsive.css" rel="stylesheet"/>
        <link href="resources/css/style.css" rel="stylesheet"/>
        <link href="resources/css/font-awesome/css/font-awesome.css" rel="stylesheet"/>
        <link href="resources/css/font-awesome.css" rel="stylesheet"/>
    </head>
    <body>

        <div clas="container">
            <form:form method="POST" commandName="candidato" >
                <div class="row">
                    <div class="col">
                        <form:input class="form-control" path="idPostDoc" placeholder="Identificador"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <form:input type="text" class="form-control" path="primerNombre" placeholder="Primer Nombre"/>
                    </div>
                    <div class="col">
                        <form:input type="text" class="form-control" path="segundoNombre" placeholder="Segundo Nombre"/>
                    </div>
                    <div class="col">
                        <form:input type="text" class="form-control" path="tercerNombre" placeholder="Tercer Nombre"/>
                    </div>
                </div>
                <br>
                <hr/>
                <div class="col-lg-4">
                    <form:button class="btn btn-primary">Insertar Candidato</form:button>
                    </div>
            </form:form>
            <div class="col-lg-4">
                <c:out value="${Resultado}"/><br>
            </div>
            <div class="col-lg-4">
                <c:out value="${Error}"/>
            </div>
        </div>
    </body>
</html>
