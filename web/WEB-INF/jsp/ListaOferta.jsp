<%-- 
    Document   : ListaOferta
    Created on : 06-11-2018, 11:46:18 PM
    Author     : Juan Murcia
--%>
<%@include file="/WEB-INF/jsp/include/Principal/taglib.jsp" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Mosaddek">
        <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Form Wizard</title>

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

    <body>

        <section id="container" class="">
            <!--header start-->
            <%@include file="/WEB-INF/jsp/include/Admin/headerAdmin.jsp" %>
            <!--header end-->
            <!--sidebar start-->
            <%@include file="/WEB-INF/jsp/include/Admin/sidebarAdmin.jsp" %>
            <!--sidebar end-->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper site-min-height">
                    <!-- page start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Lista de Ofetas
                                    <a href="<c:url value="/ofertaEmpleo.htm"/>" class="btn btn-info">Añadir Oferta de empleo</a>
                                </header>
                                <div class="panel-body">
                                    <div class="adv-table">
                                        <table  class="display table table-bordered table-striped" id="example">
                                            <thead>
                                                <tr>
                                                    <th>Identificador</th>
                                                    <th>Nivel de estudio</th>
                                                    <th>Area de estudio</th>
                                                    <th>Vacantes</th>
                                                    <th class="hidden-phone">Vacio</th>
                                                    <th class="hidden-phone">Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${OFERTAS}" var="OFERTA">
                                                    <tr>
                                                        <th>${OFERTA.ID_OFERTA}</th>
                                                        <th>${OFERTA.ID_NIVEL_ESTUDIO}</th>
                                                        <th>${OFERTA.ID_AREA_ESTUDIO}</th>
                                                        <th></th>
                                                        <th>
                                                            <a href="<c:url value="/OfertaEmpleo.htm?id=${OFERTA.ID_POST_DOC}"/>" class="btn btn-info">Ver</a>
                                                            <a href="<c:url value="/CandidatoEditar.htm?id=${CANDIDATO.ID_POST_DOC}"/>" class="btn btn-warning">Editar</a>
                                                            
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                     <th>Identificador</th>
                                                    <th>Nivel de estudio</th>
                                                    <th>Area de estudio</th>
                                                    <th>Vacantes</th>
                                                    <th class="hidden-phone">Vacio</th>
                                                    <th class="hidden-phone">Acciones</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                        <div class="row login-body">
                                        </div>
                                </div>
                            </section>
                        </div>
                    </div>
                    <!-- page end-->
                </section>
            </section>
                <h1>Registrar nueva oferta de empleo</h1>

                        
                              
            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    2013 &copy; FlatLab by VectorLab.
                    <a href="#" class="go-top">
                        <i class="icon-angle-up"></i>
                    </a>
                </div>
            </footer>
            <!--footer end-->
        </section>

        <%@include file="/WEB-INF/jsp/include/Admin/jsAdmin.jsp" %>

        <!--script for this page-->
        <script src="<c:url value="/public/Admin/js/jquery.stepy.js"/>"></script>


        <script>

            //step wizard

            $(function () {
                $('#default').stepy({
                    backLabel: 'Previous',
                    block: true,
                    nextLabel: 'Next',
                    titleClick: true,
                    titleTarget: '.stepy-tab'
                });
            });
        </script>


    </body>
</html>