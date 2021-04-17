<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Angular
  Date: 2021/4/16
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>
<%
    String param = (String) session.getAttribute("token");
    List<Map<String,Object>> listEmp = (List<Map<String, Object>>) session.getAttribute("listEmp");
    Integer loginId = Integer.parseInt(session.getAttribute("loginId").toString());
    Integer role = Integer.parseInt(session.getAttribute("role").toString());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>发布职位1</title>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/view.css"/>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/admin.css"/>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/style.css"/>
</head>
<body class="layui-view-body">
${msg}
<div class="layui-content">
    <!--面包屑导航-->
    <div class="mianb">
        <div class="mblf layui-col-xs6 layui-col-md6">
            <i class="layui-icon">&#xe656;</i>
            <p>需求列表 > <span>添加需求</span></p>
        </div>
    </div>

    <div class="layui-row">
        <div class="layui-card">

            <div class="sortbox layui-form">

            </div>
            <form class="layui-form" action="">


                <%--  <td>${emp.employerId}</td>
                  <td>${emp.employerName}</td>
                  <td>${emp.employerTelnum}</td>
                  <td>${emp.employerAge}</td>
                  <td>${emp.employerAddress}</td>
  --%> <%--护工类型--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">选择工种</label>
                    <div class="layui-input-block">
                        <select name="reqType" lay-filter="aihao">

                            <option value="1" selected>保安</option>
                            <option value="2">保洁</option>
                            <option value="3">保镖</option>
                            <option value="4">护工</option>
                            <option value="5">月嫂</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">选择人员</label>
                    <div class="layui-input-inline">
                        <select name="reqDoEmpId" id="reqDoEmpId" >
                            <c:forEach items="${listEmp}" var="emp">

                                <%--                                <a href="requireController/queryEmpFields?employerId=${emp.employerId}&loginId=<%=loginId%>&token=<%=param%>&role=<%=role%>"><option value="${emp.employerId}">${emp.employerName} </option></a>--%>
                                <option value="${emp.employerId}">${emp.employerName}
                                    <c:if test="${emp.employerField==1}">

                                        (保安)

                                    </c:if>
                                    <c:if test="${emp.employerField==2}">

                                        (保洁)

                                    </c:if>
                                    <c:if test="${emp.employerField==3}">

                                        (保镖)

                                    </c:if>
                                    <c:if test="${emp.employerField==4}">
                                        (护工)

                                    </c:if>
                                    <c:if test="${emp.employerField==5}">

                                        (月嫂)

                                    </c:if>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <%--<div class="layui-input-inline">
                        <select name="reqDoEmpId">
                            <c:forEach items="${listmap}" var="emp">
                                <c:if test="${emp.employerField==1}">

                                        <option value="${emp.employerId}">保安</option>

                                </c:if>
                                <c:if test="${emp.employerField==2}">

                                        <option value="${emp.employerId}">保洁</option>

                                </c:if>
                                <c:if test="${emp.employerField==3}">

                                        <option value="${emp.employerId}">保镖</option>

                                </c:if>
                                <c:if test="${emp.employerField==4}">

                                        <option value="${emp.employerId}">护工</option>

                                </c:if>
                                <c:if test="${emp.employerField==5}">

                                        <option value="${emp.employerId}">月嫂</option>

                                </c:if>
                            </c:forEach>
                        </select>
                    </div>--%>
              <%--      <div class="layui-input-inline">
                        <select name="reqDoEmpPostname">
                            <c:forEach items="${listmap}" var="req">
                                <c:if test="${req.pkStarNum==2}">
                                    <option value="2">荣获2星专业人员</option>
                                </c:if><c:if test="${req.pkStarNum==3}">
                                <option value="3">荣获3星专业人员</option>
                            </c:if><c:if test="${req.pkStarNum==4}">
                                <option value="4">荣获4星专业人员</option>
                            </c:if><c:if test="${req.pkStarNum==5}">
                                <option value="5">荣获5星专业人员</option>
                            </c:if>
                            </c:forEach>
                        </select>
                    </div>--%>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">需求描述</label>
                    <div class="layui-input-block">
                        <textarea class="layui-textarea" name="reqContent" id="reqContent"></textarea>
                    </div>
                </div>
                <%--需求创建时间--%>
                <%--需求审核时间--%>
                <%--审核人角色--%>
                <%--审核人ID--%>
                <%--职工星数--%>
            </form>
            <%--<div class=" tkbtnfxd">
                <button type="button" class="layui-btn  layui-btn-normal float-right"
                        onclick="addReq('<%=loginId%>','<%=param%>','<%=role%>')">
                    确定
                </button>
                <button type="button" class="layui-btn layui-btn-primary float-right">取消</button>
            </div>--%>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <a href="javascript:;" class="layui-btn layui-btn-primary">清空重置</a>
                    <button type="button" class="layui-btn  layui-btn-normal float-right"
                            onclick="addReq('<%=loginId%>','<%=param%>','<%=role%>')">确定
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script>
    layui.use('layedit', function () {
        var layedit = layui.layedit;
        layedit.build('demo'); //建立编辑器
    });
    layui.use('layedit', function () {
        var layedit = layui.layedit;
        layedit.build('demo2'); //建立编辑器
    });

    function cge(){
        var sel=document.getElementById('reqDoEmpId');
        var sid=sel.selectedIndex;
        alert('value值:'+sel[sid].value+',option值:'+sel[sid].innerHTML);
    }

    function addReq(loginId, token, role) {
        // var reqContent = $("#reqContent").value;
        var reqContent = document.getElementsByName("reqContent")[0].value;
        var reqType = document.getElementsByName("reqType")[0].value;
        // var reqDoEmpName = document.getElementsByName("reqDoEmpName")[0].value;
        var reqDoEmpId = document.getElementById("reqDoEmpId");
        var sid=reqDoEmpId.selectedIndex;
        // var reqDoEmpPostname = document.getElementsByName("reqDoEmpPostname")[0].value;
        var reqUserId = loginId;
        $.ajax({
            url: "http://localhost:7512/JZSSM/requireController/insertRequire?loginId=" + loginId + "&token=" + token + "&role=" + role,
            type: "post",
            data: JSON.stringify( {
                reqType: reqType,
                reqDesc: reqContent,
                reqDoEmpId: reqDoEmpId[sid].value,
                reqUserId: reqUserId
            }),
            dataType: "json",
            cache: false,
            contentType: 'application/json;charset=UTF-8',
            xhrFields: {
                withCredentials: true
            },
            beforeSend: function () {
            },
            success: function (result) {
                if (result.code == 200) {
                    alert("新增需求成功！");
                    window.location.reload();
                } else {
                    alert("新增需求失败！错误代码：" + result.message);
                }
            }, error: function (result) {
                alert("网络连接失败！" + result.message);
            }
        });
    }
</script>
>
</body>
</html>
