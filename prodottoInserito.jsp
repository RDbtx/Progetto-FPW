<%-- 
    Document   : prodottoInserto
    Created on : 7 mag 2023, 17:35:30
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DIEE Tech - Prodotto Inserito</title>
    </head>
    <body>
        <c:if test="${empty username}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        <c:if test="${not empty username}">
            <jsp:include page="header.jsp"/> 
            <jsp:include page="nav.jsp"/>
            <main class="col-8">
                <h1>Prodotto inserito con successo!</h1>
            </main>
            <jsp:include page="aside.jsp"/>
            <jsp:include page="footer.jsp"/>
        </c:if>
    </body>
</html>
