<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>DIEE Tech - Prodotti</title>
        <link type="text/css" rel="stylesheet" href="testcss.css" media="screen">
        <link rel="shortcut icon" href="img/DT_bk_W.png" />
        <meta name="author" content="Andrea Amato">
        <meta name="description" content="Sito per sviluppo di nuove tecnologie - Lista Prodotti">
        <meta name="keywords" content="DIEE, technologies, web, internet, windows, android, mac, prodotti, oscilloscopio, router, ssd, arduino, fpga, verilog, vivado, cisco, switch">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <c:if test="${empty username}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        <c:if test="${not empty username}">
            <%@include file="common/header.jspf" %> 
            <%@include file="common/nav.jspf" %>
            <c:if test="${empty listaProdotti}">
                <c:redirect url="store"/>
            </c:if>
            <c:if test="${not empty listaProdotti}">
                <main class="col-8">
                    <article>
                        <h2>Lista prodotti</h2>
                        <c:forEach items="${listaProdotti}" var="prodotto">
                            <section class="product">
                            <img src="${prodotto.getFoto()}" width="100" alt="Foto ${prodotto.getNome()}"/>
                            <h3>${prodotto.getNome()}</h3>
                            <p>
                                Descrizione: ${prodotto.getDescrizione()}<br>
                                Programmi necessari: ${prodotto.getSoftware()}<br>
                                Prezzo: &#8364 ${prodotto.getPrezzo()}<br>
                                Quantità disponibili: ${prodotto.getQuantita()}<br>
                                Autore: ${prodotto.getUtente_id()}<br>
                            </p>
                            </section>
                        </c:forEach>
                    </article>
                </main>
                <%@include file="common/aside.jspf" %> 
                <%@include file="common/footer.jspf" %>
            </c:if>
        </c:if>
    </body>
</html>

