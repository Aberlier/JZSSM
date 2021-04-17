function addWork(loginId, token, role) {
    var workId = document.getElementsByName("workType")[0].value;
    var workContent = document.getElementsByName("workContent")[0].value;
    $.ajax({
        url: "http://localhost:7512/JZSSM/workController/insertWork?loginId=" + loginId + "&token=" + token + "&role=" + role,
        type: "post",
        data: JSON.stringify({
            workId: workId,
            workContent: workContent
        }),
        dataType: "json",
        cache: false,
        contentType: 'application/json;charset=UTF-8',
        xhrFields: {
            withCredentials: true
        },
        beforeSend: function () {
        },
        complete: function () {
        },
        success: function (result) {
            if (result.code == 200) {
                alert("添加职位成功！");
                parent.location.href = "workController/findAllWorkData?loginId=" + loginId + "&token=" + token + "&role=" + role;
            } else {
                alert("添加职位失败！");
            }
        }, error: function (result) {
            alert("网络连接失败！");
        }
    });
}