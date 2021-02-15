function updateEmp(loginId, token, role) {
    $.ajax({
        url: "empController/updateEmp?loginId=" + loginId + "&token=" + token+"&role=" +role,
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
                alert("修改成功！");
                parent.location.href = "empController/findAllEmpData?loginId=" + loginId + "&token=" + token+"&role=" +role;
                location.reload();
            } else {
                alert("修改失败！错误代码：" + result.message);
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.resultCode);
        }
    });
}