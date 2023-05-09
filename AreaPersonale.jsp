<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="testcss.css" media="screen">
        <link rel="shortcut icon" href="img/DT_bk_W.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DIEE Tech - Area Personale</title>
    </head>
    <body>
        <c:if test="${empty username}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        <c:if test="${not empty username}">
            <jsp:include page="header.jsp"/> 
            <jsp:include page="nav.jsp"/>
            <main class="col-8">
                <h1>Benvenuto ${nome}!</h1>
                <p><h3>Informazioni personali:</h3><br>
                   Nome: ${nome}<br>
                   Cognome: ${username}<br>
                   E-mail: ${email}<br>
                   Città: ${citta}<br>
                   Ultimo accesso: ${lastlogin}<br><br>
                   Effettua il logout<br>
                   <a href="logoutServlet"><button type="button">Logout</button></a>
                </p>
            </main>
            <jsp:include page="aside.jsp"/>
            <jsp:include page="footer.jsp"/>
        </c:if>
    </body>
</html>
