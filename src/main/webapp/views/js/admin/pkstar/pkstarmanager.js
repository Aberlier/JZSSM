layui.use(['laypage', 'layer','form'], function () {
    var limit = 10;
    var loginId;
    var token;
    var role;
    var total;
    var page = 1;
    var element = layui.element;
    var laypage = layui.laypage;
    var form = layui.form,
        layer = layui.layer;

    // $("#switch").on('click', function(data){
    form.on('switch(switchTest)', function(data){
        if(this.checked){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅 仅是ON|OFF', data.othis)
        }else{
            layer.msg('开关： 关掉了', {
                offset: '6px'
            });
        }
        //do some ajax opeartiopns;
    });
    $("#page").empty()
    //页码完整功能
    laypage.render({
        elem: 'page'
        , count: total
        , layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
        , jump: function (obj) {
            console.log(obj)
        }
    });
});



/*
form.on('switch(switchTest)', function(data){
    if(this.checked){
        layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
            offset: '6px'
        });
        layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅 仅是ON|OFF', data.othis)
    }else{
        layer.msg('开关： 关掉了', {
            offset: '6px'
        });
    }
    //do some ajax opeartiopns;
});
*/


//弹框
$('#fabu').on('click', function () {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.open({
            type: 2,
            title: '添加用户',
            fix: false,
            shadeClose: true,
            shade: 0.8,
            area: ['660px', '420px'],
            content: 'views/pages/admin/addpkstar.jsp',
            end: function () {
                location.reload();
            }
        });
    });
})

//删除单条信息
function deleteOne(id,loginId,token,role) {
    layer.confirm('确定要删除该用户信息？', {
        btn: ['是', '否'] //按钮
    }, function () {
        $.ajax({
            type:'post',
            url:"pkstarController/deletePkstar?loginId="+loginId+"&token="+token+"&id="+id+"&role=" +role,
            data:id,//数据为id数组
            traditional:true,
            success:function(data){
                //成功后刷新界面
                alert("删除成功！");
                location.reload();
            }
        });
    }, function () {
        layer.msg('已取消', {icon: 2});
    });
}
//修改信息
function updatePkstar(id,loginId,token,role) {
    layer.alert('确定要修改用户信息？', function () {
        $.ajax({
            type:'get',
            url:'pkstarController/updatePkstarBefore?id='+id+"&loginId="+loginId+"&token="+token+"&role=" +role,
          /*  data:id,//数据为id数组*/
            traditional:true,
            success:function(result) {
                if (result.code == 200) {
                    var domainUser = result.data.model.domainUser
                    var layer = layui.layer;
                    layer.open({
                        type: 2,
                        title: '修改用户',
                        fix: false,
                        shadeClose: true,
                        shade: 0.8,
                        area: ['660px', '420px'],
                        content: result.data.viewName,
                        end: function () {
                            location.reload();
                        }
                    });
                    /* //成功后刷新界面
                     location.reload();*/
                }else {
                    alert("修改失败！错误代码："+result.message,{icon: 2});
                }
            }
        });
    });
}
//获取所有要删除的数据
function checkAll(obj) {
    var isCheck = obj.checked;
    var checkList = document.getElementsByName("arrays");//获取所有check选项
    for (var i = 0; i < checkList.length; i++) {
        checkList[i].checked = isCheck;
    }
}
//判断弹框

function deleteAll (loginId,token,role) {
    var loginId = loginId;
    var token = token;
    var myArray=new Array();
    var len=0;
    var arrays=document.getElementsByName("arrays");//获取所有check
    if(arrays[0].checked){
        layer.confirm('确定要删除该用户信息？', {
            btn: ['是', '否'] //按钮
        }, function () {
            if ($('#table tbody tr').length === 1) {
                layer.msg('只有一条不允许删除。', {
                    time : 2000
                });
            } else {
                for(var i=0;i<arrays.length;i++){
                    if(arrays[i].checked){
                        myArray[len++]=arrays[i].value;
                    }
                }
                $.ajax({
                    url: "pkstarController/deletePkstar?loginId="+loginId+"&token="+token+"&role=" +role,
                    type: "post",
                    data:{"arrays":myArray},//数据为id数组
                    dataType: "json",
                    cache: false,
                    traditional:true,
                    xhrFields: {
                        withCredentials: true
                    },
                    beforeSend: function () {
                    },
                    complete: function () {
                    },
                    success: function (result) {
                        if (result.code == 200) {
                            layer.msg('已删除', {icon: 1});s
                        } else {
                            layer("删除失败！错误代码："+result.message,{icon: 2});
                        }
                    }, error: function (result) {
                        alert("网络连接失败！" + result.resultCode);
                    }
                });
            }

        }, function () {
            layer.msg('已取消', {icon: 2});
        });
    }else {
        layer.msg("请选择要删除的信息!",{icon: 2});
    }

}

layui.use('form', function () {
    var form = layui.form;
    form.render();
});