<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </head>
    <body>
        <jsp:include page="header.jsp"/> 
        <jsp:include page="nav.jsp"/>
        <main class="col-8">
            <h2 class="login-reg-title">Welcome back to DIEE Account</h2>
            
            
            <section id="login">
                <c:if test="${empty username}">
                <h3>Accedi all'area riservata del DIEE Tech.</h3>
                <form action="login" method="POST">
                    <label  for="e-mail">E-mail</label>
                    <input  type="text" name="e-mail" id="e-mail">
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
                    <a href="logoutServlet"><button type="button">logout</button></a>
                </form>
                </c:if>
            </section> 
            
            
            
           
        
        <br>
        
        <h2 class="login-reg-title">Welcome to DIEE Registration</h2>
        <section id="registration">
            <form action="registrazione" method = "POST">
                <h3>Compila il form per registrarti:</h3>
                <label for="regname">Nome</label>
                <input type="text" id="regname" placeholder="Mario" name="name">
                <br>
                <label for="regsurname">Cognome</label>
                <input type="text" id="regsurname" placeholder="Rossi" name="surname">
                <br>
                <label for="rege-mail">E-mail</label>
                <input type="email" id="rege-mail" placeholder="...@gmail.com" name="e-mail">
                <br>
                <label for="regpassword">Password</label>
                <input type="password" id="regpassword" placeholder="password" name="password">
                <br>
                <label for="psw-repeat">Ripetere la password</label>
                <input type="password" placeholder="password" name="psw-repeat" id="psw-repeat">
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
        <jsp:include page="aside.jsp"/>
        <jsp:include page="footer.jsp"/>
    </body> 
</html>    
