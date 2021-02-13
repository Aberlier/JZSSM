function addmsg(loginId, token,role) {
    $.ajax({
        url: "adminController/insertMsg?loginId=" + loginId + "&token=" + token+"&role=" +role,
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
                alert("新增用户成功！");
                parent.location.href = "adminController/findAllMsgData?loginId=" + loginId + "&token=" + token+"&role=" +role;
            } else {
                alert("新增用户失败！错误代码：" + result.message);
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.resultCode);
        }
    });
}