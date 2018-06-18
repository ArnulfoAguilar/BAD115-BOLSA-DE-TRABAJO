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
                                    Oferta empleo
                                </header>
                                <div class="panel-body">
                                    <div class="adv-table">
                                        
                                        <div class="row login-body">
            <div class="col-lg-12">
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
                                <label class="sr-only" for="vac">Vacantes</label>
                                <input type="Integer" class="form-control" id="Vacantes" placeholder="Numero de vacantes">
                            </div>
                        </form>
                        <br>
                        <form>
                             <div class="form-group">
                                <label class="sr-only" for="lugar">Lugar</label>
                                <input type="text" class="form-control" id="Lugar" placeholder="Lugar de oferta">
                            </div>
                         
                            
                            <section class="panel">
                        <header class="panel-heading">
                           <label for="apellidos">Descripciones de la oferta</label>
                        </header>
                        <div class="panel-body">
                            <div class="form-group col-lg-12">
                                <label class="sr-only" for="apellido1">Descripcion</label>
                                <input type="text" class="form-control" id="Descrip" placeholder="Descripcion">
                            </div>
                            <div class="form-group col-lg-3">
                                <label class="sr-only" for="contrat">Tipo de contrato</label>
                                <input type="text" class="form-control" id="Contrat" placeholder="Tipo de contrato">
                            </div>
                            <div class="form-group col-lg-3">
                               <label class="sr-only" for="salario">Salario</label>
                                <input type="text" class="form-control" id="salari" placeholder="Salario">
                            </div>
                            
                        </div>
                    </section>
                       
                    
                <form>
                    <form>
                                <button type="submit" class="btn btn-success">Guardar Oferta</button>
                            </form>
                </form>

                </section>            
            </div>
             </div> 
                                        </div>
                                </div>
                            </section>
                        </div>
                    </div>
                    <!-- page end-->
                </section>
            </section>

                        
                              
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