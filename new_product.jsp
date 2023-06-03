<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>DIEE Tech - Insert</title>
        <link type="text/css" rel="stylesheet" href="testcss.css" media="screen">
        <link rel="shortcut icon" href="img/DT_bk_W.png" />
        <meta name="author" content="Diee Tech Group">
        <meta name="description" content="Sito per sviluppo di nuove tecnologie">
        <meta name="keywords" content="DIEE, technologies, web, internet, windows, 
              android, mac, store, router, fpga, arduino, microcontrollore, oscilloscopio"> 
        
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
            
        <main class="col-8 content">    
            <section id="product_new" >
                <h2>Inserisci prodotto</h2>
            <form enctype="multipart/form-data" action="NewProduct" method="POST">
                <label for ="product_p">Prodotto: </label>
                <input type = "text" id = "product_p" name = "product_p"><br>
                <label for="quantity_p">Quantità:</label>
                <input type="number" id="quantity_p" name="quantity_p" min = "1" max ="1000" value = "1"><br>
                <label for ="software_p">Software:</label>
                <input type ="text" id = "software_p" name = "software_p"><br>
                <label for="prezzo_p">Prezzo:</label>
                <input type = "number" id = "prezzo_p" name = "prezzo_p" min ="0.00" step ="0.1"  value ="0.00"><br>
                <label for ="image_p">Immagine:</label>
                <input type="file" accept="image/png, image/jpeg" placeholder="immagine" name="image_p" id="image"><br>
                <label for ="description_p">Descrizione:</label>
                <textarea maxlength="10000" name ="description_p" id ="description_p" placeholder="max 1000 caratteri"></textarea><br>
                <input type="submit">
            </form>
            </section>  
        </main>
        <%@include file="common/aside.jspf" %> 
        <%@include file="common/footer.jspf" %> 
        </c:if>
    </body>
</html>
