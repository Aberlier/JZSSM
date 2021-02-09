
//加载完成
// $(function(){
//     getUserList(1,10,urll);//获取用户列表
// });



//自己封装获取数据方法s
function getUserList(crr,lmt,urll){
    //获取人才列表
    $.ajax({
        url: urll,
        type: "post",
        data:{
            "pageNo":1,
            "pageSize":10
        },
        dataType: "json",
        cache: false,
        xhrFields: {
            withCredentials: true
        },
        success:function(res){
            if(res.code==200){
                console.log(res);
                count=res.data.totalElements;//总记录
                curr=res.data.number; //当前页
                limit=res.data.size; //每页几个
                var rclist=res.data.content;
                var html='';
                var len=rclist.length;

                for (var i=0; i<len; i++){
                    var htmlbuf='<tr>'+
                        '<td style="text-align:center">'+rclist[i].name+'</td>'+
                        '<td style="text-align:center">'+rclist[i].edu+'</td>'+
                        '<td style="text-align:center">'+rclist[i].skill+'</td>'+
                        '<td style="text-align:center">'+rclist[i].exp+'</td>'+
                        '<td style="text-align:center">'+rclist[i].add+'</td>'+
                        '<td style="text-align:center">'+rclist[i].tel+'</td>'+
                        '</tr>';
                    html=html+htmlbuf;
                }

                $("#rcktb").html(html);
                //调用分页方法
                getPageList(count,curr,limit,searchKey);

            }else {
                layer.alert(res.message);
            }
        },
        error:function(){
            layer.msg("网络故障");
        }
    })
}


//自己封装分页方法
function getPageList(count,curr,limit,searchKey){
    //分页方法
    layui.use(['laypage', 'layer'], function(){
        var laypage = layui.laypage
            ,layer = layui.layer;
        //完整功能
        laypage.render({
            elem: 'page',
            count: count||0,
            theme: '#009587',
            limit : limit||3,
            limits:[5, 10, 20, 30, 40],
            curr : curr||1,
            layout: ['count', 'prev', 'page', 'next',  'refresh', 'skip'],
            jump: function(obj,first){
                //debugger;
                if(!first){
                    //window.location.href = "?curr="+obj.curr+"&pageSize="+obj.limit+"&enterId="+'${enterId}';
                    getPeopleList (obj.curr,obj.limit,searchKey);
                }
            }
        });
    });
}