<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>BDT - Candidatos</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>
        <!-- Custom styles for this template -->
        <link href="jumbotron.css" rel="stylesheet">
    </head>

    <body>

        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="Home.htm">BOLSA DE TRABAJO</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="<c:out value="index.htm"/>">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Opcion</a>
                    </li>
                    <li class="nav-item " >
                        <a class="nav-link" href="">Opcion</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Opcion</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Opcion</a>
                    </li>

                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Digite" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
                </form>
            </div>
        </nav><!-- NavBar-->

        <main role="main">

            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron">
                <div class="container">
                    <h1 class="display-4"> Se encuentra en la Seccion de candidatos</h1>
                </div>
            </div>

            <div class="container">
                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-3">
                        <figure class="figure">
                            <img src="<c:url value=""/>" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                            <figcaption class="figure-caption">A caption for the above image.</figcaption>
                        </figure>
                        <h2>Registrar Candidatos</h2>
                        <p><a class="btn btn-outline-success" href="RegistroCandidato.htm" role="button">Ir al modulo &raquo;</a></p>
                    </div>
                    <div class="col-md-3">
                        <figure class="figure">
                            <img src="<c:url value=""/>" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                            <figcaption class="figure-caption">A caption for the above image.</figcaption>
                        </figure>
                        <h2>Buscar un candidato</h2>
                        <p><a class="btn btn-outline-warning" href="" role="button">Buscar &raquo;</a></p>
                    </div>
                    <div class="col-md-3">
                        <figure class="figure">
                            <img src="<c:url value=""/>" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                            <figcaption class="figure-caption">A caption for the above image.</figcaption>
                        </figure>
                        <h2>Acceder al modulo Z</h2>
                        <p><a class="btn btn-outline-success" href="<c:url value=""/>" role="button">Ir al modulo &raquo;</a></p>
                    </div>
                    <div class="col-md-3">
                        <figure class="figure">
                            <img src="<c:url value=""/>" class="figure-img img-fluid rounded" alt="Prueba de procedimiento alamacenado, donde se hace un SELECT de logros.">
                            <figcaption class="figure-caption">A caption for the above image.</figcaption>
                        </figure>
                        <h2>Prueba de procedimiento </h2>
                        <p><a class="btn btn-outline-success" href="<c:url value="/Prueba1.htm"/>" role="button">Ir al modulo &raquo;</a></p>
                    </div>
                </div>

                <hr>
                <table class="table table-bordered table-dark">
                    <thead class="thead-dark">
                        <tr>
                            <th>Identificador</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${CANDIDATOS}" var="CANDIDATO">
                            <tr>
                                <th><c:out value="${CANDIDATO.ID_POST_DOC}"/></th>
                                <th><c:out value="${CANDIDATO.PRIMER_NOMBRE}"/></th>
                                <th><c:out value="${CANDIDATO.PRIMER_APELLIDO}"/></th>
                                <th>
                                    <a href="<c:url value="/PerfilCandidato.htm?id=${CANDIDATO.ID_POST_DOC}"/>" class="btn btn-info">Ver</a>
                                    <a href="<c:url value="/CandidatoEditar.htm?id=${CANDIDATO.ID_POST_DOC}"/>" class="btn btn-warning">Editar</a>
                                    <a href="<c:url value="/CandidatoEliminar.htm?id=${CANDIDATO.ID_POST_DOC}"/>" class="btn btn-danger">Eliminar</a></th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:out value="${ERRORES}"/>    
            </div> <!-- /container -->

        </main>

        <footer class="container">
            <p>&copy; Grupo 06 - BAD115 - 2018</p>
        </footer>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="../../../../assets/js/vendor/popper.min.js"></script>
        <script src="../../../../dist/js/bootstrap.min.js"></script>
    </body>
</html>
