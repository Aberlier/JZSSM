function updateUser(loginId,token) {
    $.ajax({
        url: "adminController/updateUser?loginId=" + loginId + "&token=" + token,
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
                alert("修改用户成功！");
                parent.location.href = "adminController/findAllUserData?loginId=" + loginId + "&token=" + token;
                location.reload();
            } else {
                alert("修改用户失败！错误代码：" + result.message);
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.resultCode);
        }
    });
}