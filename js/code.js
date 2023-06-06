/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function(){
    //Bottoni per dimensione Font
    var currentSize = 16;
    var currentWidth = 9;
    var currentHeight = 9;
    var currentMarginTop = 20;
    
    //bottoni
    $("#decreaseA").click(function(){
        //limite riduzione dimensione(min 7px)
        if(currentSize>=10){
           currentSize -= 3;
           currentWidth -= 0.9;
           currentHeight -= 0.9;
           currentMarginTop -= 5;
           updateSize();
           updateImg(); 
        }

    });


    $("#resetA").click(function(){
        currentSize = 16;
        currentWidth = 9;
        currentHeight = 9;
        currentMarginTop = 20;
        updateSize();
        updateImg();
    });

    $("#increaseA").click(function(){
        //limite massimo incremento dimensione(max 28px)
        if(currentSize<=25){
        currentSize +=3;
        currentWidth += 0.9;
        currentHeight += 0.9;
        currentMarginTop += 5;
        updateSize();
        updateImg();}
    });
    
    function updateSize(){
        var Size = $(".content");
        Size.css("font-size",currentSize+"px");
    }
    function updateImg(){
        $(".person img").css({"width" : currentWidth + "%", "height": currentHeight + "%", "margin-top": currentMarginTop + "px"});
    }
    
    var offset = 0;
    function aggiornaProdotto(prodotto){
        $('#fotoProdotto').html('<img src="'+ prodotto.foto +'" width="100" alt="Foto' + prodotto.name + '"/>');
        $("#nomeProdotto").text(prodotto.name);
        $("#datiProdotto").html("<b>Descrizione</b>: " + prodotto.desc + "<br>"
                                + "<b>Programmi necessari</b>: " + prodotto.software + "<br>"
                                + "<b>Prezzo:</b> &#8364 " + prodotto.price + "<br>"
                                + "<b>Quantità disponibili:</b> " + prodotto.quantity + "<br>"
                                + "<b>Autore:</b> " + prodotto.user);
    };
    $('#prevProduct').click(function(){
       if(offset > 0)
           offset--;
       $.ajax({
          url:"store",           /* nome servlet */
          data:{
              offsetId: offset
          },
          dataType:"json",
          success: function (data, state){
              aggiornaProdotto(data);
          },
          error: function(data, state){}
       });
    });
    $('#nextProduct').click(function(){
           offset++;
       $.ajax({
          url:"store",           /* nome servlet */
          data:{
              offsetId: offset
          },
          dataType:"json",
          success: function (data, state){
              if(data.user === "")
                  offset--;
              else
                aggiornaProdotto(data);
                
          },
          error: function(data, state){}
       });
       
    });
    
    $('#username').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 10)
            if(!(key===46 || key===8))
                e.preventDefault();     
    });
    
    $('#username').keyup(function(){
        $('#caratteriRimanentiUser').text("Caratteri: " + $(this).val().length + "/10 minimo 3");
        $('#caratteriRimanentiUser').css({"color": "white"});
    });
    
   $('#password').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 15)
            if(!(key===46 || key===8)){
                e.preventDefault();
            }
    });
    
    $('#password').keyup(function(){
        $('#caratteriRimanentiPass').text("Caratteri: " + $(this).val().length + "/15 minimo 4");
        $('#caratteriRimanentiPass').css({"color": "white"});
    });
    
    
   $('#regname').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 15)
            if(!(key===46 || key===8))
                e.preventDefault();
    });
    
    $('#regname').keyup(function(){
        $('#caratteriRimanentiRegname').text("Caratteri: " + $(this).val().length + "/15 minimo 2");
        $('#caratteriRimanentiRegname').css({"color": "white"});
    });
    
   $('#regsurname').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 15)
            if(!(key===46 || key===8))
                e.preventDefault();
            
    });
    
    $('#regsurname').keyup(function(){
        $('#caratteriRimanentiRegsurname').text("Caratteri: " + $(this).val().length + "/15 minimo 2");
        $('#caratteriRimanentiRegsurname').css({"color": "white"});
    });
    $('#regusername').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 10)
            if(!(key===46 || key===8))
               // $('<p>').text('Inserisci più caratteri.').insertAfter('#caratteriRimanentiUser');
                e.preventDefault();
    });
    
    $('#regusername').keyup(function(){
        $('#caratteriRimanentiRegusername').text("Caratteri: " + $(this).val().length + "/10 minimo 3");
        $('#caratteriRimanentiRegusername').css({"color": "white"});
    });
   $('#rege-mail').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 15)
            if(!(key===46 || key===8))
                e.preventDefault();
    });
    
    $('#rege-mail').keyup(function(){
        $('#caratteriRimanentiRegemail').text("Caratteri: " + $(this).val().length + "/15 minimo 10");
        $('#caratteriRimanentiRegemail').css({"color": "white"});
    });
    
   $('#regcity').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 25)
            if(!(key===46 || key===8))
                e.preventDefault();
    });
    
    $('#regcity').keyup(function(){
        $('#caratteriRimanentiRegcity').text("Caratteri: " + $(this).val().length + "/25 minimo 2");
        $('#caratteriRimanentiRegcity').css({"color": "white"});
    });
    
   $('#regpassword').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 15)
            if(!(key===46 || key===8))
                e.preventDefault();
    });
    
    $('#regpassword').keyup(function(){
        $('#caratteriRimanentiRegpassword').text("Caratteri: " + $(this).val().length + "/15 minimo 4");
        $('#caratteriRimanentiRegpassword').css({"color": "white"});
    });
    
   $('#psw_repeat').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 15)
            if(!(key===46 || key===8))
                e.preventDefault();
    });
    
    $('#psw_repeat').keyup(function(){
        $('#caratteriRimanentiRegpswrepeat').text("Caratteri: " + $(this).val().length + "/15 minimo 4");
        $('#caratteriRimanentiRegpswrepeat').css({"color": "white"});
    });
    
    $('#formLog').submit(function(e) {
    var user = $('#username').val().length;
    var pass = $('#password').val().length;

        if (user < 3) {
          $('#caratteriRimanentiUser').text("L'username deve contenere almeno 3 caratteri.");
          $('#caratteriRimanentiUser').css({"color": "red"});
          e.preventDefault();
        };
        if (pass < 4) {
          $('#caratteriRimanentiPass').text("La password deve contenere almeno 4 caratteri.");
          $('#caratteriRimanentiPass').css({"color": "red"});
          e.preventDefault();
        };
    });
    
    
    $('#formReg').submit(function(e) {
    var nome = $('#regname').val().length;
    var cognome = $('#regsurname').val().length;
    var email = $('#rege-mail').val().length;
    var citta = $('#regcity').val().length;
    var user = $('#regusername').val().length;
    var pass = $('#regpassword').val().length;
    var password = $('#regpassword').val();
    var passwordRepeat = $('#psw_repeat').val();
   

        if (nome < 2) {
          $('#caratteriRimanentiRegname').text("Il nome deve contenere almeno 2 caratteri.");
          $('#caratteriRimanentiRegname').css({"color": "red"});
          e.preventDefault();
        };
        if (cognome < 2) {
          $('#caratteriRimanentiRegsurname').text("Il cognome deve contenere almeno 2 caratteri.");
          $('#caratteriRimanentiRegsurname').css({"color": "red"});
          e.preventDefault();
        };
        if (user < 3) {
          $('#caratteriRimanentiRegusername').text("L'username deve contenere almeno 3 caratteri.");
          $('#caratteriRimanentiRegusername').css({"color": "red"});
          e.preventDefault();
        };
        if (pass < 3) {
          $('#caratteriRimanentiRegpassword').text("La password deve contenere almeno 3 caratteri.");
          $('#caratteriRimanentiRegpassword').css({"color": "red"});
          e.preventDefault();
        };
        if (email < 10) {
          $('#caratteriRimanentiRegemail').text("L'e-mail deve contenere almeno 10 caratteri e il carattere @.");
          $('#caratteriRimanentiRegemail').css({"color": "red"});
          e.preventDefault();
        };
        if (citta < 2) {
          $('#caratteriRimanentiRegcity').text("La città deve contenere almeno 2 caratteri.");
          $('#caratteriRimanentiRegcity').css({"color": "red"});
          e.preventDefault();
        };
        if (password !== passwordRepeat) {
          $('#caratteriRimanentiRegpswrepeat').text("Le password non coincidono");  
          $('#caratteriRimanentiRegpswrepeat').css({"color": "red"});
          e.preventDefault();
        };
    });
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONTROLLO NEW PRODUCT
    
    $('#product_p').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length > 20)
            if(!(key===46 || key===8))
               // $('<p>').text('Inserisci più caratteri.').insertAfter('#caratteriRimanentiUser');
                e.preventDefault();
    });
    
    $('#product_p').keyup(function(){
        $('#caratteriRimanentiProdotto').text("Caratteri: " + $(this).val().length + "/20");
    });
    
    $('#quantity_p').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 1000)
            if(!(key===46 || key===8))
               // $('<p>').text('Inserisci più caratteri.').insertAfter('#caratteriRimanentiUser');
                e.preventDefault();
    });
    
    $('#quantity_p').keyup(function(){
        $('#caratteriRimanentiQuantita').text("Quantità: " + $(this).val() + "/1000");
    });
    
    $('#software_p').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 20)
            if(!(key===46 || key===8))
               // $('<p>').text('Inserisci più caratteri.').insertAfter('#caratteriRimanentiUser');
                e.preventDefault();
    });
    
    
    $('#software_p').keyup(function(){
        $('#caratteriRimanentiSoftware').text("Caratteri: " + $(this).val().length + "/20");
    });
    
    $('#prezzo_p').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 999999)
            if(!(key===46 || key===8))
               // $('<p>').text('Inserisci più caratteri.').insertAfter('#caratteriRimanentiUser');
                e.preventDefault();
    });
    
    
    $('#prezzo_p').keyup(function(){
        $('#caratteriRimanentiPrezzo').text("Caratteri: " + $(this).val().length + "/999999");
    });
    
    $('#description_p').keydown(function(e){
        var key = e.keyCode || e.charCode;
        if(this.value.length >= 1000)
            if(!(key===46 || key===8))
               // $('<p>').text('Inserisci più caratteri.').insertAfter('#caratteriRimanentiUser');
                e.preventDefault();
    });
    
    $('#description_p').keyup(function(){
        $('#caratteriRimanentiDescrizione').text("Caratteri: " + $(this).val().length + "/1000");
    });
    
    
    $('#formProdotto').submit(function(e) {
    var prodotto = $('#product_p').val().length;
    var quantita = $('#quantity_p').val();
    var software = $('#software_p').val().length;
    var prezzo = $('#prezzo_p').val().length;
    var descrizione = $('#description_p').val().length;
    
   

        if (prodotto < 1){
            $('#caratteriRimanentiProdotto').text("Il nome del prodotto deve contenere almeno 1 carattere.");
            $('#caratteriRimanentiProdotto').css({"color": "red"});
            e.preventDefault();
        };
            
        if (quantita < 1) {
            $('#caratteriRimanentiQuantita').text("La quantità del prodotto deve essere almeno 1.");
            $('#caratteriRimanentiQuantita').css({"color": "red"});
            e.preventDefault();
        };
        if (software < 1){
            $('#caratteriRimanentiSoftware').text("Il campo Software deve contenere almeno 1 carattere.");
            $('#caratteriRimanentiSoftware').css({"color": "red"});
            e.preventDefault();
        };
        if (prezzo < 0.01){
          $('#caratteriRimanentiPrezzo').text("Il prezzo del prodotto deve essere superiore a 0.01.");
          $('#caratteriRimanentiPrezzo').css({"color": "red"});
          e.preventDefault();
        };
        if (descrizione < 1) {
          $('#caratteriRimanentiDescrizione').text('Il campo della descrizione deve contenere almeno 1 carattere.');
          $('#caratteriRimanentiDescrizione').css({"color": "red"});
          e.preventDefault();
        }
    });

});
