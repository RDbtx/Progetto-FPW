<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="testcss.css" media="screen">
        <link rel="shortcut icon" href="img/DT_bk_W.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DIEE Tech - Nav</title>
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="store.jsp">Store</a></li>
                <c:if test="${not empty username}">
                    <li><a href="new_product.jsp">Inserisci prodotto</a></li>
                </c:if>
                <li><a href="chi_siamo.jsp">Chi siamo</a></li> 
                <li><a href="login.jsp">Login</a></li>
                <li><a href="AreaPersonale.jsp">Area Personale</a></li>
            </ul>
        </nav>
    </body>
</html>
