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
<div class="login-container">
    <form class="login-form" id="infoform">
        <div class="input-group">
            <center>基于SSM的家政服务管理平台</center>
        </div>
        <div class="input-group" >
            <input type="text" id="postcode" name = "postcode" class="input-field">
            <label for="postcode" class="input-label">
                <span class="label-title">邮编</span>
            </label>
        </div>
        <div class="input-group">
            <input type="text" id="address" name = "address" class="input-field">
            <label for="address" class="input-label">
                <span class="label-title">地址</span>
            </label>
        </div>
        <div class="input-group">
            <input type="text" id="companyname" name="companyname" class="input-field">
            <label for="companyname" class="input-label">
                <span class="label-title">单位</span>
            </label>
        </div>
        <div class="input-group">
            <input type="text" id="username" name="username" class="input-field">
            <label for="username" class="input-label">
                <span class="label-title">用户名</span>
            </label>
        </div> <div class="input-group">
            <input type="text" id="job" name="job" class="input-field">
            <label for="job" class="input-label">
                <span class="label-title">职称</span>
            </label>
        </div>
<div class="input-group">
            <input type="text" id="tel1" name="tel1" class="input-field">
            <label for="tel1" class="input-label">
                <span class="label-title">手机1</span>
            </label>
        </div>   <div class="input-group">
            <input type="text" id="tel2" name="tel2" class="input-field">
            <label for="tel2" class="input-label">
                <span class="label-title">手机2</span>
            </label>
        </div>
        <span id="msg" style="font-size:14px;color:red"></span><br />
        <button class="login-button" id="info_button">添加<i class="ai ai-enter"></i></button>
    </form>
</div>
</body>
<script src="<%=basePath%>views/assets/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>views/assets/layui.js"></script>
<script src="<%=basePath%>views/js/info.js" data-main="info"></script>
</html>