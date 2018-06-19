<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Candidato</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-reset.css" rel="stylesheet"/>
        <link href="resources/css/style-responsive.css" rel="stylesheet"/>
        <link href="resources/css/style.css" rel="stylesheet"/>
        <link href="resources/css/font-awesome/css/font-awesome.css" rel="stylesheet"/>
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>

    </head>
    <body
        <!--main content start-->
        <section id="main-content">
            <section class="wrapper">
                <!-- page start-->
                <div class="row">
                    <aside class="profile-nav col-lg-3">
                        <section class="panel">
                            <div class="user-heading round">
                                <a href="#">
                                    <img src="resources/img/profile-avatar.jpg" alt=""/>
                                </a>
                                <h1>Juan Pérez</h1>
                                <p>juan.perez@ejemplo.com</p>
                                ${Error}
                                <p><c:out value="${Vacio}"/></p>
                            </div>

                            <ul class="nav nav-pills nav-stacked">
                                <li class="active"><a href="#"> <i class="icon-user"></i> Perfil</a></li>
                                <li><a href="#"> <i class="icon-star"></i> Mis Aplicaciones <span class="label label-danger pull-right r-activity">10</span></a></li>
                                <li><a href="#"> <i class="icon-edit"></i> Editar Perfil</a></li>
                            </ul>

                        </section>
                        <section class="panel panel-primary">
                            <header class="panel-heading" style="background-color:#20B2AA">
                                <h5>¿Qué deseas agregar a tu Perfil?</h5>
                            </header>
                            <div class="panel-body"> 
                                <a href="#myModal" data-toggle="modal" class="btn btn-shadow btn-success btn-block">Formación Académica</a>
                                <a href="LogrosIndex.htm?id=${candidato.idPostDoc}" class="btn btn-shadow btn-success btn-block">Logros</a>
                                <a href="ArticuloIndex.htm?id=${candidato.idPostDoc}" class="btn btn-shadow btn-success btn-block">Articulos</a>
                                <a href="TelefonoIndex.htm?id=${candidato.idPostDoc}" class="btn btn-shadow btn-success btn-block">Numeros Telefonicos</a>
                                <button type="button" class="btn btn-shadow btn-success btn-block">Experiencia Laboral</button>
                                <button type="button" class="btn btn-shadow btn-success btn-block">Experiencia Académica</button>
                                <button type="button" class="btn btn-shadow btn-success btn-block">Nuevo Idioma</button>
                                <button type="button" class="btn btn-shadow btn-success btn-block">Habilidades Técnicas</button>
                                <button type="button" class="btn btn-shadow btn-success btn-block">Certificación Obtenida</button>
                            </div>
                        </section>
                    </aside>
                    <aside class="profile-info col-lg-9">
                        <section class="panel panel-primary">
                            <div class="panel-heading">Datos Personales</div>
                            <div class="panel-body">
                                <form:form method="POST" commandName="candidato" >
                                    <div class="row">
                                        <div class="bio-row">
                                            <p>Primer nombre:</p>
                                            <form:input class="form-control" path="primerNombre" placeholder="Primer Nombre" disabled="true"/>
                                        </div>
                                        <div class="bio-row">
                                            <p>Segundo nombre:</p>
                                            <form:input class="form-control" path="segundoNombre" placeholder="Segundo Nombre" disabled="true"/>
                                        </div>
                                        <div class="bio-row">
                                            <p>Tercer nombre:</p>
                                            <form:input class="form-control" path="tercerNombre" placeholder="Tercer Nombre" disabled="true"/>
                                        </div>
                                        <div class="bio-row">
                                            <p>Primer Apellido:</p>
                                            <form:input class="form-control" path="primerApellido" placeholder="Primer Apellido" disabled="true"/>
                                        </div>
                                        <div class="bio-row">
                                            <p>Segundo Apellido:</p>
                                            <form:input class="form-control" path="segundoApellido" placeholder="Segundo Apellido" disabled="true"/>
                                        </div>
                                        <div class="bio-row">
                                            <p>Apellido casada:</p>
                                            <form:input class="form-control" path="casadaApellido" placeholder="Apellido de casada" disabled="true"/>
                                        </div>
                                        <div class="bio-row">
                                            <p>Direccion:</p>
                                            <form:input class="form-control" path="direccion" placeholder="Direccion" disabled="true"/>
                                        </div>
                                        <div class="bio-row">
                                            <p>Email:</p>
                                            <form:input class="form-control" path="email" placeholder="Email" disabled="true"/>
                                        </div>
                                        <div class="bio-row">
                                            <!-- Trigger the modal with a button -->
                                            <button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#myModal">Editar Datos Personales</button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </section>
                        <!-- Modal -->
                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Editar Datos Personales</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form:form method="POST" commandName="candidato" >
                                            <div class="row">
                                                <div class="bio-row">
                                                    <p>Primer nombre:</p>
                                                    <form:input class="form-control" path="primerNombre" placeholder="Primer Nombre"/>
                                                </div>
                                                <div class="bio-row">
                                                    <p>Segundo nombre:</p>
                                                    <form:input class="form-control" path="segundoNombre" placeholder="Segundo Nombre"/>
                                                </div>
                                                <div class="bio-row">
                                                    <p>Tercer nombre:</p>
                                                    <form:input class="form-control" path="tercerNombre" placeholder="Tercer Nombre"/>
                                                </div>
                                                <div class="bio-row">
                                                    <p>Primer Apellido:</p>
                                                    <form:input class="form-control" path="primerApellido" placeholder="Primer Apellido"/>
                                                </div>
                                                <div class="bio-row">
                                                    <p>Segundo Apellido:</p>
                                                    <form:input class="form-control" path="segundoApellido" placeholder="Segundo Apellido"/>
                                                </div>
                                                <div class="bio-row">
                                                    <p>Apellido casada:</p>
                                                    <form:input class="form-control" path="casadaApellido" placeholder="Apellido de casada"/>
                                                </div>
                                                <div class="bio-row">
                                                    <p>Direccion:</p>
                                                    <form:input class="form-control" path="direccion" placeholder="Direccion"/>
                                                </div>
                                                <div class="bio-row">
                                                    <p>Email:</p>
                                                    <form:input class="form-control" path="email" placeholder="Email"/>
                                                </div>
                                            </div>
                                                <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                        <form:button class="finish btn btn-danger">Finalizar Edicion</form:button>
                                    </div>
                                        </form:form>
                                    </div>
                                    
                                </div>

                            </div>
                        </div>
                        <section>
                            <div class="panel panel-info">
                                <div class="panel-heading">Formación Académica</div>
                                <div class="panel-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-md-3">
                                            <h5>Estudiante Universitario
                                                <br><b>5 año</b></h5>
                                        </div>
                                        <div class="col-md-9">
                                            <h4>Ingeniería de Sistemas Informáticos
                                                <br><small>Universidad de El Salvador</small></h4>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="panel panel-info">
                                <div class="panel-heading">Logros</div>
                                <div class="panel-body">
                                    <c:forEach items="${Logros}" var="logro">
                                        <div class="col-md-3">
                                            <h5><b>Realizado en:</b>
                                                <br>${logro.lugar}</h5>
                                        </div>
                                        <div class="col-md-9">
                                            <h4>${logro.fecha}
                                                <br><small>Fecha de realizacion</small></h4>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="panel panel-info">
                                <div class="panel-heading">Articulos elaborados</div>
                                <div class="panel-body">
                                    <c:forEach items="${Articulos}" var="articulo">
                                        <div class="col-md-3">
                                            <h5><b>Nombre:</b>
                                                <br>${articulo.NOMBRE_ARTICULO}</h5>
                                        </div>
                                        <div class="col-md-3">
                                            <h4>${articulo.LUGAR_PUBLICADO}
                                                <br><small>Lugar de publicacion:</small></h4>
                                        </div>
                                        <div class="col-md-6">
                                            <h4>${articulo.NUM_EDICION}
                                                <br><small>Numero de edición:</small></h4>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </section>
                        
                        <section>
                            <div class="panel panel-info">
                                <div class="panel-heading">Experiencia Laboral</div>
                                <div class="panel-body">
                                    <div class="col-lg-2" style="text-align:right">
                                        <h5><b>GOOGLE</b>
                                            <br>Tecnología</h5>
                                    </div>
                                    <div class="col-lg-3">
                                        <h5><b>Ingeniero de Software</b>
                                            <br>2016 - Actual</h5>
                                    </div>
                                    <div class="col-lg-7">
                                        <h5><b>Funciones Realizadas</b><br> skjdflkjsklf fjdksjkfjs kjdfjsdkljfkl sdkhgihsoiadh kajsklgjkasjj askjkgljaskld
                                            jdfklsjlkdfsjkljgfsd
                                            ajkghjadlbladhgljad
                                            jskjfkjkfkajdklsjkjk</h5>
                                    </div>
                                    <div class="col-lg-2" style="text-align:right">
                                        <h5><b>Microsoft</b>
                                            <br>Tecnología</h5>
                                    </div>
                                    <div class="col-lg-3">
                                        <h5><b>Administrador de Servidores</b>
                                            <br>2015 - Actual</h5>
                                    </div>
                                    <div class="col-lg-7">
                                        <h5><b>Funciones Realizadas</b><br> skjdflkjsklf fjdksjkfjs kjdfjsdkljfkl sdkhgihsoiadh kajsklgjkasjj askjkgljaskld
                                            jdfklsjlkdfsjkljgfsdkjdjfhkjadhfjkhfjakhjkfahdkhkadhjkad
                                            ajkghjadlbladhgljadgsadgasd
                                            jskjfkjkfkajdklsjkjk</h5>
                                    </div>
                                </div>
                        </section>
                        <section>
                            <div class="panel panel-info">
                                <div class="panel-heading">Experiencia Académica</div>
                                <div class="panel-body">
                                    <form class="form-horizontal" role="form">


                                    </form>
                                </div>
                            </div>
                        </section>
                        <section>
                            <section>
                                <div class="panel panel-info">
                                    <div class="panel-heading">Idiomas</div>
                                    <div class="panel-body">
                                        <form class="form-horizontal" role="form">


                                        </form>
                                    </div>
                                </div>
                            </section>
                            <div class="panel panel-info">
                                <div class="panel-heading">Habilidades Técnicas</div>
                                <div class="panel-body">
                                    <form class="form-horizontal" role="form">


                                    </form>
                                </div>
                            </div>
                        </section>
                        <section>
                            <div class="panel panel-info">
                                <div class="panel-heading">Certificaciones Obtenidas</div>
                                <div class="panel-body">
                                    <form class="form-horizontal" role="form">


                                    </form>
                                </div>
                            </div>
                        </section>
                    </aside>
                </div>
                <!-- page end-->
            </section>
        </section>
        <!--main content end-->

        <!--MODAL Formación académica-->

        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="modal-title">Form Tittle</h4>
                    </div>
                    <div class="modal-body">

                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="inputEmail1" class="col-lg-2 col-sm-2 control-label">Email</label>
                                <div class="col-lg-10">
                                    <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword1" class="col-lg-2 col-sm-2 control-label">Password</label>
                                <div class="col-lg-10">
                                    <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> Remember me
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <button type="submit" class="btn btn-default">Sign in</button>
                                </div>
                            </div>
                        </form>

                    </div>

                </div>
            </div>
        </div>
        <script src="resources/js/jquery.js"/>
        <script src="resources/js/bootstrap.js"/>
        <script src="resources/js/bootstrap.min.js"/>
    </body>
</html>
