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
              //   window.parent.location.href = "http://localhost:7512/JZSSM/msgController/findAllMsg?loginId=" + loginId + "&token=" + token+"&role=" +role;
                window.location.reload();
            } else {
                alert("留言失败！错误代码：" + result.code);
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.code);
        }
    });
}