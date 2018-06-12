
<%-- 
    Document   : OfertaEmpleo
    Created on : 05-31-2018, 12:33:35 PM
    Author     : Juan Murcia
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferta Empleo</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-reset.css" rel="stylesheet"/>
        <link href="resources/css/style-responsive.css" rel="stylesheet"/>
        <link href="resources/css/style.css" rel="stylesheet"/>
        <link href="resources/css/font-awesome/css/font-awesome.css" rel="stylesheet"/>
        <link href="resources/css/font-awesome.css" rel="stylesheet"/>
    </head>
    <body>
        <h1>Registrar nueva oferta de empleo</h1>

        <div class="row login-body">
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        Datos de Registro
                    </header>
                    <div class="panel-body">
                        <label for="FechaExp">Informacion general</label>
                        <form class="form-inline" role="form">
                            <div class="form-group">
                                <label class="sr-only" for="nom3">Fecha de expiracion</label>
                                <input type="text" class="form-control" id="fecha" placeholder="Fecha fin">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="lugar">Lugar</label>
                                <input type="text" class="form-control" id="Lugar" placeholder="Lugar de oferta">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="vac">Vacantes</label>
                                <input type="Integer" class="form-control" id="Vacantes" placeholder="Numero de vacantes">
                            </div>
                            
                        </form>
                        <br><label for="apellidos">Descripciones de la oferta</label>
                        <form class="form-inline" role="form">
                            <div class="form-group">
                                <label class="sr-only" for="apellido1">Descripcion</label>
                                <input type="text" class="form-control" id="Descrip" placeholder="Descripcion">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="contrat">Tipo de contrato</label>
                                <input type="text" class="form-control" id="Contrat" placeholder="Tipo de contrato">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="salario">Salario</label>
                                <input type="text" class="form-control" id="salari" placeholder="Salario">
                            </div>
                        
                        </div>
                    </section>
            </div>
    </body>
</html>
