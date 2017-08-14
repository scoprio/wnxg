/**
 * Created by Administrator on 2017/5/7.
 */
$(function () {
    //加载城市事件
    $('.container').show();
//选择城市 start
    $('body').on('click', '.city-list p', function () {
        console.log($(this).html());
        console.log($(this).attr("id"));
        
		
    });
    // $('body').on('click','.result_wrap li',function(){
    // 	window.location.href = "index.html?id="+$(this).text();
    // })
    //点击索引查询城市
    $('body').on('click', '.letter a', function () {
        var s = $(this).html();
        console.log(s);
        if($(".tab1").show()){
        	$("body").scrollTop($('#' + s + '1').offset().top);
        }else if($(".tab2").show()){
        	$("body").scrollTop($('#' + s + '2').offset().top);
        }
        $("#showLetter span").html(s);
        $("#showLetter").show().delay(500).hide(0);
    });
     //中间的标记显示
     $('body').on('onMouse', '.showLetter span', function () {
        $("#showLetter").show().delay(500).hide(0);
    });
    $(".tab span").click(function(){
    	$(".box>.container").eq($(this).index()).show().siblings().hide();
    	$('body,html').animate({ scrollTop: 0 },500);
    })
	
	choosecity();
	function choosecity(){
		var result = '';
//		var list = choose_city.length;
//		console.log(choose_city);

		if(choose_city) {
//			for(var i = 0; i < choose_city.length; i++) {				
//				console.log(choose_city[i].citys);
//				for (var j = 0 ; j<choose_city[i].citys.length ; j++) {
//					console.log(choose_city[i].citys[j].id);
//					result += '<p id='+ choose_city[i].citys[j].id+'>'+ choose_city[i].citys[j].title+'</p>';
//					console.log(choose_city[i].citys[j]);
//				}		
//				$('.city-list').eq(choose_city[i].citys[j]).append(result)
//			}	
			
			$.each(choose_city, function (index, obj) {
                	// console.log(index + "..." + obj.citys);
                	result='';
                	$.each(obj.citys, function (index, obj) {	
                		result += '<p id='+ obj.id+'>'+ obj.title+'</p>';
                		console.log("city："+obj.id + "—"+ obj.title);
                	});
                	$('.city-list').eq(index+1).append(result)
                });
		}
	}
	// 城市搜索
    
    var result = '';
    var time = null;
    function city_filter(val_arr){
        console.log(val_arr.length)
        all_city.forEach(function(item) {
            for(var i=0;i<val_arr.length;i++){
                if(item.name.indexOf(val_arr[i]) == -1){
                }
                else{
                    result += '<li data-id='+item.id+'>'+item.name+'</li>';
                    break;
                }
            }
            
        });
        $('.result_wrap>ul>li').remove();
            if(result.length){
                $('.result_wrap>ul').prepend(result);
            }
            else{
                $('.result_wrap>ul').html('<li>没有</li>')
            }
    }
     $('.search_city input').focus(function(event) {
         $('.result_wrap').show()
        time = setInterval(function(){
            result = '';
            var val = $('.search_city input').val();
            var val_arr = val.split(' ')
            if(val.length){
                city_filter(val_arr);
            }
            
        },1000)

    });
//   $('.search_city input').blur(function(event) {
//       $('.result_wrap').hide()
//   });
})