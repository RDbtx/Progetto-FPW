<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>DIEE Tech - Chi Siamo</title>
        <link type="text/css" rel="stylesheet" href="testcss.css" media="screen">
        <link rel="shortcut icon" href="img/DT_bk_W.png" />
        <meta name="author" content="Andrea Amato">
        <meta name="description" content="Sito per sviluppo di nuove tecnologie">
        <meta name="keywords" content="DIEE, technologies, web, internet, windows, android, mac">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/code.js"></script>
    </head>
    <body>
        <%@include file="common/header.jspf" %> 
        <%@include file="common/nav.jspf" %> 
        
        <main class="col-8 content">
            <h2>Il Nostro Team</h2>
            <p> Esperti ingegneri, discepoli del Dieedaci  </p>
            <div class="person">
                <img src="img/chi_siamo/AA10.jpeg" height="100" alt="Profilo Amato"/>
                <h3>Andrea Amato</h3>
                <h4>Amministratore Delegato</h4>
                Capogruppo del team, fu il primo a ricevere 
                la consacrazione di passare PSD scrivendo con una sola mano.<br>
            </div>   
            <div class="person">
                <img src="img/chi_siamo/Lecca.jpg" height="100" alt="Profilo Lecca"/>
                <h3>Riccardo Lecca</h3>
                <h4>Direttore Marketing</h4>
                Ultimo entrato nella setta dei Diee, passò Pais a pieni voti.<br>
            </div>
            <div class="person">
                <img src="img/chi_siamo/RDphoto.jpg" height="100" alt="Profilo Deidda"/>
                <h3>Riccardo Deidda</h3>
                <h4>Graphic Designer</h4>
                Forte di aver passato PAIS al primo appello, sfidò il gran maestro
                Dieedaci battendolo senza difficoltà.<br>
            </div>
            <div class="person">
                <img src="img/chi_siamo/Vinci.jpg" height="100" alt="Profilo Vinci"/>
                <h3>Alessio Vinci</h3>
                <h4>Segretario Generale</h4>
                Nessuno ebbe mai li coraggio di rifiutare la valutazione del gran 
                maestro Muscaz, lui si. E fu inserito nella setta immediatamente.<br>
            </div>
        </main>
        <%@include file="common/aside.jspf" %> 
        <%@include file="common/footer.jspf" %>
    </body>
</html>
