/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function(){
    //Bottoni per dimensione Font
    var currentSize = 16;
    //bottoni
    $("#decreaseA").click(function(){
        currentSize -= 3;
        updateSize();
    });
    
    
    $("#resetA").click(function(){
        currentSize = 16;
        updateSize();
    });
    
    $("#increaseA").click(function(){
        currentSize +=3;
        updateSize();
    });
    
    function updateSize(){
        var Size = $(".content");
        Size.css("font-size",currentSize+"px");
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
          error: function(data, state){},
       });
       
    });
    
  
  //pagina in evidenza
   var currentPage = window.location.pathname;
  
  $('.nav-link').removeClass('current');
  
  
  $('.nav-link').each(function() {
    var href = $(this).attr('href');
    
    if (currentPage.indexOf(href) !== -1) {
      $(this).addClass('current');
      $('.home_current').removeClass('home_current');
      
      return false; 
    }
  });
  
  
  

});
