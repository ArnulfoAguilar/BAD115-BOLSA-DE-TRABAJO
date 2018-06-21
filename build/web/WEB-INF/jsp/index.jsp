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
    <link rel="shortcut icon" href="/public/img/favicon.png">

    <title>WorkZone</title>

    <%@include file="/WEB-INF/jsp/include/Principal/cssPrincipal.jsp" %>
  </head>

  <body>
      
   <%@include file="/WEB-INF/jsp/include/Principal/headerPrincipal.jsp" %>
     <!-- revolution slider start -->
     <div class="fullwidthbanner-container main-slider">
         <div class="fullwidthabnner">
             <ul id="revolutionul" style="display:none;">
                 <!-- 1st slide -->
                 <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="">
                     <div class="caption lfl slide_item_left"
                          data-x="10"
                          data-y="70"
                          data-speed="400"
                          data-start="1500"
                          data-easing="easeOutBack">
                         <img src="<c:url value="/public/Principal/img/banner/ban2.png"/>" alt="Image 1">
                     </div>
                     <div class="caption lfr slide_title"
                          data-x="670"
                          data-y="120"
                          data-speed="400"
                          data-start="1000"
                          data-easing="easeOutExpo">
                         Rapido y Efectivo
                     </div>

                     <div class="caption lfr slide_subtitle dark-text"
                          data-x="670"
                          data-y="190"
                          data-speed="400"
                          data-start="2000"
                          data-easing="easeOutExpo">
                         Encuentra las mejores ofertas de empleos
                     </div>
                     <div class="caption lfr slide_desc"
                          data-x="670"
                          data-y="260"
                          data-speed="400"
                          data-start="2500"
                          data-easing="easeOutExpo">
                         Ingresa tus datos y tu hoja de vida  <br>
                         en la oferta que mas te interese,<br>
                         nosotros nos encargamos de los demas.
                     </div>
                     <a class="caption lfr btn yellow slide_btn" href="login.htm" target="_blank"
                        data-x="670"
                        data-y="400"
                        data-speed="400"
                        data-start="3500"
                        data-easing="easeOutExpo">
                         Login
                     </a>

                 </li>

                 <!-- 2nd slide  -->
                 <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="">
                     <!-- THE MAIN IMAGE IN THE FIRST SLIDE -->
                     <img src="<c:url value="/public/Principal/img/banner/banner_bg.jpg"/>" alt="">
                     <div class="caption lft slide_title"
                          data-x="10"
                          data-y="125"
                          data-speed="400"
                          data-start="1500"
                          data-easing="easeOutExpo">
                         TRABAJO SOÑADO
                     </div>
                     <div class="caption lft slide_subtitle dark-text"
                          data-x="10"
                          data-y="180"
                          data-speed="400"
                          data-start="2000"
                          data-easing="easeOutExpo">
                         Encuentra tu trabajo soñado
                     </div>
                     <div class="caption lft slide_desc dark-text"
                          data-x="10"
                          data-y="240"
                          data-speed="400"
                          data-start="2500"
                          data-easing="easeOutExpo">
                         Estas a solo un clic de conseguir el trabajo que siempre soñaste <br>
                         no pierdas mas el tiempo y empieza a ganar dinero,<br>
                         aplica a nuestra lista de puestos.
                     </div>
                     <a class="caption lft slide_btn btn red slide_item_left" href="#" target="_blank"
                        data-x="10"
                        data-y="360"
                        data-speed="400"
                        data-start="3000"
                        data-easing="easeOutExpo">
                         Aplicar YA
                     </a>
                     <div class="caption lft start"
                          data-x="640"
                          data-y="55"
                          data-speed="400"
                          data-start="2000"
                          data-easing="easeOutBack"  >
                         <img src="<c:url value="/public/Principal/img/banner/man.png"/>" alt="man">
                     </div>
                     <div class="caption lft slide_item_right"
                          data-x="330"
                          data-y="20"
                          data-speed="500"
                          data-start="5000"
                          data-easing="easeOutBack">
                         <img src="<c:url value="/public/Principal/img/banner/test_man.png"/>" id="rev-hint2" alt="txt img">
                     </div>

                 </li>

                 <!-- 3rd slide  -->
                 <li data-transition="fade" data-slotamount="7" data-masterspeed="300" data-delay="9400" data-thumb="">
                     <img src="<c:url value="/public/Principal/img/banner/red-bg.jpg"/>" alt="">
                     <div class="caption lfl slide_item_right"
                          data-x="10"
                          data-y="105"
                          data-speed="1200"
                          data-start="1500"
                          data-easing="easeOutBack">
                         <img src="<c:url value="/public/Principal/img/banner/imac.png"/>" alt="Image 1">
                     </div>
                     <div class="caption lfl slide_item_right"
                          data-x="25"
                          data-y="345"
                          data-speed="1200"
                          data-start="2000"
                          data-easing="easeOutBack">
                         <img src="<c:url value="/public/Principal/img/banner/tab.png"/>" alt="Image 1">
                     </div>
                     <div class="caption lfl slide_item_right"
                          data-x="200"
                          data-y="330"
                          data-speed="1200"
                          data-start="2500"
                          data-easing="easeOutBack">
                         <img src="<c:url value="/public/Principal/img/banner/mobile.png"/>" alt="Image 1">
                     </div>
                     <div class="caption lfl slide_item_right"
                          data-x="250"
                          data-y="230"
                          data-speed="1200"
                          data-start="3000"
                          data-easing="easeOutBack">
                         <img src="<c:url value="/public/Principal/img/banner/laptop.png"/>" alt="Image 1">
                     </div>
                     <div class="caption lfl slide_item_right"
                          data-x="165"
                          data-y="30"
                          data-speed="500"
                          data-start="5000"
                          data-easing="easeOutBack">
                         <img src="<c:url value="/public/Principal/img/banner/text_imac.png"/>" id="rev-hint1" alt="Image 1">
                     </div>

                     <div class="caption lfr slide_title slide_item_left yellow-txt"
                          data-x="670"
                          data-y="145"
                          data-speed="400"
                          data-start="3500"
                          data-easing="easeOutExpo">
                         Todo desde tu casa
                     </div>
                     <div class="caption lfr slide_subtitle slide_item_left"
                          data-x="670"
                          data-y="200"
                          data-speed="400"
                          data-start="4000"
                          data-easing="easeOutExpo">
                         Desde casa
                     </div>
                     <div class="caption lfr slide_desc slide_item_left"
                          data-x="670"
                          data-y="280"
                          data-speed="400"
                          data-start="4500"
                          data-easing="easeOutExpo">
                         Puedes acceder a nuestras listas de empleo <br>
                         sin necesidad de salir de tu casa <br>
                         todo el proceso es online <br>
            
                     </div>


                 </li>

             </ul>
            <div class="tp-bannertimer tp-top"></div>
         </div>
     </div>
     <!-- revolution slider end -->

    <!--container start-->
    <div class="container">
        <div class="row">
            <!--feature start-->
            <div class="text-center feature-head">
                <h1>WorkZone</h1>
                <p>El sitio ideal para desenvolverse profesionalmente</p>
            </div>
            <div class="col-lg-4 col-sm-4">
                <section>
                    <div class="f-box">
                        <i class=" icon-desktop"></i>
                        <h2>registro gratuito</h2>
                    </div>
                    <p class="f-text">No necesitas ninguna inversion para empezar a aplicar a puestos de trabajo o a publicar tu vacante si eres dueño de empresa.</p>
                </section>
            </div>
            <div class="col-lg-4 col-sm-4">
                <section>
                    <div class="f-box active">
                        <i class=" icon-code"></i>
                        <h2>Nuevos empleos diariamente</h2>
                    </div>
                    <p class="f-text">Todos los dias las empresas publican sus vacantes en la plataforma.</p>
                </section>
            </div>
            <div class="col-lg-4 col-sm-4">
                <section>
                    <div class="f-box">
                        <i class="icon-gears"></i>
                        <h2>Completa tu perfil profesional</h2>
                    </div>
                    <p class="f-text">Debes tener tu informacion actualizada para que las empresas vean lo bueno que eres!.</p>
                </section>
            </div>
            <!--feature end-->
        </div>
        <div class="row">
            <!--quote start-->
            <div class="quote">
                <div class="col-lg-9 col-sm-9">
                    <div class="quote-info">
                        <h1>User-Friendly</h1>
                        <p>Navega por todas nuestras pantallas adaptables a todos los dispositivos!</p>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-3">
                    <a href="#" class="btn btn-danger purchase-btn">Navega Ahora</a>
                </div>
            </div>
            <!--quote end-->
        </div>
    </div>
     <div class="container">

        <!--recent work start-->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="r-work">Ofertas de Empleo Recientes</h2>
                <ul class="bxslider">
                    <li>
                        <div class="element item view view-tenth" data-zlname="reverse-effect">
                            <img src="<c:url value="/public/Principal/img/works/img1.jpg"/>" alt="" />
                            <div class="mask">
                                <a data-zl-popup="link" href="javascript:;">
                                    <i class="icon-link"></i>
                                </a>
                                <a data-zl-popup="link2" class="fancybox" rel="group" href="<c:url value="/public/Principal/img/works/img1.jpg"/>">
                                    <i class="icon-search"></i>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="element item view view-tenth" data-zlname="reverse-effect">
                            <img src="<c:url value="/public/Principal/img/works/img2.jpg"/>" alt="" />
                            <div class="mask">
                                <a data-zl-popup="link" href="javascript:;">
                                    <i class="icon-link"></i>
                                </a>
                                <a data-zl-popup="link2" class="fancybox" rel="group" href="<c:url value="/public/Principal/img/works/img2.jpg"/>">
                                    <i class="icon-search"></i>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="element item view view-tenth" data-zlname="reverse-effect">
                            <img src="<c:url value="/public/Principal/img/works/img3.jpg"/>" alt="" />
                            <div class="mask">
                                <a data-zl-popup="link" href="javascript:;">
                                    <i class="icon-link"></i>
                                </a>
                                <a data-zl-popup="link2" class="fancybox" rel="group" href="<c:url value="/public/Principal/img/works/img3.jpg"/>">
                                    <i class="icon-search"></i>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="element item view view-tenth" data-zlname="reverse-effect">
                            <img src="<c:url value="/public/Principal/img/works/img4.jpg"/>" alt="" />
                            <div class="mask">
                                <a data-zl-popup="link" href="javascript:;">
                                    <i class="icon-link"></i>
                                </a>
                                <a data-zl-popup="link2" class="fancybox" rel="group" href="<c:url value="/public/Principal/img/works/img4.jpg"/>">
                                    <i class="icon-search"></i>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="element item view view-tenth" data-zlname="reverse-effect">
                            <img src="<c:url value="/public/Principal/img/works/img5.jpg"/>" alt="" />
                            <div class="mask">
                                <a data-zl-popup="link" href="javascript:;">
                                    <i class="icon-link"></i>
                                </a>
                                <a data-zl-popup="link2" class="fancybox" rel="group" href="<c:url value="/public/Principal/img/works/img5.jpg"/>">
                                    <i class="icon-search"></i>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="element item view view-tenth" data-zlname="reverse-effect">
                            <img src="<c:url value="/public/Principal/img/works/img6.jpg"/>" alt="" />
                            <div class="mask">
                                <a data-zl-popup="link" href="javascript:;">
                                    <i class="icon-link"></i>
                                </a>
                                <a data-zl-popup="link2" class="fancybox" rel="group" href="<c:url value="/public/Principal/img/works/img6.jpg"/>">
                                    <i class="icon-search"></i>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="element item view view-tenth" data-zlname="reverse-effect">
                            <img src="<c:url value="/public/Principal/img/works/img7.jpg"/>" alt="" />
                            <div class="mask">
                                <a data-zl-popup="link" href="javascript:;">
                                    <i class="icon-link"></i>
                                </a>
                                <a data-zl-popup="link2" class="fancybox" rel="group" href="<c:url value="/public/Principal/img/works/img7.jpg"/>">
                                    <i class="icon-search"></i>
                                </a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="element item view view-tenth" data-zlname="reverse-effect">
                            <img src="<c:url value="/public/Principal/img/works/img1.jpg"/>" alt="" />
                            <div class="mask">
                                <a data-zl-popup="link" href="javascript:;">
                                    <i class="icon-link"></i>
                                </a>
                                <a data-zl-popup="link2" class="fancybox" rel="group" href="<c:url value="/public/Principal/img/works/img1.jpg"/>">
                                    <i class="icon-search"></i>
                                </a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!--recent work end-->

    </div>

     <!--parallax start-->
     <section class="parallax1">
         <div class="container">
             <div class="row">
                 <h1>“Aqui va una frase motivacional”</h1>
             </div>
         </div>
     </section>
     <!--parallax end-->

     <!--container end-->

   <%@include file="/WEB-INF/jsp/include/Principal/footerPrincipal.jsp" %>

   <%@include file="/WEB-INF/jsp/include/Principal/jsPrincipal.jsp" %>


  <script>

      RevSlide.initRevolutionSlider();

      $(window).load(function() {
          $('[data-zlname = reverse-effect]').mateHover({
              position: 'y-reverse',
              overlayStyle: 'rolling',
              overlayBg: '#fff',
              overlayOpacity: 0.7,
              overlayEasing: 'easeOutCirc',
              rollingPosition: 'top',
              popupEasing: 'easeOutBack',
              popup2Easing: 'easeOutBack'
          });
      });

      $(window).load(function() {
          $('.flexslider').flexslider({
              animation: "slide",
              start: function(slider) {
                  $('body').removeClass('loading');
              }
          });
      });

      //    fancybox
      jQuery(".fancybox").fancybox();



  </script>

  </body>

</html>
