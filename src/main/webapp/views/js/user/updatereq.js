function updateReq(loginId,token,role) {
    $.ajax({
        url: "requireController/updateReq?loginId=" + loginId + "&token=" + token+"&role=" +role,
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
                alert("修改需求成功！");
                parent.location.href = "requireController/findAllReqByEmpIdData?loginId=" + loginId + "&token=" + token+"&role=" +role;
                location.reload();
            } else {
                alert("修改需求失败！错误代码：" + result.code);
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.code);
        }
    });
}