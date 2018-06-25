<%@include file="/WEB-INF/jsp/include/Principal/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Mis Aspirantes</title>

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
          <!--main content start-->
      <section id="main-content">
          <section class="wrapper site-min-height">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                              Seccion de Mis Aspirantes
                              <!--a class="btn btn-success" href="${pageContext.request.contextPath}/OfertaAdd.htm" role="button">Añadir Oferta</a-->
                              ${Errores}
                          </header>
                          <div class="panel-body">
                              
                              <table  class="display table table-bordered table-striped" id="example">
                                            <thead>
                                                <tr>
                                                    <th>DOCUMENTO</th>
                                                    <th>Primer Nombre</th>
                                                    <th>Segundo Nombre</th>
                                                    <th>Tercer Nombre</th>
                                                    <th>Primer Apellido</th>
                                                    <th>Segundo Apellido</th>
                                                    <th>Direccion</th>
                                                    <th>Porcentaje</th>
                                                    <th class="hidden-phone">Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody>                             
                                                <c:forEach items="${Aspirantes}" var="Aspirante">
                                                    <tr>
                                                        <th>${ASpirante.ID_POST_DOC}</th>
                                                        <th>${Aspirante.PRIMER_NOMBRE}</th>
                                                        <th>${Aspirante.SEGUNDO_NOMBRE}</th>
                                                        <th>${Aspirante.TERCER_NOMBRE}</th>
                                                        <th>${Aspirante.PRIMER_APELIIDO}</th>
                                                        <th>${Aspirante.SEGUNDO_APELLIDO}</th>
                                                        <th>${Aspirante.DIRECCION}</th>
                                                        <th>${Aspirante.PORCENTAJE}</th>
                                                        <th>
                                                            <a class="btn btn-warning" href="${pageContext.request.contextPath}/OfertaEdit.htm?id=${oferta.ID_OFERTA}" role="button">Editar mi Oferta</a>
                                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/OfertaDelete.htm?id=${oferta.ID_OFERTA}" role="button">Eliminar mi Oferta</a>
                                                        </th>
       
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                            <tfoot hidden="true">
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Vacantes</th>
                                                    <th>Fecha de expiracion</th>
                                                    <th>Descripcion</th>
                                                    <th>Tipo Contrato</th>
                                                    <th>Salario</th>
                                                    <th class="hidden-phone">Acciones</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                              
                              
                              <!--c:if test= "${Articulos == null}">
                                  <p>Usted no posee ni un articulo<p>
                              <!--/c:if-->
                          </div>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
<!--main content end-->
      <!--main content end-->
      <!--footer start-->
      <%@include file="/WEB-INF/jsp/include/Admin/footerAdmin.jsp" %>
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


  </body>
</html>
