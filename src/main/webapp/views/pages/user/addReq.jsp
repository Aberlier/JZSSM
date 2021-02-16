<%--
  Created by IntelliJ IDEA.
  User: Angular
  Date: 2021/2/13
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<%
    String param = (String) session.getAttribute("token");
    String empName = (String) request.getParameter("empname");
    String id = (String) request.getParameter("id");
    Integer empstarnum = Integer.parseInt(request.getParameter("empstarnum").toString());
    Integer empType = Integer.parseInt(request.getParameter("empType").toString());
    Integer loginId = Integer.parseInt(session.getAttribute("loginId").toString());
    Integer role = Integer.parseInt(session.getAttribute("role").toString());
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/view.css"/>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/style.css"/>
</head>
<body class="layui-tank">
<div class="layui-card">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">需求类型</label>
            <div class="layui-input-block">
                <div class="layui-input-inline">
                    <select name="reqType" lay-filter="aihao">

                        <%if("".equals(empType) || empType==null){%>
                        <select name="reqType" lay-filter="aihao">
                            <option value="">请选择对应需求</option>
                            <option value="1">保安</option>
                            <option value="2">保洁</option>
                            <option value="3">保镖</option>
                            <option value="4">护工</option>
                            <option value="5">月嫂</option>
                        </select>
                        <%}%>

                        <%if (empType == 1) {%>
                        <option value="1">保安</option>
                        <%} else if (empType == 2) {%>
                        <option value="2">保洁</option>
                        <%} else if (empType == 3) {%>
                        <option value="3">保镖</option>
                        <%} else if (empType == 4) {%>
                        <option value="4">护工</option>
                        <%} else if (empType == 5) {%>
                        <option value="5">月嫂</option>
                        <%}%>

                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入" class="layui-textarea" name="reqContent" id="reqContent"></textarea>
            </div>
        </div>
    </form>
</div>
<div class=" tkbtnfxd">
    <button type="button" class="layui-btn  layui-btn-normal float-right"
            onclick="addReq('<%=id%>','<%=empName%>','<%=empstarnum%>','<%=loginId%>','<%=param%>','<%=role%>')">确定
    </button>
    <button type="button" class="layui-btn layui-btn-primary float-right">取消</button>
</div>

<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script>
    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;

        //设定文件大小限制
        upload.render({
            elem: '#test7'
            , url: '/upload/'
//		    ,size: 60 //限制文件大小，单位 KB
            , done: function (res) {
                console.log(res)
            }
        });
    });

    function addReq(id, empName, empstarnum, loginId, token, role) {
        // var reqContent = $("#reqContent").value;
        var reqContent = document.getElementsByName("reqContent")[0].value;
        var reqType = document.getElementsByName("reqType")[0].value;
        $.ajax({
            url: "requireController/insertReq?loginId=" + loginId + "&token=" + token + "&role=" + role,
            type: "post",
            data: {
                "reqContent": reqContent,
                "reqType": reqType,
                "id": id,
                "empName": empName,
                "empstarnum": empstarnum,
                "loginId": loginId
            },
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
                    alert("新增需求成功！");
                    parent.location.href = "empController/findAllEmpData?loginId=" + loginId + "&token=" + token + "&role=" + role;
                } else {
                    alert("新增需求失败！错误代码：" + result.message);
                }
            }, error: function (result) {
                alert("网络连接失败！" + result.resultCode);
            }
        });
    }

</script>

</body>
</html>