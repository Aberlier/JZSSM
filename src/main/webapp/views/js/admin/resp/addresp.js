function addMsgResp(loginId, token,role) {
    $.ajax({
        url: "respController/insertMsgResp?loginId=" + loginId + "&token=" + token+"&role=" +role,
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
                alert("回复成功！");
                parent.location.href = "respController/findAllMsgRespData?loginId=" + loginId + "&token=" + token+"&role=" +role;
            } else {
                alert("回复失败！错误代码：" + result.code);
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.code);
        }
    });
}