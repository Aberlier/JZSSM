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

        <div class="layui-form-item">
            <label class="layui-form-label">评星数量</label>
            <div class="layui-input-block">
                <div class="layui-input-inline">
                    <select name="userDemand" lay-filter="aihao">
                        <option value="">请选择星数</option>
                        <option value="1">1星</option>
                        <option value="2" >2星</option>
                        <option value="3">3星</option>
                        <option value="4">4星</option>
                        <option value="5" selected="">5星</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">选择职工人员</label>
            <div class="layui-input-block">
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
            </div>
        </div>

    </form>
</div>
<div class=" tkbtnfxd">
    <button type="button" class="layui-btn  layui-btn-normal float-right" onclick="addPkstar('<%=loginId%>','<%=param%>','<%=role%>')">确定</button>
    <button type="button" class="layui-btn layui-btn-primary float-right">取消</button>
</div>
<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script src="<%=basePath%>views/js/admin/pkstar/addpkstar.js"></script>
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





