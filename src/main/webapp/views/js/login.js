layui.define(['element'], function (exports) {
    var $ = layui.$;
    $('.input-field').on('change', function () {
        var $this = $(this),
            value = $.trim($this.val()),
            $parent = $this.parent();

        if (value !== '' && !$parent.hasClass('field-focus')) {
            $parent.addClass('field-focus');
        } else {
            $parent.removeClass('field-focus');
        }
    });
$('#regist_button').on('click',function(){
    window.document.location.href = "regist_page";
});
    $('#login-button').on('click', function () {
        var loginId;
        var token;
        myajax = $.ajax({
            url: "http://localhost:7512/JZSSM/login",
            type: "post",
            data: $("#form").serialize(),
            dataType: "json",
            cache: false,
            xhrFields: {
                withCredentials: true
            },
            beforeSend: function () {
            },
            complete: function () {
            },
            success: function (result) {
                if (result.code == 200) {
                    loginId = result.data.loginId;
                    token = result.data.token;
                    window.location.href = "home/index?loginId="+loginId+"&token="+token;

                } else {
                    alert("登陆失败请重新登录！错误代码："+result.message);
                }
            }, error: function (result) {
                alert("网络连接失败！" + result.resultCode);
            }
        });

        //myajax请求完毕时执行
       /* $.when(myajax).done(function () {
            $.ajax({
                url: "http://localhost:7512/JZSSM/home/index?loginId="+loginId,
                type: "get",
                cache: false,
                xhrFields: {
                    withCredentials: true
                },
                dataType:"html",
                headers:{
                    'token':token
                },
                success: function (result) {
                    window.location.href = "home/index?loginId="+loginId+"&token="+token;
                }
            })
        });
*/

    });

    exports('regist');

});