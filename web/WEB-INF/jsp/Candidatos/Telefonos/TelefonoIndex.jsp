
<%@include file="/WEB-INF/jsp/include/Principal/taglib.jsp" %>
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

    <title>Telefonos</title>

    <%@include file="/WEB-INF/jsp/include/Admin/cssAdmin.jsp" %>
    <!-- Custom styles for this template -->
    <link href="<c:url value="/public/Admin/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/public/Admin/css/style-responsive.css"/>" rel="stylesheet" />
    
    <link href="<c:url value="public/Admin/assets/bootstrap-datepicker/css/datepicker.css"/>" rel="stylesheet" type="text/css"/>
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
                              Seccion de Articulos
                              <a class="btn btn-success" href="TelefonoAdd.htm?id=${id}" role="button">Añadir Numero Telefonico</a>
                              ${Errores}
                          </header>
                          <div class="panel-body">
                              
                              <table  class="display table table-bordered table-striped" id="example">
                                            <thead>
                                                <tr>
                                                    <th>Numeros Telefonicos a disposicion</th>
                                                    <th>Tipo</th>
                                                    <th class="hidden-phone">Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                             
                              
                                                <c:forEach items="${Telefonos}" var="telefono">
                                                    <tr>
                                                        <th>${telefono.NUMERO_TEL}</th>
                                                        <th>${telefono.ID_TIPO}</th>
                                                        <th>
                                                            <a class="btn btn-warning" href="TelefonoEdit.htm?id=${telefono.ID_TIPO}&id2=${telefono.ID_POST_DOC}" role="button">Editar mi Numero</a>
                                                            <a class="btn btn-danger" href="TelefonoDelete.htm?id=${telefono.ID_TIPO}&id2=${telefono.ID_POST_DOC}" role="button">Eliminar mi Numero</a>
                                                        </th>
                                                            
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                            <tfoot hidden="true">
                                                <tr>
                                                    <th>Nombre del articulo</th>
                                                    <th>Lugar de publicacion</th>
                                                    <th>Numero de edicion</th>
                                                    <th class="hidden-phone">Acciones</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                              
                              
                              <c:if test= "${Telefonos == null}">
                                  <h3>Usted no posee ni un numero telefonico</h3>
                              </c:if>
                          </div>
                      </section>
                          <a class="btn btn-info" href="PerfilCandidato.htm?id=${id}" role="button">Regresar</a>
                      
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

      $(function() {
          $('#default').stepy({
              backLabel: 'Previous',
              block: true,
              nextLabel: 'Next',
              titleClick: true,
              titleTarget: '.stepy-tab'
          });
      });
  </script>
    <script type="text/javascript" src="<c:url value="/public/Admin/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"/>"></script>
    <script>
        $( document ).ready(function() {
            $('#fecha').datepicker();
        });
    </script>

  </body>
</html>