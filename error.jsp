<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="testcss.css" media="screen">
        <link rel="shortcut icon" href="img/DT_bk_W.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DIEE Tech - Errore</title>
    </head>
    <body>
            <jsp:include page="header.jsp"/> 
            <jsp:include page="nav.jsp"/>
            <main class="col-8">
                <h1>Errore:</h1>
                <p><h2>${errorMessage}</h2><br>
                <a href="${webpage}">Torna al form precedente</a>
                </p>
            </main>
            <jsp:include page="aside.jsp"/>
            <jsp:include page="footer.jsp"/>
        
    </body>
</html>
