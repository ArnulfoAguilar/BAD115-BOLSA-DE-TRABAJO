<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
    </head>
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
                            <div class="row">
                                <div class="bio-row">
                                    <p><span>Primer Nombre </span>: Juan</p>
                                </div>
                                <div class="bio-row">
                                    <p><span>Primer Apellido </span>: Pérez</p>
                                </div>
                                <div class="bio-row">
                                    <p><span>Departamento</span>: San Salvador</p>
                                </div>
                                <div class="bio-row">
                                    <p><span>Municipio</span>: Ayutuxtepeque</p>
                                </div>
                                <div class="bio-row">
                                    <p><span>NIT </span>: 0614-068978-117-3</p>
                                </div>
                                <div class="bio-row">
                                    <p><span>Teléfono Casa</span>: 2257 - 7777</p>
                                </div>
                                <div class="bio-row">
                                    <p><span>Celular</span>: 7758 - 7889</p>
                                </div>
                                <div class="bio-row">
                                    <p><span>E-mail </span>: juan.perez@ejemplo.com</p>
                                </div>
                                <div class="bio-row">
                                    <p><span>Edad </span>: 24 Años</p>
                                </div>
                            </div>
                        </div>
                    </section>                    
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
</html>
