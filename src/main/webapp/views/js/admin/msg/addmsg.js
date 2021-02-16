function addMsg(loginId, token,role) {
    $.ajax({
        url: "msgController/insertMsg?loginId=" + loginId + "&token=" + token+"&role=" +role,
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
                alert("留言成功！");
                parent.location.href = "msgController/findAllMsgData?loginId=" + loginId + "&token=" + token+"&role=" +role;
            } else {
                alert("留言失败！错误代码：" + result.code);
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.code);
        }
    });
}