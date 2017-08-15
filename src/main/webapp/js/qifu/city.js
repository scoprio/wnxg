/**
 * Created by Administrator on 2017/5/7.
 */
$(function () {
    //加载城市事件
    $('.container').show();
//选择城市 start
    $('body').on('click', '.city-list p', function () {
        // alert($(this).html())
    });
    //点击索引查询城市
    $('body').on('click', '.letter a', function () {
        var s = $(this).text();
        var scrollHeight = 0;
        if(document.getElementById(s)){
            var scrollArray = $('#'+s).parent('.city-list').prevAll('.city-list');
            $.each(scrollArray,function(i,item){
                scrollHeight += $(item).height()
            })
            $('.city').scrollTop(scrollHeight);
        }
        $("#showLetter span").html(s);
        $("#showLetter").show().delay(500).hide(0);
    });

     //中间的标记显示
     $('body').on('onMouse', '.showLetter span', function () {
        $("#showLetter").show().delay(500).hide(0);
    });

    // 渲染城市
    choosecity();
    function choosecity(){
        var result = '';
        var result2 = '';
        if(choose_city) {
            $.each(choose_city,function(index, obj){
               result2 += '<div class="city-list">'+'<span class="city-letter" id='+obj.sortword+'>'+obj.sortword+'</span>'+'</div>'
                            
            })
            $('.city').prepend(result2)
            $.each(choose_city, function (index, obj) {
                    result='';
                    $.each(obj.citys, function (index, obj) {   
                        result += '<p id='+ obj.id+'>'+ obj.title+'</p>';
                    });
                    $('.city-list').eq(index).append(result)
                });
        }
    }

})