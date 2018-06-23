<%@include file="/WEB-INF/jsp/include/Principal/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Upssss!</h1>
        <p>Se han encontrados los siguientes errores</p>
        ${Errores}
        <c:forEach items="${Errores}" var="error">
        <tr>
            <th>${error}</th>
        </tr>
    </c:forEach>
</body>
</html>
