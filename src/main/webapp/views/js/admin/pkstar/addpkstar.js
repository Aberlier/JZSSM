function addPkstar(loginId, token,role) {
    var userDemand = document.getElementsByName("userDemand")[0].value;
    var reqDoEmpId = document.getElementById("reqDoEmpId");
    var sid=reqDoEmpId.selectedIndex;
    $.ajax({
        url: "http://localhost:7512/JZSSM/pkstarController/insertPkstarByEmpID?loginId=" + loginId + "&token=" + token+"&role=" +role,
        type: "post",
        //data: $("#form").serialize(),
        data: JSON.stringify( {
            userDemand: userDemand,
            reqDoEmpId: reqDoEmpId[sid].value,
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
                alert("评星成功！");
                parent.location.href = "pkstarController/findAllPkstarData?loginId=" + loginId + "&token=" + token+"&role=" +role;
            } else {
                alert("评星失败，不可重复对职工进行评星");
            }
        }, error: function (result) {
            alert("网络连接失败！" + result.resultCode);
        }
    });
}