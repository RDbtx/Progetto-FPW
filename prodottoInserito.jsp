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
        <link type="text/css" rel="stylesheet" href="testcss.css" media="screen">
        <link rel="shortcut icon" href="img/DT_bk_W.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/code.js"></script>
        <title>DIEE Tech - Prodotto Inserito</title>
    </head>
    <body>
        <c:if test="${empty username}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        <c:if test="${not empty username}">
            <%@include file="common/header.jspf" %> 
            <%@include file="common/nav.jspf" %> 
            
            <main class="col-8 content">
                <h2>Prodotto inserito con successo!</h2>
            </main>
            <%@include file="common/aside.jspf" %> 
            <%@include file="common/footer.jspf" %>
        </c:if>
    </body>
</html>
