<%@ page import="com.jzssm.fhf.entity.DomainUser" %>
<%@ page import="com.jzssm.fhf.entity.DomainRequireUser" %><%--
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
    DomainRequireUser domainRequireUser = (DomainRequireUser) session.getAttribute("domainRequireUser");
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
        <input type="text" hidden="true" name="reqId" value="<%=domainRequireUser.getReqId()%>">

        <div class="layui-form-item">
            <label class="layui-form-label">用户需求</label>
            <div class="layui-input-block">
                <div class="layui-input-inline">
                    <select name="reqType" lay-filter="aihao">
                        <% if (domainRequireUser.getReqType() != null && Integer.parseInt(domainRequireUser.getReqType()) > 0 && Integer.parseInt(domainRequireUser.getReqType()) == 1) { %>
                        <option value="1" selected>保安</option>
                        <option value="2">保洁</option>
                        <option value="3">保镖</option>
                        <option value="4">护工</option>
                        <option value="5">月嫂</option>
                        <% } %> <% if (domainRequireUser.getReqType() != null && Integer.parseInt(domainRequireUser.getReqType()) > 0 && Integer.parseInt(domainRequireUser.getReqType()) == 2) { %>
                        <option value="1" >保安</option>
                        <option value="2" selected>保洁</option>
                        <option value="3">保镖</option>
                        <option value="4">护工</option>
                        <option value="5">月嫂</option>
                        <% } %> <% if (domainRequireUser.getReqType() != null && Integer.parseInt(domainRequireUser.getReqType()) > 0 && Integer.parseInt(domainRequireUser.getReqType()) == 3) { %>
                        <option value="1" >保安</option>
                        <option value="2">保洁</option>
                        <option value="3" selected>保镖</option>
                        <option value="4">护工</option>
                        <option value="5">月嫂</option>
                        <% } %> <% if (domainRequireUser.getReqType() != null && Integer.parseInt(domainRequireUser.getReqType()) > 0 && Integer.parseInt(domainRequireUser.getReqType()) == 4) { %>
                        <option value="1" >保安</option>
                        <option value="2">保洁</option>
                        <option value="3">保镖</option>
                        <option value="4" selected>护工</option>
                        <option value="5">月嫂</option>
                        <% } %> <% if (domainRequireUser.getReqType() != null && Integer.parseInt(domainRequireUser.getReqType()) > 0 && Integer.parseInt(domainRequireUser.getReqType()) == 5) { %>
                        <option value="1" >保安</option>
                        <option value="2">保洁</option>
                        <option value="3">保镖</option>
                        <option value="4">护工</option>
                        <option value="5" selected>月嫂</option>
                        <% } %>

                    </select>
                </div>
            </div>
        </div>



        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">

                <% if (domainRequireUser.getReqDesc() == null) { %>
                <textarea placeholder="请输入" class="layui-textarea"
                          name="reqDesc">
                         </textarea>
                <% } %> <% if (domainRequireUser.getReqDesc() != null) { %>
                <textarea placeholder="请输入" class="layui-textarea"
                          name="reqDesc">
                          <%=domainRequireUser.getReqDesc()%></textarea>
                <% } %>

            </div>
        </div>
    </form>
</div>
<div class=" tkbtnfxd">
    <button type="button" class="layui-btn  layui-btn-normal float-right"
            onclick="updateReq('<%=loginId%>','<%=param%>','<%=role%>')">确定
    </button>
    <button type="button" class="layui-btn layui-btn-primary float-right">取消</button>
</div>
<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script src="<%=basePath%>views/js/user/updatereq.js"></script>
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





