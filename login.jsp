<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>DIEE Tech - Login</title>
        <link type="text/css" rel="stylesheet" href="testcss.css" media="screen">
        <link rel="shortcut icon" href="img/DT_bk_W.png" />
        <meta name="author" content="Diee Tech Group">
        <meta name="description" content="Sito per sviluppo di nuove tecnologie e vendita di supporti per aziende
              tech e nell ambito elettrico elettronico e informatico, sezione di login e registrazione account">
        <meta name="keywords" content="DIEE,aziende, technologies,registrazione,login,acccesso,accedi,profilo">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/code.js"></script>
    </head>
    <body>
        <%@include file="common/header.jspf" %> 
        <%@include file="common/nav.jspf" %> 
        
        <main class="col-8 content">
            <h2 class="login-reg-title">Welcome back to DIEE Account</h2>
            
            <section id="login">
                <c:if test="${empty username}">
                <h3>Accedi all'area riservata del DIEE Tech.</h3>
                <form action="login" method="POST">
                    <label  for="username">Username</label>
                    <input  type="text" name="username" id="username">
                    <br>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password">
                    <br>
                    <input type="submit" value="Accedi">
                </form>
                </c:if>
                <c:if test="${not empty username}">
                <form action="logout" method="POST">
                    <h3>Sei autenticato come ${username}</h3>
                    <p>Effettua il logout</p>
                    <br>
                    <a href="logoutServlet"><button type="button">Logout</button></a>
                </form>
                </c:if>
            </section> 
            
            
            
           
        
        <br>
        
        <h2 class="login-reg-title">Welcome to DIEE Registration</h2>
        <section id="registration">
            <form enctype="multipart/form-data" action="registrazione" method = "POST">
                <h3>Compila il form per registrarti:</h3>
                <label for="regname">Nome</label>
                <input type="text" id="regname" placeholder="Mario" name="name">
                <br>
                <label for="regsurname">Cognome</label>
                <input type="text" id="regsurname" placeholder="Rossi" name="surname">
                <br>
                <label for="regsurname">Username</label>
                <input type="text" id="regusername" placeholder="mariorossi00" name="username">
                <br>
                <label for="rege-mail">E-mail</label>
                <input type="email" id="rege-mail" placeholder="...@gmail.com" name="e_mail">
                <br>
                <label for="regsurname">Città</label>
                <input type="text" id="regcity" placeholder="Roma" name="citta">
                <br>
                <label for="regpassword">Password</label>
                <input type="password" id="regpassword" placeholder="password" name="password">
                <br>
                <label for="psw-repeat">Ripetere la password</label>
                <input type="password" placeholder="password" name="psw_repeat" id="psw_repeat">
                <br>
                <label for="image">Foto profilo</label>
                <input type="file" accept="image/png, image/jpeg" placeholder="immagine" name="image" id="image">
                <br>
                <input type="submit" value="Registrati">
                <br>
                <br>
            </form>
        </section>
        </main>
        <%@include file="common/aside.jspf" %> 
        <%@include file="common/footer.jspf" %>
    </body> 
</html>    
