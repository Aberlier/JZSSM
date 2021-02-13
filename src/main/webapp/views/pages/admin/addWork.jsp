<%--
  Created by IntelliJ IDEA.
  User: Angular
  Date: 2021/1/10
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<%
    String param = (String) session.getAttribute("token");
    Integer loginId = Integer.parseInt(session.getAttribute("loginId").toString());
    Integer role = Integer.parseInt(session.getAttribute("role").toString());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/view.css"/>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/style.css"/>
</head>
<body class="layui-tank">
<div class="layui-card">
    <form class="layui-form" id= "form" action="">
        <input type="text" hidden="true" name="userRole" value="3">
        <div class="layui-form-item">
            <label class="layui-form-label">用户姓名</label>
            <div class="layui-input-block">
                <input type="text" name="userName" lay-verify="title" autocomplete="off" placeholder=""
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户密码</label>
            <div class="layui-input-block">
                <input type="password" name="userPwd" lay-verify="title" readonly="true" value="123456"
                       autocomplete="off"
                       placeholder="" class="layui-input">
                <span style="color: red">*初始密码：123456</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户手机号</label>
            <div class="layui-input-block">
                <input type="text" name="userTelnum" lay-verify="title" autocomplete="off" placeholder=""
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户需求</label>
            <div class="layui-input-block">
                <div class="layui-input-inline">
                    <select name="userDemand" lay-filter="aihao">
                        <option value="">请选择对应需求</option>
                        <option value="1">保安</option>
                        <option value="2" selected="">保洁</option>
                        <option value="3">保镖</option>
                        <option value="4">护工</option>
                        <option value="5">月嫂</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否加急</label>
            <div class="layui-input-block">
                <div class="layui-input-inline">
                    <select name="userUrgent">
                        <option value="1">是</option>
                        <option value="0">否</option>
<%--                        <option value="0" disabled="">否</option>--%>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户地址</label>
            <div class="layui-input-block">
                <input type="text" name="userAddress" lay-verify="title" autocomplete="off" placeholder=""
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">派遣地址</label>
            <div class="layui-input-block">
                <input type="text" name="userDispatchAddress" lay-verify="title" autocomplete="off" placeholder=""
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入" class="layui-textarea" name="userOtherDesc"></textarea>
            </div>
        </div>
    </form>
</div>
<div class=" tkbtnfxd">
    <button type="button" class="layui-btn  layui-btn-normal float-right" onclick="addWork('<%=loginId%>','<%=param%>','<%=role%>')">确定</button>
    <button type="button" class="layui-btn layui-btn-primary float-right">取消</button>
</div>
<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script src="<%=basePath%>views/js/admin/work/addwork.js"></script>
<script>
    layui.use('layedit', function () {
        var layedit = layui.layedit;
        layedit.build('demo'); //建立编辑器
    });
    layui.use('layedit', function () {
        var layedit = layui.layedit;
        layedit.build('demo2'); //建立编辑器
    });

</script>
</body>
</html>





