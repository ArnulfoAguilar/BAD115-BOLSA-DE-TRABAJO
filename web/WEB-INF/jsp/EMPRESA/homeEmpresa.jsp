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

    <title>HOME</title>

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
       
              <h1>HOME</h1>

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
