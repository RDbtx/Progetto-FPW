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
        <jsp:include page="header.jsp"/> 
        <jsp:include page="nav.jsp"/>
        <main class="col-8">
            <article>
                <h2>Lista prodotti</h2>
                <section class="product">
                    <img src="img/immagini-store/FPGA.jpeg" width="100" alt="FPGA"/>
                    <h3>FPGA Artix 7</h3>
                    <p>
                    Descrizione: Una scheda digitale programmabile tramite linguaggio Verilog.<br>
                    Programmi necessari: Vivado<br>
                    Prezzo: &#8364 299,99<br>
                    Quantità disponibili: 15<br>
                    </p>
                </section>
                <section class="product">
                    <img src="img/immagini-store/Osc_2.jpg" width="100" alt="Oscilloscopio"/>
                    <h3>Oscilloscopio da banco </h3>
                    <p>Descrizione: Oscilloscopio di archiviazione digitale da banco a 2 canali TBS1072C, 70 MHz <br>
                       Programma necessario: LabVIEW<br>
                       Prezzo: &#8364 1019,99 <br>
                       Quantità disponibili: 5<br>
                    </p>
                </section>
                <section class="product">
                    <img src="img/immagini-store/router.jpg" width="100" alt="Router"/>
                    <h3>Router 4300 series </h3>
                    <p>
                        Descrizione: Un router professionale ideale per reti aziendali, con servizi integrati <br>
                        Programmi necessari: Prompt dei comandi in base al sistema operativo<br>
                        Prezzo: &#8364 399,99 <br>
                        Quantità disponibili: 28<br>
                    </p>
                </section>
                <section class="product">
                    <img src="img/immagini-store/arduino.jpeg" width="100" alt="Arduino"/>
                    <h3>Arduino Uno </h3>
                    <p>
                        Un microcontrollore programabile tramite codice Arduino per l'utilizzo di LED e sensori. <br>
                        Programmi necessari: Arduino<br>
                        Prezzo: &#8364 29,99 <br>
                        Quantità disponibili: 267<br>
                    </p>
                </section>
            </article>
        </main>
        <jsp:include page="aside.jsp"/>
        <jsp:include page="footer.jsp"/>
        </c:if>
    </body>
</html>

