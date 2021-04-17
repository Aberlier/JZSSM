function updatemsg(loginId, token,role) {
    $.ajax({
        url: "http://localhost:7512/JZSSM/msgController/updateMsg?loginId=" + loginId + "&token=" + token+"&role=" +role,
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
                alert("修改留言成功！");
                parent.location.href = "msgController/findAllMsgData?loginId=" + loginId + "&token=" + token+"&role=" +role;
                location.reload();
            } else {
                alert("修改留言失败！");
            }
        }, error: function (result) {
            alert("网络连接失败！" );
        }
    });
}