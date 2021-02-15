<%@ page import="com.jzssm.fhf.entity.DomainUser" %>
<%@ page import="com.jzssm.fhf.entity.DomainEmployer" %><%--
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
    DomainEmployer domainEmployer = (DomainEmployer) session.getAttribute("domainEmployer");
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
    <form class="layui-form" id="form" action="">
        <input type="text" hidden="true" name="employerId" value="<%=domainEmployer.getEmployerId()%>">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-block">
                <input type="text" name="employerName" value="<%=domainEmployer.getEmployerName()%>" lay-verify="title"
                       autocomplete="off"
                       placeholder=""
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄：</label>
            <div class="layui-input-block">
                <input type="text" name="employerAge" value="<%=domainEmployer.getEmployerAge()%>" lay-verify="title"
                       autocomplete="off"
                       placeholder=""
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>
            <div class="layui-input-block">
                <input type="password" name="employerPwd" value="<%=domainEmployer.getEmployerPwd()%>" lay-verify="title"
                       autocomplete="off"
                       placeholder="" class="layui-input">
                <%--   <span style="color: red">*初始密码：123456</span>--%>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号：</label>
            <div class="layui-input-block">
                <input type="text" name="employerTelnum" lay-verify="title" value="<%=domainEmployer.getEmployerTelnum()%>"
                       autocomplete="off"
                       placeholder=""
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址：</label>
            <div class="layui-input-block">
                <input type="text" name="employerAddress" lay-verify="title" value="<%=domainEmployer.getEmployerAddress()%>"
                       autocomplete="off"
                       placeholder=""
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">

                <% if (domainEmployer.getEmployerDesc() == null) { %>
                <textarea placeholder="请输入" class="layui-textarea"
                          name="employerDesc">
                         </textarea>
                <% } %> <% if (domainEmployer.getEmployerDesc() != null) { %>
                <textarea placeholder="请输入" class="layui-textarea"
                          name="employerDesc">
                          <%=domainEmployer.getEmployerDesc()%></textarea>
                <% } %>

            </div>
        </div>
    </form>
</div>
<div class=" tkbtnfxd">
    <button type="button" class="layui-btn  layui-btn-normal float-right"
            onclick="updateEmp('<%=loginId%>','<%=param%>','<%=role%>')">确定
    </button>
    <button type="button" class="layui-btn layui-btn-primary float-right">取消</button>
</div>
<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script src="<%=basePath%>views/js/emp/emp/updateemp.js"></script>
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





