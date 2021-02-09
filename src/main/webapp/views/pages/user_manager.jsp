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
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户管理</title>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/view.css"/>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/admin.css"/>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/style.css"/>
    <style type="text/css">
        .layui-form-item {
            margin-bottom: 0;
        }
    </style>
</head>
<body class="layui-view-body">
<div class="layui-content">
    <!--面包屑导航-->
    <div class="mianb">
        <div class="mblf layui-col-xs6 layui-col-md6">
            <i class="layui-icon">&#xe656;</i>
            <p>用户管理 > <span>用户列表</span></p>
        </div>
        <div class="mbrt layui-col-xs6 layui-col-md6">
            <a href="javascript:;" class="layui-btn layui-btn-normal" id="fabu">添加用户需求</a>
        </div>
    </div>
    <!--面包屑导航-->
    <div class="layui-row">
        <div class="layui-card">

            <div class="sortbox layui-form">

                <div class="layui-form-item">

                    <label class="layui-form-label">按需求筛选</label>
                    <div class="layui-input-inline">
                        <select name="interest" lay-filter="aihao">
                            <option value=""></option>
                            <option value="保安">保安</option>
                            <option value="1" selected="">保洁</option>
                            <option value="2">保镖</option>
                            <option value="3">护工</option>
                            <option value="4">月嫂</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-table-cell laytable-cell-1-2-3">
                <%--                <a class="layui-btn layui-btn-danger layui-btn-xs delete" οnclick='deleteAll (\"" +  <%=loginId%> + "\",\"" +  <%=param%> + "\")'>批量删除</a>--%>
                <a class="layui-btn layui-btn-danger layui-btn-xs delete"
                   onclick="deleteAll('<%=loginId%>','<%=param%>')">批量删除</a>
            </div>
            <div class="table-responsive">

                <table class="layui-table" lay-skin="line" lay-size="lg" id="table">
                    <thead>
                    <tr>
                        <th class="layui-input-block">
                            <input type="checkbox" name="" lay-skin="primary" title="" onclick="checkAll(this)">
                        </th>
                        <th>编号</th>
                        <th>用户姓名</th>
                        <th>用户手机</th>
                        <th>用户需求</th>
                        <th>是否加急</th>
                        <th>用户地址</th>
                        <th>用户派遣地址</th>
                        <th>角色</th>
                        <th>其他描述</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userlist}" var="user">
                        <form class="layui-form" action="">
                            <tr>
                                <td class="layui-input-block">
                                    <input type="checkbox" name="arrays" lay-skin="primary" title=""
                                           value="${user.user_id}">
                                </td>
                                <td>${user.user_id}</td>
                                <td>${user.user_name}</td>
                                <td>${user.user_telnum}</td>

                                <td><c:if test="${user.user_demand==1}">
                                    <option value="1">保安</option>
                                </c:if>
                                    <c:if test="${user.user_demand==2}">
                                        <option value="2">保洁</option>
                                    </c:if>
                                    <c:if test="${user.user_demand==3}">
                                        <option value="3">保镖</option>
                                    </c:if>
                                    <c:if test="${user.user_demand==4}">
                                        <option value="4">护工</option>
                                    </c:if>
                                    <c:if test="${user.user_demand==5}">
                                        <option value="5">月嫂</option>
                                    </c:if></td>
                                    <%-- <td class="layui-form">
                                         <input id = "switch" type="checkbox" name="switch" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
                                     </td>--%>

                                <c:if test="${user.user_urgent == 1 }">
                                    <td class="layui-form">
                                        <input type="checkbox" name="switch" lay-skin="switch" lay-filter="switchTest"
                                               lay-text="ON|OFF">
                                    </td>
                                </c:if>
                                <c:if test="${user.user_urgent == 2 }">
                                    <td class="layui-form">
                                        <input type="checkbox" name="switch" lay-skin="switch" lay-filter="switchTest"
                                               lay-text="ON|OFF">
                                    </td>
                                </c:if>
                                <td>${user.user_address}</td>
                                <td>${user.user_dispatch_address}</td>
                                <c:if test="${user.user_role == 3 }">
                                    <td>平台用户</td>
                                </c:if><c:if test="${user.user_role == 2 }">
                                <td>从业职工</td>
                            </c:if><c:if test="${user.user_role == 1 }">
                                <td>管理员</td>
                            </c:if>

                                <td>${user.user_other_desc}</td>
                                    <%--  <td><a class="layui-btn layui-btn-normal layui-btn-xs">置顶</a></td>--%>
                                <td>
                                    <div class="layui-table-cell laytable-cell-1-0-10">
                                        <a href="<%=basePath%>/views/pages/userDetail.jsp"
                                           class="layui-btn layui-btn-xs">查看</a>
                                        <a class="layui-btn layui-btn-normal layui-btn-xs"
                                           onclick="updateUser('${user.user_id}','<%=loginId%>','<%=param%>')">修改</a>
                                        <a class="layui-btn layui-btn-danger layui-btn-xs deleteOne"
                                           onclick="deleteOne(${user.user_id},'<%=loginId%>','<%=param%>')">删除</a>
                                    </div>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>

                    <%--
                                        <tr>
                                            <td class="layui-form">
                                                <input type="checkbox" name="" lay-skin="primary" title="">
                                            </td>
                                            <td>人事专员</td>
                                            <td>河南卓聘企业信息咨询有限公司</td>
                                            <td>5</td>
                                            <td>2000</td>
                                            <td>2019-11-29</td>
                                            <td class="layui-form">
                                                <input type="checkbox" name="close" lay-skin="switch" lay-filter="switchTest">
                                            </td>
                                            <td><a class="layui-btn layui-btn-primary layui-btn-xs">取消置顶</a></td>
                                            <td>
                                                <div class="layui-table-cell laytable-cell-1-0-10">
                                                    <a href="07职位管理-详情.html" class="layui-btn  layui-btn-xs">查看</a>
                                                    <a class="layui-btn layui-btn-normal layui-btn-xs">修改</a>
                                                    <a class="layui-btn layui-btn-danger layui-btn-xs delete">删除</a>
                                                </div>
                                            </td>
                                        </tr>--%>
                    </tbody>
                </table>
            </div>


            <!--分页-->
            <div id="page"></div>
            <!--分页-->
        </div>
    </div>
</div>
<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script src="<%=basePath%>views/js/usermanager.js"></script>
</body>
</html>