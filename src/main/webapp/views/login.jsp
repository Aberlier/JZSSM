<%--
  Created by IntelliJ IDEA.
  User: Angular
  Date: 2021/1/10
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/login.css">
    <link rel="icon" href="<%=basePath%>views/favicon.ico">
    <title>管理后台</title>
</head>
<body class="login-wrap">
<span name="errorMsg" id="errorMsg"></span>
<div class="login-container">
    <form class="login-form" id="form">
        <div class="input-group">
            <center>基于SSM的家政服务管理平台</center>
        </div>
        <div class="input-group" >
        <select id="rolename" name = "rolename" class="input-field"  class="input-field" style="border: 1px solid #29adeb">
            <option value="">请选择角色</option>
            <option value="1">管理人员</option>
            <option value="3">普通用户</option>
            <option value="2">从业人员</option>
        </select>
        </div>
        <div class="input-group">
            <input type="text" id="telnum" name = "telnum" class="input-field">
            <label for="telnum" class="input-label">
                <span class="label-title">手机号</span>
            </label>
        </div>
        <div class="input-group">
            <input type="password" id="password" name="password" class="input-field">
            <label for="password" class="input-label">
                <span class="label-title">密码</span>
            </label>
        </div>
        <span id="msg" style="font-size:14px;color:red"></span><br />
        <button type="submit" class="login-button" id="login-button">登录<i class="ai ai-enter"></i></button></br>
        <button type="button" class="login-button" id="regist_button">注册<i class="ai ai-enter"></i></button>
    </form>
</div>
</body>
<script src="<%=basePath%>views/assets/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>views/assets/layui.js"></script>
<script src="<%=basePath%>views/js/login.js" data-main="login"></script>
</html>