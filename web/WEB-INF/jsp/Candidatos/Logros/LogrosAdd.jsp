
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

    <title>Form Wizard</title>

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
                              Registrar Logro
                              Error:${Error}
                          </header>
                          <div class="panel-body">
                              <div class="stepy-tab">
                                  <ul id="default-titles" class="stepy-titles clearfix">
                                      <li id="default-title-0" class="current-step">
                                          <div>Paso 1</div>
                                      </li>
                                      <li id="default-title-1" class="">
                                          <div>Paso 2</div>
                                      </li>
                                      <li id="default-title-2" class="">
                                          <div>Paso 3</div>
                                      </li>
                                      <li id="default-title-3" class="">
                                          <div>Paso 4</div>
                                      </li>
                                      <li id="default-title-4" class="">
                                          <div>Paso 5</div>
                                      </li>
                                      <li id="default-title-5" class="">
                                          <div>Paso 6</div>
                                      </li>
                                  </ul>
                              </div>${identificador}
                              <form:form method="POST" commandName="logro" class="form-horizontal" id="default" >
                                  <fieldset title="Paso 1" class="step" id="default-step-0">
                                      <legend> </legend>
                                      
                                      <div class="form-group">
                                          <label class="col-lg-2 control-label">Lugar</label>
                                          <div class="col-lg-10">
                                              <form:input class="form-control" path="lugar" placeholder="Primer Nombre" />
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-lg-2 control-label">Fecha</label>
                                          <div class="col-lg-10">
                                               <form:input data-date-format='dd/mm/yy' class="form-control" path="fecha" type="text" id="fecha" name="fecha" />
                                          </div>
                                      </div>
                                  </fieldset>
                                 <form:button class="finish btn btn-danger">Registrar logro</form:button>
                          </form:form>
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