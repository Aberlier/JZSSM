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
		<div class="mblf layui-col-xs6 layui-col-md6">
			<i class="layui-icon">&#xe656;</i>
			<p>用户管理> <a href="<%=basePath%>empController/findAllUserData?loginId=<%=loginId%>&token=<%=param%>">用户列表</a> ><span>用户详情</span></p>
		</div>
	</div>
	<!--面包屑导航-->
	<blockquote class="layui-elem-quote">
		平台用户
		<a class="layui-btn layui-btn-normal float-right" onclick="updateEmp('${emp.employerId}','<%=loginId%>','<%=param%>','<%=role%>')">修改</a>
	</blockquote>
	<!--岗位标题-->
	<div class="layui-row">
		<div class="layui-card positionbox">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>基本信息</legend>
			</fieldset>
			<form class="layui-form" action="">
				<div class="layui-form-item">
					<label class="layui-form-label">编号: </label>
					<div class="layui-input-block">
						${emp.employerId}
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>姓名：</label>
					<div class="layui-input-inline">
						${emp.employerName}
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>年龄：</label>
					<div class="layui-input-inline">
						${emp.employerAge}
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>身份证号：</label>
					<div class="layui-input-inline">
						${emp.employerIdcard}
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>角色：</label>
					<div class="layui-input-block">
						<c:if test="${emp.employerRole==1}">
							管理员
						</c:if>
						<c:if test="${emp.employerRole==2}">
							家政职工
						</c:if>
						<c:if test="${emp.employerRole==3}">
							用户
						</c:if>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>密码：</label>
					<div class="layui-input-block">
						${emp.employerPwd}
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>手机：</label>
					<div class="layui-input-inline">
						${emp.employerTelnum}
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>地址：</label>
					<div class="layui-input-inline">
						${emp.employerAddress}
					</div>
				</div>

			</form>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>工作</legend>
			</fieldset>
			<form  class="layui-form" action="">
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>职位</label>
					<div class="layui-input-block">
						<td>
							<c:if test="${emp.employerField==null}">
								<a href="javascript:;" class="layui-btn">暂未申请或分配</a>
							</c:if>
							<c:if test="${emp.employerField==1}">
							<a href="javascript:;" class="layui-btn">保安</a>
						</c:if>
							<c:if test="${emp.employerField==2}">
								<a href="javascript:;" class="layui-btn">保洁</a>
							</c:if>
							<c:if test="${emp.employerField==3}">
								<a href="javascript:;" class="layui-btn">保镖</a>
							</c:if>
							<c:if test="${emp.employerField==4}">
								<a href="javascript:;" class="layui-btn">护工</a>
							</c:if>
							<c:if test="${emp.employerField==5}">
								<a href="javascript:;" class="layui-btn">月嫂</a>
							</c:if></td>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">荣获星级</label>
						<div class="layui-input-inline" style="width: 100px;">
							<c:if test="${emp.employerPostname==null}">
								暂未评星
							</c:if>
								<c:if test="${emp.employerPostname==2}">
									荣获2星专业人员
								</c:if><c:if test="${emp.employerPostname==3}">
								荣获3星专业人员
							</c:if><c:if test="${emp.employerPostname==4}">
								荣获4星专业人员
							</c:if><c:if test="${emp.employerPostname==5}">
								荣获5星专业人员
							</c:if>

						</div>
					</div>
				</div>

			</form>
			<div class="fuldy">

			</div>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>补充说明</legend>
			</fieldset>
			<form  class="layui-form" action="">
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">补充说明</label>
					<div class="layui-input-block">
						${emp.employerDesc}
					</div>
				</div>
			</form>


			<c:if test="${pkstar!=null}">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>星级设置</legend>
			</fieldset>
			<form  class="layui-form" action="">
				<div class="layui-form-mid layui-word-aux" style="padding: 0 0 10px 110px!important;">请根据员工品质与职位紧急程度合理设定星级数量</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="col-red">*</span>获得星数：</label>
					<div class="layui-input-inline">
							${pkstar.pkStarNum}/颗星
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">评星人</label>
						<div class="layui-input-inline">
								${pkstar.pkGiveStarName}
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

			</c:if>




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
	//修改信息
	function updateEmp(id,loginId,token,role) {
		layer.alert('确定要修改信息？', function () {
			$.ajax({
				type:'get',
				url:'empController/updateEmpBefore?id='+id+"&loginId="+loginId+"&token="+token+"&role="+role,
				/*  data:id,//数据为id数组*/
				traditional:true,
				success:function(result) {
					if (result.code == 200) {
						var domainUser = result.data.model.domainUser
						var layer = layui.layer;
						layer.open({
							type: 2,
							title: '修改信息',
							fix: false,
							shadeClose: true,
							shade: 0.8,
							area: ['660px', '420px'],
							content: result.data.viewName,
							end: function () {
								location.reload();
							}
						});
						/* //成功后刷新界面
                         location.reload();*/
					}else {
						alert("修改失败！错误代码："+result.message,{icon: 2});
					}
				}
			});
		});
	}
</script>

</body>
</html>