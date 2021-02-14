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
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>职工管理</title>
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
            <p>需求列表 > <span>我的需求</span></p>
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
                   onclick="deleteAll('<%=loginId%>','<%=param%>','<%=role%>')">批量删除</a>
            </div>
            <div class="table-responsive">

                <table class="layui-table" lay-skin="line" lay-size="lg" id="table">
                    <thead>
                    <tr>
                        <th class="layui-input-block">
                            <input type="checkbox" name="" lay-skin="primary" title="" onclick="checkAll(this)">
                        </th>
                        <th>需求编号</th>
                        <th>用户编号</th>
                        <th>用户姓名</th>
                        <th>需求类型</th>
                        <th>需求详情</th>
                        <th>需求创建时间</th>
                        <th>审核人</th>
                        <th>审核角色</th>
                        <th>职工姓名</th>
                        <th>职工编号</th>
                        <th>职工等级</th>

                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${reqList}" var="req">
                        <form class="layui-form" action="">
                            <tr>
                                <td class="layui-input-block">
                                    <input type="checkbox" name="arrays" lay-skin="primary" title=""
                                           value="${req.reqId}">
                                </td>
                                <td>${req.reqId}</td>
                                <td>${req.reqUserId}</td>
                                <td>${req.reqUserName}</td>
                                <td><c:if test="${req.reqType==1}">
                                    <option value="1">保安</option>
                                </c:if>
                                    <c:if test="${req.reqType==2}">
                                        <option value="2">保洁</option>
                                    </c:if>
                                    <c:if test="${req.reqType==3}">
                                        <option value="3">保镖</option>
                                    </c:if>
                                    <c:if test="${req.reqType==4}">
                                        <option value="4">护工</option>
                                    </c:if>
                                    <c:if test="${req.reqType==5}">
                                        <option value="5">月嫂</option>
                                    </c:if></td>
                                <td>${req.reqDesc}</td>
                                <td>${req.reqTime}</td>
                                <td>
                                    <c:if test="${req.reqCheckName == null }">
                                        暂未审核
                                    </c:if><c:if test="${req.reqCheckName != null }">
                                    ${req.reqCheckName}
                                </c:if>
                                </td>
                                <td>
                                    <c:if test="${req.reqCheckRole == null }">
                                        暂未审核
                                    </c:if>
                                    <c:if test="${req.reqCheckRole == 1 }">
                                        管理员
                                    </c:if><c:if test="${req.reqCheckRole == 2 }">
                                    职工
                                </c:if>
                                </td>
                                <td>${req.reqDoEmpName}</td>
                                <td>${req.reqDoEmpId}</td>
                                <td>
                                    <c:if test="${req.reqDoEmpPostname==2}">
                                        <option value="2">荣获2星专业人员</option>
                                    </c:if><c:if test="${req.reqDoEmpPostname==3}">
                                    <option value="3">荣获3星专业人员</option>
                                </c:if><c:if test="${req.reqDoEmpPostname==4}">
                                    <option value="4">荣获4星专业人员</option>
                                </c:if><c:if test="${req.reqDoEmpPostname==5}">
                                    <option value="5">荣获5星专业人员</option>
                                </c:if>
                                </td>


                                <td>
                                    <div class="layui-table-cell laytable-cell-1-0-10">
                                        <a class="layui-btn layui-btn-normal layui-btn-xs"
                                           onclick="updateReq('${req.reqId}','<%=loginId%>','<%=param%>','<%=role%>')">编辑</a>
                                        <a class="layui-btn layui-btn-danger layui-btn-xs deleteOne"
                                           onclick="deleteOne(${emp.employerId},'<%=loginId%>','<%=param%>','<%=role%>')">删除</a>
                                    </div>
                                </td>
                            </tr>
                            <input type="hidden" name="startPage" id="startPage" value="${startPage}"/>
                            <input type="hidden" name="currentPage" id="currentPage" value="${currentPage }"/>
                            <input type="hidden" name="pageSize" id="pageSize" value="${pageSize}"/>
                            <input type="hidden" name="sumPageNumber" id="sumPageNumber" value="${sumPageNumber}"/>
                            <input type="hidden" name="countNumber" value="${countNumber}" id="countNumber"/>
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

                <!--分页-->
                <%--<div id="page"></div>--%>
                <div style="margin-top:10px;">
                    共${countNumber}条数据&nbsp&nbsp|&nbsp&nbsp共${sumPageNumber}页&nbsp&nbsp|&nbsp&nbsp当前第<span
                        value="">${currentPage}</span>页&nbsp&nbsp
                    <a onclick="toPrePage()">上一页</a> &nbsp&nbsp&nbsp<a onclick="toNextPage()">下一页</a>
                    <input type="text" id="pageNumber" style="width:50px"/>
                    <button onclick="toLocationPage()">go</button>
                    <div id="pageInfo"></div>
                </div>
                <!--分页-->
            </div>


        </div>
    </div>
</div>
<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script src="<%=basePath%>views/js/user/reqmanager.js"></script>
<script src="<%=basePath%>views/js/pageJs.js"></script>
</body>
</html>