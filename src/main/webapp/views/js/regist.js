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
  /*  var data = {
        role: $('#roleName'),
        telnum: $('#telnum'),
        username: $('#username'),
        age: $('#age'),
        password: $('#password'),

    }
*/

        $('#regist_button').on('click', function () {

          /*  var roleName = data.field.roleName;
            var telnum = data.field.telnum;
            var username = data.field.username;
            var age = data.field.age;
            var password = data.field.password;*/


            $.ajax({
                url: "http://localhost:7512/JZSSM/regist",
                type: "post",
                /*data: JSON.stringify(data),*/
                data:$("#registform").serialize(),
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
                        layer.msg('注册成功', {icon: 1});
                        window.location.href = "http://localhost:7512/JZSSM/login_page";

                    } else if(result.code == 400){
                        layer.msg('注册失败', {icon: 1});
                    }else{
                        alert("注册失败，请重新注册！");
                    }
                }, error: function (result) {
                    alert("请求连接失败！" );
                }
            });

    });
    exports('regist');

});