<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Nuevo Candidato</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-reset.css" rel="stylesheet"/>
        <link href="resources/css/style-responsive.css" rel="stylesheet"/>
        <link href="resources/css/style.css" rel="stylesheet"/>
        <link href="resources/css/font-awesome/css/font-awesome.css" rel="stylesheet"/>
        <link href="resources/css/font-awesome.css" rel="stylesheet"/>
    </head>
    <body>
        <h1>Registrate!</h1>

        <div class="row login-body">
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        Datos de Registro
                    </header>
                    <div class="panel-body">
                        <label for="nombres">Nombres</label>
                        <form class="form-inline" role="form">
                            <div class="form-group">
                                <label class="sr-only" for="nom1">Primer Nombre</label>
                                <input type="text" class="form-control" id="nombre1" placeholder="Primer Nombre">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="nom2">Segundo Nombre</label>
                                <input type="text" class="form-control" id="nombre2" placeholder="Segundo Nombre">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="nom3">Tercer Nombre</label>
                                <input type="text" class="form-control" id="nombre3" placeholder="Tercer Nombre">
                            </div>
                        </form>
                        <br><label for="apellidos">Apellidos</label>
                        <form class="form-inline" role="form">
                            <div class="form-group">
                                <label class="sr-only" for="apellido1">Primer Apellido</label>
                                <input type="text" class="form-control" id="apellido11" placeholder="Primer Apellido">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="apellido2">Segundo Apellido</label>
                                <input type="text" class="form-control" id="apellido22" placeholder="Segundo Apellido">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="apellidoviuda">Apellido Viuda</label>
                                <input type="text" class="form-control" id="apellidoviuda1" placeholder="Apellido Viuda">
                            </div>
                        </form>
                        <br><label for="Generp">Género</label>
                        <form class="form-inline">
                            <div class="radios">
                                <label class="label_radio col-lg-3 col-sm-6" for="radio-01">
                                    <input name="sample-radio" id="radio-01" value="1" type="radio"/> Masculino
                                </label>
                                <label class="label_radio col-lg-3 col-sm-6" for="radio-02">
                                    <input name="sample-radio" id="radio-02" value="1" type="radio" /> Femenino
                                </label>
                            </div>
                        </form>
                        <br><br><label for="municipio">Municipio al que perteneces</label>
                        <form class="form-inline">
                            <div class="col-lg-4">
                                <select class="form-control m-bot20">
                                    <option>San Salvador</option>
                                    <option>Ayutuxtepeque</option>
                                </select>
                            </div>
                        </form>
                    </div>
                    <section class="panel">
                        <header class="panel-heading">
                            Datos de Acceso
                        </header>
                        <div class="panel-body">
                            <div class="form-group col-lg-6">
                                <label for="usuario">Nombre de Usuario</label>
                                <input type="text" class="form-control" id="user" placeholder="Ej: juanperez01"></input>
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="correo"> Correo Eléctronico</label>
                                <input type="email" class="form-control" id="correo1" placeholder="Ej: juan.perez@ejemplo.com"></input>
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="Pass1">Contraseña</label>
                                <input type="password" class="form-control" id="pass" placeholder="Contraseña">
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="Pass1">Repetir Contraseña</label>
                                <input type="password" class="form-control" id="pass2" placeholder="Repite la Contraseña">   
                            </div>
                            <form>
                                <button type="submit" class="btn btn-success">Finalizar Registro</button>
                            </form>
                        </div>
                    </section>
                </section>
            </div>
    </body>
</html>
