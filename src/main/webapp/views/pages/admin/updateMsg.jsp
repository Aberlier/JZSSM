<%@ page import="com.jzssm.fhf.entity.DomainUser" %>
<%@ page import="com.jzssm.fhf.entity.DomainMsg" %><%--
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
    DomainMsg domainMsg = (DomainMsg) session.getAttribute("domainMsg");
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
    <form class="layui-form" id="form" action="">
        <input type="text" hidden="true" name="msgId" value="<%=domainMsg.getMsgId()%>">
        <input type="text" hidden="true" name="userId" value="<%=loginId%>">
        <input type="text" hidden="true" name="userRole" value="<%=role%>">
        <div class="layui-form-item">
            <label class="layui-form-label">留言用户</label>
            <div class="layui-input-block">
                <input type="text" name="msgUserId" readonly = "true" value="<%=domainMsg.getUserId()%>" lay-verify="title"
                       autocomplete="off"
                       placeholder=""
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">留言标题</label>
            <div class="layui-input-block">
                <input type="text" name="msgName" value="<%=domainMsg.getMsgName()%>" lay-verify="title"
                       autocomplete="off"
                       placeholder=""
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">留言内容</label>
            <div class="layui-input-block">

                <% if (domainMsg.getMsgContent() == null) { %>
                <textarea placeholder="请输入" class="layui-textarea"
                          name="msgContent">
                         </textarea>
                <% } %> <% if (domainMsg.getMsgContent() != null) { %>
                <textarea placeholder="请输入" class="layui-textarea"
                          name="msgContent"><%=domainMsg.getMsgContent()%></textarea>
                <% } %>

            </div>
        </div>
    </form>
</div>
<div class=" tkbtnfxd">
    <button type="button" class="layui-btn  layui-btn-normal float-right"
            onclick="updatemsg('<%=loginId%>','<%=param%>','<%=role%>')">确定
    </button>
    <button type="button" class="layui-btn layui-btn-primary float-right">取消</button>
</div>
<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script src="<%=basePath%>views/js/admin/msg/updatemsg.js"></script>
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





