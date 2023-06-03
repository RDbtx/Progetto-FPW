
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>DIEE Tech</title>
        <link type="text/css" rel="stylesheet" href="testcss.css" media="screen">
        <link rel="shortcut icon" href="img/DT_bk_W.png" />
        <meta name="author" content="Diee Tech Group">
        <meta name="description" content="Sito per sviluppo di nuove tecnologie">
        <meta name="keywords" content="DIEE, technologies, web, internet, windows, android, mac">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/code.js"></script>
    </head>
    <body>
        <%@include file="common/header.jspf" %> 
        <%@include file="common/nav.jspf" %>
        
        <main class="col-8 content">
            <section>
                <h3>Di cosa si occupa Diee Tech?</h3>
                <p>
                    Diee Tech si occupa della vendita di strumentazioni, componenti e dispositivi elettronici.<br> 
                    Se sei un professionista, un maker o semplicemente un appassionato che sta muovendo i primi passi in questo mondo
                    allora sei nel posto giusto!<br>
                    Mettiamo a disposizione la nostra competenza per fornirti il miglior supporto guidandoti verso la scelta migliore.
                </p>
            </section>
            <div id="img-index">
                <img src="img/circuitboard.jpg" alt="circuito" height="150">
                <img src="img/coding.jpeg" alt="code" height="150">
                <img src="img/oscilloscopio.jpg" alt="oscilloscopio" height="150">
            </div>
            <div>
                <p>However big or small your team is, our<br> products will ensure that it always has a smooth and enjoyable
                <br>experience when building your code, planning your work, collaborating</p>
            </div>
            <article id="sezione-news">
                <h2>News & Eventi</h2>
                <ul>
                    <li><section class="notizia">
                        <h4>Nuovo aggiornamento disponibile per il software Dieeliveroo</h4>
                        <p>
                            Da oggi è disponibile in versione BETA l'aggiornamento 2023.4 per il software Dieeliveroo, prodotto dalla Diee Tech per ordinare
                            cibi e bevande all'interno delle Facoltà .
                        </p>
                        </section>
                    </li>
                    <li><section class="notizia">
                        <h4>MJ Tools in rilascio</h4>
                        <p>
                            A breve sarà disponibile MJ Tools, drivers realizzati da Diee Tech in collaborazione con HNT Napoli per lo sviluppo dei distributori
                            automatizzati di caffè.
                        </p>
                        </section>
                    </li>
                    <li><section class="notizia">
                        <h4>Candidature aperte</h4>
                        <p>
                            Diee Tech sta cercando nuovi componenti da inserire nell'organico. Invia il tuo CV all'indirizzo mail di Diee Tech con annessa lettera
                            di presentazione e potresti vivere il sogno del Diee Tech!
                        </p>
                        </section>
                    </li>
                </ul>
            </article>
            <section id="sponsor">
            <h3>Our tools are used all over the world in some of the best-known companies.</h3>
            <ul>
                <li><img src="img/immagini-index/Logo-Diee.png" alt="DIEE" height="50"></li>
                <li><img src="img/immagini-index/Logo_Universita_di_Cagliari.png" alt="UNICA" height="50"></li>
                <li><img src="img/immagini-index/Logo-PRA.png" alt="pra_lab" height="50"></li>
                <li><img src="img/immagini-index/LF.png" height="35" alt="Logo Forneria"/></li>
                <li><img id="unione" src="img/immagini-index/uol-003.png" height="20" alt="Logo Unione Sarda"/></li>
                <li><img id="videolina" src="img/immagini-index/logo_videolina.png" height="25" alt="Logo Videolina"/></li>
                <li><img id="podda" src="img/immagini-index/logo-podda.png" height="50" alt="Logo Podda"/></li>   
            </ul>
        </section>
        </main>
        <%@include file="common/aside.jspf" %> 
        <%@include file="common/footer.jspf" %>
    </body>
</html>
