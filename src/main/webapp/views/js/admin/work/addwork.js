function addWork(loginId, token,role) {
    $.ajax({
        url: "workController/insertWork?loginId=" + loginId + "&token=" + token+ "&role=" + role,
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
                parent.location.href = "workController/findAllWorkData?loginId=" + loginId + "&token=" + token+ "&role=" + role;
            } else {
                alert("新增留言失败！错误代码：" + result.message);
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.resultCode);
        }
    });
}