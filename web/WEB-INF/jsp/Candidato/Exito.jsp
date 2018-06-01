<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Bolsa de trabajo - Home</title>

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
                    <h1 class="display-4" align="center">Proceso hecho satisfactoriamente!</h1>
                </div>
            </div>

            <div class="container">
                <hr>
                <div class="row">
                    <div class="col-lg-6">
                        <h4>Puede volver a la pagina de administracion de candidatos dando click en el siguiente boton </h4><br>
                        <a role="button" class="btn btn-outline-warning" href="CandidatoIndex.htm">Regresar a Gestion de candidatos</a>
                    </div>
                    <div class="col-lg-6">
                        <h4>O puede volver a la pagina principal dando click en el siguiente boton </h4><br>
                        <a role="button" class="btn btn-outline-primary" href="Home.htm">Regresar a Home</a>
                    </div>
                </div>
                <br>
                <hr>
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
