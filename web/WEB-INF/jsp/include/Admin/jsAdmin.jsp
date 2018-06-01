  <!-- js placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/public/Admin/js/jquery.js"/>"></script>
    <script src="<c:url value="/public/Admin/js/jquery-1.8.3.min.js"/>"></script>
    <script src="js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="<c:url value="/public/Admin/js/jquery.dcjqaccordion.2.7.js"/>"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="<c:url value="/public/Admin/js/jquery.nicescroll.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/public/Admin/js/jquery.sparkline.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/public/Admin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"/>"></script>
    <script src="<c:url value="/public/Admin/js/owl.carousel.js"/>" ></script>
    <script src="<c:url value="/public/Admin/js/jquery.customSelect.min.js"/>" ></script>
    <script src="<c:url value="/public/Admin/js/respond.min.js"/>" ></script>

    <script class="include" type="text/javascript" src="<c:url value="/public/Admin/js/jquery.dcjqaccordion.2.7.js"/>"></script>

    <!--common script for all pages-->
    <script src="<c:url value="/public/Admin/js/common-scripts.js"/>"></script>

    <!--script for this page-->
    <script src="<c:url value="/public/Admin/js/sparkline-chart.js"/>"></script>
    <script src="<c:url value="/public/Admin/js/easy-pie-chart.js"/>"></script>
    <script src="<c:url value="/public/Admin/js/count.js"/>"></script>

  <script>

      //owl carousel

      $(document).ready(function() {
          $("#owl-demo").owlCarousel({
              navigation : true,
              slideSpeed : 300,
              paginationSpeed : 400,
              singleItem : true,
			  autoPlay:true

          });
      });

      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>