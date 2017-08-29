function layer_tip(form_tip,fun){
    var isLayer = $('.layer_box').length;
    if(!isLayer){
      var layer_box = $('<div class = "layer_box"></div>');
          $('body').append(layer_box);
          $('.layer_box').css({
                  "font-size":'14px',
                  "color":"#fff",
                  "position":"fixed",
                  'left':'0',
                  'right':'0',
                  'top':'25%',
                  'margin':'auto',
                  'width':'180px',
                  'height':'auto',
                  'padding':'10px 15px',
                  'text-align':'center',
                  'background':'rgba(0,0,0,0.5)',
                  'line-height':'22px',
                  'letter-spacing':'1px',
                  'border-radius':'4px',
                  'z-index':'100000'

          });
          $('.layer_box').text(form_tip);
          setTimeout(function(){
              $('.layer_box').remove();
              fun();
          },2000)
    }
    
}