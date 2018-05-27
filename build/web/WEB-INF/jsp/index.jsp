<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BOLSA DE TRABAJO BAD115</title>
    </head>

    <body>
       	<form:form method="post" action="crear_empresa" commandName="datosCoche">
            <h1>Formulario con datos del coche</h1>
            <table>
                <tbody>
                    <tr>
                        <td>Matrícula:</td>
                        <td><form:input path="matricula" /></td>
                        <td><form:errors path="matricula" cssClass="campoConError"/></td>
                    </tr>
                    <tr>
                        <td>Modelo:</td>
                        <td><form:input path="modelo" /></td>
                        <td><form:errors path="modelo" cssClass="campoConError"/></td>
                    </tr>
                    <tr>
                        <td>Año:</td>
                        <td><form:input path="anho" maxlength="4" /></td>
                        <td><form:errors path="anho" cssClass="campoConError"/></td>
                    </tr>
                    <tr>
                        <td>Kilómetros:</td>
                        <td><form:input path="kilometros" maxlength="6" /></td>
                        <td><form:errors path="kilometros" cssClass="campoConError"/></td>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="submit" value="Enviar" /></td>
                    </tr>
                </tbody>
            </table>
	</form:form>
</body>
</html>
