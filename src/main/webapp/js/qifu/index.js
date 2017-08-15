$(function(){
    
    var page = 0;
    $('.hot_project').dropload({
        scrollArea : window,
        domDown : {
            domClass   : 'dropload-down',
            domRefresh : '<div class="dropload-refresh">↑上拉加载更多</div>',
            domLoad    : '<div class="weui-loadmore"><i class="weui-loading"></i><span class="weui-loadmore__tips">正在加载...</span></div>',
            domNoData  : '<div class="weui-loadmore weui-loadmore_line weui-loadmore_dot"><span class="weui-loadmore__tips"><span class="no-more">没有更多了</span></span></div>'
        },
        loadDownFn : function(me){
            page++;
            var result = '';
            var list = data['list'+page];
            if(list){
                for(var i = 0; i < list.length; i++) {
                    result += '<li id='+list[i].id+'>' + '<div class="hot_pic">' + '<img src="' + list[i].pic +'" alt="">' + '</div>' +
                            '<div class="hot_price">' +
                            '<p>' + list[i].title + ' </p>' +
                            '<p>&yen;<span> '+ list[i].money +'</span></p>'+
                            '</div>'+'<div class="hot_btn"><a href="place_order.html">立即报修</a></div>'+
                            '</li>';
                          
                }
            }
            else{
                me.lock();
                me.noData();
            }
            // 为了测试，延迟0.1秒加载
            setTimeout(function() {
                // $('.hot_project ul').html('');
                $('.hot_project ul').prepend(result);
                me.resetload();
            }, 100);
        }
    });
// 选择城市
    var current_city = ''
    $('.city_current').click(function(){
        $('.city-wrap').show()
        $('.city-wrap').stop(true).animate({left:0},400,function(){

        })
    });
    $('.city-list>p').click(function(event){
        current_city = $(this).text();
        console.log(current_city)
        $('.choose_city .city_current').text(current_city);
        $('body,html').scrollTop(0);
        $('.city-wrap').stop(true).animate({left:'100%'},400,function(){
           $('.city-wrap').hide()
        })
    })
    $('.city-wrap .back').click(function(){
        $('body,html').scrollTop(0);
        $('.city-wrap').stop(true).animate({left:'100%'},400,function(){
           $('.city-wrap').hide()
        })
    })


})