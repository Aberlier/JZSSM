function addmsg(loginId, token) {
    $.ajax({
        url: "adminController/insertMsg?loginId=" + loginId + "&token=" + token,
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
                alert("新增留言成功！");
                parent.location.href = "adminController/findAllMsgData?loginId=" + loginId + "&token=" + token;
            } else {
                alert("新增留言失败！错误代码：" + result.message);
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.resultCode);
        }
    });
}