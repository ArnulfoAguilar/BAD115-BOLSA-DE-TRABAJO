

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

    <title>Actualizar Informacion Empresa</title>

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
                          
                          
                          <div class="panel-body">
                          <form class="form-horizontal tasi-form" method="post">            
                              <c:forEach var="SELECT_EMPRESA" items="${SELECT_EMPRESA}">
                              <header class="panel-heading alert alert-warning">DATOS DE LA EMPRESA
                          </header>
                              <br>
                              <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Nombre Comercial</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="nombreEmpresa" class="form-control" VALUE="${SELECT_EMPRESA.NOMBRE_COMERCIAL}">
                                      </div>
                                  </div>
                              <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Razon Social</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="razonSocial" VALUE="${SELECT_EMPRESA.RAZON_SOCIAL}" class="form-control">
                                      </div>
                                  </div>
                              <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">NIT</label>
                                      <div class="col-sm-4">
                                          <input type="text" disabled="yes" disabled="yes" placeholder="${SELECT_EMPRESA.NIT}" name="nitEmpresa" class="form-control">
                                      </div>
                                      <!--label class="col-sm-2 col-sm-2 control-label">Giro de la empresa</label>
                                      
                                          <div class="col-sm-4">
                                          <select class="form-control m-bot15" name="giro_Empresa" id="giro_Empresa">
                                                 <!--option value="${giro_Empresa.ID_GIRO}">${giro_Empresa.NOMBRE_GIRO}</optioN>
                                          </select>
                                      </div-->
                                  </div>
                              <!--div class="form-group">
                                      <label class="col-sm-2 control-label">Departamento</label>
                                      <div class="col-sm-4">
                                          <select class="form-control m-bot15" name="departamentoEmpresa" id="departamentoEmpresa">                                   
                                                 <!--option value="${Departamento.ID_DEPTO}">${Departamento.NOMBRE_DEPTO}</option>
                                          </select>
                                      </div>
                                      
                                      <label class="col-sm-2 control-label">Municipio</label>
                                      <div class="col-sm-4">
                                          <select class="form-control m-bot15" name="municipioEmpresa" id="municipioEmpresa">
                                                 <!--option value="${Municipio.ID_MUNI}">${Municipio.NOMBRE_MUNI}</option>
                                              
                                          </select>
                                      </div>
                              </div-->
                              
                             
                              <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Direccion</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="direccionEmpresa" VALUE="${SELECT_EMPRESA.UBICACION}"class="form-control">
                                      </div>
                                  </div>
                              
                              
                              
                              <header class="panel-heading alert alert-warning">TIPO DE EMPRESA
                              </header><br>
                              <!--div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Tipo de empresa</label>
                                      <div class="col-sm-10">
                                          <select class="form-control m-bot15" name="tipoEmpresa" id="tipoEmpresa">
                                                 <!--option value="${tipo_Empresa.ID_TIPO_EMP}">${tipo_Empresa.NOMBRE_TIPO_EMP}</option>

                                          </select>
                                      </div>
                                  </div-->
                              <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Descripcion</label>
                                      <div class="col-sm-10">
                                          <textarea type="text" name="descripcionEmpresa" class="form-control">${SELECT_EMPRESA.DESCRIPCION}</textarea>
                                      </div>
                                  </div>
                              <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Pagina Web</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="paginaWeb" VALUE="${SELECT_EMPRESA.PAGINA_WEB}" class="form-control">
                                      </div>
                                  </div>
                              
                              <header class="panel-heading alert alert-warning">DATOS DE PERSONA DE CONTACTO
                              </header><br>
                              <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">DUI</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="duiReclutador" VALUE="${SELECT_EMPRESA.DUI}" class="form-control">
                                      </div>
                                  </div>
                               <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Nombres</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="nombresReclutador" VALUE="${SELECT_EMPRESA.NOMBRES}" class="form-control">
                                      </div>
                                  </div>
                               <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Apellidos</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="apellidosReclutador" VALUE="${SELECT_EMPRESA.APELLIDOS}" class="form-control">
                                      </div>
                                  </div>
                               <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">Telefono</label>
                                      <div class="col-sm-10">
                                          <input type="text" name="telefonoReclutador" VALUE="${SELECT_EMPRESA.TELEFONO}" class="form-control">
                                      </div>
                                  </div>
                              
                              <button type="submit" class="col-sm-2 col-sm-offset-9 col-lg-2 col-lg-offset-9 btn btn-success" value="${pageContext.request.contextPath}/EMPRESA/actualizar_Empresa.htm" >ACTUALIZAR</button>
                          </c:forEach>    
                          </form>    
                          </div>
                      </section>
                 </div>
                          </div>
                      </section>

              <!-- page end-->
          </section>
      </section>
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