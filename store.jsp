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
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/code.js"></script>
    </head>
    <body>
        <c:if test="${empty username}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        <c:if test="${not empty username}">
            <%@include file="common/header.jspf" %> 
            <%@include file="common/nav.jspf" %>
            
            <c:if test="${empty prodotto}">
                <c:redirect url="store"/>
            </c:if>
            <c:if test="${not empty prodotto}">
                <main class="col-8 content">
                    <section>
                        <h2>Prodotti del DIEE TECH</h2>
                        
                        <article class="product">
                            <p id="fotoProdotto">
                                <img src="${prodotto.getFoto()}" width="100" alt="Foto ${prodotto.getNome()}"/>
                            </p>
                            <h3 id="nomeProdotto">${prodotto.getNome()}</h3>
                            <p id="datiProdotto">
                                <b>Descrizione:</b> ${prodotto.getDescrizione()}<br>
                                <b>Programmi necessari:</b> ${prodotto.getSoftware()}<br>
                                <b>Prezzo:</b> &#8364 ${prodotto.getPrezzo()}<br>
                                <b>Quantità disponibili:</b> ${prodotto.getQuantita()}<br>
                                <b>Autore:</b> ${prodotto.getUtente_id()}<br>
                            </p>
                        </article>
                        <article id="storeButtons">
                            <button class="button" id="prevProduct"> < </button>
                            <button class="button" id="nextProduct"> > </button>
                        </article>
                    </section>
                </main>
                <%@include file="common/aside.jspf" %> 
                <%@include file="common/footer.jspf" %>
            </c:if>
        </c:if>
    </body>
</html>

