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
	String param = (String)session.getAttribute("token");
	Integer loginId = Integer.parseInt(session.getAttribute("loginId").toString());
	Integer role = Integer.parseInt(session.getAttribute("role").toString());
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户信息管理</title>
	<link rel="stylesheet" href="<%=basePath%>views/assets/css/layui.css">
	<link rel="stylesheet" href="<%=basePath%>views/assets/css/view.css"/>
	<link rel="stylesheet" href="<%=basePath%>views/assets/css/admin.css"/>
	<link rel="stylesheet" href="<%=basePath%>views/assets/css/style.css"/>
	<style type="text/css">
		.layui-elem-quote{ font-size: 18px; margin-bottom: 20px;}
		.layui-input-block img{ max-height: 160px; width: auto;}
	</style>
</head>
<body class="layui-view-body">
<div class="layui-content">
	<!--面包屑导航-->
	<div class="mianb">
		<%if(role ==1){%>
		<div class="mblf layui-col-xs6 layui-col-md6">
			<i class="layui-icon">&#xe656;</i>
			<p>用户管理> <a href="<%=basePath%>userController/findAllUserData?loginId=<%=loginId%>&token=<%=param%>&role=<%=role%>">用户列表</a> ><span>用户详情</span></p>
		</div>
		<%}else if(role==2 || role == 3){%>
		<div class="mblf layui-col-xs6 layui-col-md6">
			<i class="layui-icon">&#xe656;</i>
			<p>个人信息详情</p>
		</div>
		<%}%>


	</div>
	<!--面包屑导航-->
	<blockquote class="layui-elem-quote">
		平台用户
		<a class="layui-btn layui-btn-normal float-right">修改</a>
	</blockquote>
	<!--岗位标题-->
	<div class="layui-row">
		<div class="layui-card positionbox">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>基本信息</legend>
			</fieldset>
			<form class="layui-form" action="">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>招聘岗位</label>
					<div class="layui-input-block">
						人事专员
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">月薪范围</label>
					<div class="layui-input-inline">
						4000-6000
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">最低学历</label>
					<div class="layui-input-block">
						大专
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">工作区域</label>
					<div class="layui-input-inline">
						河南省-郑州市-二七区
					</div>
				</div>

			</form>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>直接需求</legend>
			</fieldset>
			<form  class="layui-form" action="">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>所需人数</label>
					<div class="layui-input-block">
						5人
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">年龄要求</label>
						<div class="layui-input-inline" style="width: 100px;">
							18-32岁
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别要求</label>
					<div class="layui-input-block">
						不限
					</div>
				</div>
			</form>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>需求项目</legend>
			</fieldset>
			<div class="fuldy">
				<a href="javascript:;" class="layui-btn">月嫂</a>
				<a href="javascript:;" class="layui-btn">保洁</a>
				<a href="javascript:;" class="layui-btn">保镖</a>
				<a href="javascript:;" class="layui-btn">保安</a>
				<a href="javascript:;" class="layui-btn">护工</a>
				<a href="javascript:;" class="layui-btn">其他</a>
			</div>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>补充说明</legend>
			</fieldset>
			<form  class="layui-form" action="">
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">补充说明</label>
					<div class="layui-input-block">
						倾向于有工作经验的
					</div>
				</div>
			</form>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>积分设置</legend>
			</fieldset>
			<form  class="layui-form" action="">
				<div class="layui-form-mid layui-word-aux" style="padding: 0 0 10px 110px!important;">请根据员工品质与职位紧急程度合理设定悬赏金额</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>奖金设置</label>
					<div class="layui-input-inline">
						100
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">悬赏类型</label>
						<div class="layui-input-inline">
							审核通过
						</div>
					</div>
				</div>
				<%--<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>积分设置</label>
					<div class="layui-input-inline">
						2000
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">悬赏类型</label>
						<div class="layui-input-inline">
							面试通过
						</div>
					</div>--%>
				</div>
			</form>


		</div>
	</div>
</div>
<script src="<%=basePath%>views/assets/jquery.min.js"></script>
<script src="<%=basePath%>views/assets/layui.all.js"></script>
<script>
	layui.use('form', function(){
		var form = layui.form;
		form.render();
	});
</script>

</body>
</html>