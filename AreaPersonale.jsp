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
        <c:if test="${empty utente}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        <c:if test="${not empty utente}">
            <%@include file="common/header.jspf" %> 
            <%@include file="common/nav.jspf" %> 
            <main class="col-8">
                <h1>Benvenuto <b>${utente.getUsername()}</b>!</h1>
                <p><h3>Informazioni personali:</h3><br>
                    Nome: <b>${utente.getNome()}</b><br>
                    Username: <b>${utente.getUsername()}</b><br>
                    E-mail: <b>${utente.getE_Mail()} </b><br>
                   
                    Ultimo accesso:<b> ${lastlogin}</b><br><br>
                    Effettua il logout<br>
                   <a href="logoutServlet"><button type="button">Logout</button></a>
                </p>
            </main>
            <%@include file="common/aside.jspf" %> 
            <%@include file="common/footer.jspf" %>
        </c:if>
    </body>
</html>
