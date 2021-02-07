<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>发布职位1</title>
    <link rel="stylesheet" href="../assets/css/layui.css">    
    <link rel="stylesheet" href="../assets/css/view.css"/>
    <link rel="stylesheet" href="../assets/css/admin.css"/>  
    <link rel="stylesheet" href="../assets/css/style.css"/> 
</head>
<body class="layui-view-body">
    <div class="layui-content">
    	<!--面包屑导航-->
    	<div class="mianb">
    		<div class="mblf layui-col-xs6 layui-col-md6">
    			 <i class="layui-icon">&#xe656;</i>
    			 <p>职位管理 > 发布职位 > <span>填写职位信息</span></p>
    		</div>    		
    	</div>
    	<!--面包屑导航-->
    	<div class="layui-row layui-col-space5 linarrow">
		    <div class="layui-col-md4 linitem">
		      <div class="grid-demo active">1.填写职位信息</div>
		    </div>
		    <div class="layui-col-md4 linitem">
		      <div class="grid-demo">2.完善企业信息</div>
		    </div>
		    <div class="layui-col-md4 linitem">
		      <div class="grid-demo">3.发布职位</div>
		    </div>
		</div>
		<!--指示条-->
        <div class="layui-row">        	
            <div class="layui-card positionbox">            	  
				    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
					    <legend>基本信息</legend>
					</fieldset>
					<form class="layui-form" action="">
						 <div class="layui-form-item">
							    <label class="layui-form-label"><span class="col-red">*</span>招聘岗位</label>
							    <div class="layui-input-block">
							      <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入岗位" class="layui-input">
							    </div>
						  </div>
						  <div class="layui-form-item">
							    <label class="layui-form-label">月薪范围</label>
							    <div class="layui-input-inline">
							      <select name="interest" lay-filter="aihao">
							        <option value="0">2000以下</option>
							        <option value="1">2000-4000</option>
							        <option value="2" selected="">4000-6000</option>
							        <option value="3">6000-8000</option>
							        <option value="4">8000-10000</option>
							        <option value="5">10000以上</option>
							      </select>
							    </div>
							    <div class="layui-inline">
							      <label class="layui-form-label">自定义</label>
							      <div class="layui-input-inline" style="width: 100px;">
							        <input type="text" name="price_min" placeholder="" autocomplete="off" class="layui-input">
							      </div>
							      <div class="layui-form-mid">-</div>
							      <div class="layui-input-inline" style="width: 100px;">
							        <input type="text" name="price_max" placeholder="" autocomplete="off" class="layui-input">
							      </div>
							    </div>
						  </div>
						  <div class="layui-form-item">
							    <label class="layui-form-label">最低学历</label>
							    <div class="layui-input-block">
							      <select name="interest" lay-filter="aihao">
							        <option value="0">不限</option>
							        <option value="1">小学</option>
							        <option value="2">初中</option>
							        <option value="3">高中</option>
							        <option value="4">技校</option>
							        <option value="5">中专</option>
							        <option value="6" selected="">大专</option>
							        <option value="7">本科</option>
							        <option value="8">研究生</option>
							        <option value="9">博士</option>
							      </select>
							    </div>						    
						  </div>
						  <div class="layui-form-item">
							    <label class="layui-form-label">工作区域</label>
							    <div class="layui-input-inline">
							      <select name="quiz1">
							        <option value="">请选择省</option>
							        <option value="浙江" selected="">浙江省</option>
							        <option value="你的工号">江西省</option>
							        <option value="你最喜欢的老师">福建省</option>
							      </select>
							    </div>
							    <div class="layui-input-inline">
							      <select name="quiz2">
							        <option value="">请选择市</option>
							        <option value="杭州">杭州</option>
							        <option value="宁波" disabled="">宁波</option>
							        <option value="温州">温州</option>
							        <option value="温州">台州</option>
							        <option value="温州">绍兴</option>
							      </select>
							    </div>
							    <div class="layui-input-inline">
							      <select name="quiz3">
							        <option value="">请选择县/区</option>
							        <option value="西湖区">西湖区</option>
							        <option value="余杭区">余杭区</option>
							        <option value="拱墅区">临安市</option>
							      </select>
							    </div>							   
							</div>
						  <div class="layui-form-item layui-form-text">
							    <label class="layui-form-label">职位描述</label>
							    <div class="layui-input-block">
							    	 <textarea id="demo" style="display: none;"></textarea>
							    </div>							    
							</div>
					</form>
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
					    <legend>职位设置</legend>
					</fieldset>
					<form  class="layui-form" action="">
						 <div class="layui-form-item">
							    <label class="layui-form-label"><span class="col-red">*</span>招聘人数</label>
							    <div class="layui-input-block">
							      <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入人数" class="layui-input">
							    </div>
						  </div>
						  <div class="layui-form-item">							    
							    <div class="layui-inline">
							      <label class="layui-form-label">年龄要求</label>
							      <div class="layui-input-inline" style="width: 100px;">
							        <input type="text" name="price_min" placeholder="最小年龄" autocomplete="off" class="layui-input">
							      </div>
							      <div class="layui-form-mid">-</div>
							      <div class="layui-input-inline" style="width: 100px;">
							        <input type="text" name="price_max" placeholder="最大年龄" autocomplete="off" class="layui-input">
							      </div>
							    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">性别要求</label>
						    <div class="layui-input-block">
						      <input type="radio" name="sex" value="不限" title="不限" checked="">
						      <input type="radio" name="sex" value="男" title="男" >
						      <input type="radio" name="sex" value="女" title="女">						      
						    </div>
						  </div>
					</form>
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
					    <legend>福利待遇</legend>
					</fieldset>
					<div class="fuldy">
						<a href="javascript:;" class="layui-btn">社保</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">公积金</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">奖金</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">绩效</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">提成</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">年终奖</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">带薪年假</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">房屋补助</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">商业保险</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">通讯补助</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">交通补助</a>
						<a href="javascript:;" class="layui-btn layui-btn-primary">其他</a>
					</div>
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
					    <legend>补充说明</legend>
					</fieldset>
					<form  class="layui-form" action="">
						 <div class="layui-form-item layui-form-text">
							    <label class="layui-form-label">补充说明</label>
							    <div class="layui-input-block">							    	
							       <textarea id="demo2" style="display: none;"></textarea>
							    </div>							    
							</div>
					</form>
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
					    <legend>积分设置</legend>
					</fieldset>
					<form  class="layui-form" action="">
						 <div class="layui-form-mid layui-word-aux" style="padding: 0 0 10px 110px!important;">请根据公司招聘预算与职位紧急程度合理设定悬赏金额</div>
						 <div class="layui-form-item">						 	
						 	    <label class="layui-form-label"><span class="col-red">*</span>积分设置</label>
							    <div class="layui-input-inline">
							      <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="" value="10" class="layui-input">
							    </div>
							    <div class="layui-inline">
								      <label class="layui-form-label">悬赏类型</label>
								      <div class="layui-input-inline">
								        <select name="modules" lay-verify="required" lay-search="">								         
								          <option value="1">审核通过</option>
								          <option value="2">面试通过</option>
								          <option value="3">已入职</option>
								          <option value="4">入职七天</option>
								          <option value="5">入职15天</option>
								          <option value="6">入职30天</option>								          
								        </select>
								      </div>
								</div>
						  </div>
						  <div class="layui-form-item">
							    <label class="layui-form-label"><span class="col-red">*</span>积分设置</label>
							    <div class="layui-input-inline">
							      <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入对应积分" class="layui-input">
							    </div>
							    <div class="layui-inline">
								      <label class="layui-form-label">悬赏类型</label>
								      <div class="layui-input-inline">
								        <select name="modules" lay-verify="required" lay-search="">
								          <option value="">直接选择或手动填写</option>
								          <option value="1">审核通过</option>
								          <option value="2">面试通过</option>
								          <option value="3">已入职</option>
								          <option value="4">入职七天</option>
								          <option value="5">入职15天</option>
								          <option value="6">入职30天</option>								          
								        </select>
								      </div>
								</div>
								<button type="button" class="layui-btn">添加</button>
						  </div>
					</form>
					<div class="layui-form-item">
					    <div class="layui-input-block">
					    	<a href="javascript:;" class="layui-btn layui-btn-primary">清空重置</a>
					        <a href="06发布职位2.html" class="layui-btn layui-btn-normal" >保存,下一步</a>
					    </div>
					  </div>
            </div>   
		</div>
    </div>
    <script src="../assets/jquery.min.js"></script>
    <script src="../assets/layui.all.js"></script>   
    <script>
	layui.use('layedit', function(){
	  var layedit = layui.layedit;
	  layedit.build('demo'); //建立编辑器
	});
	layui.use('layedit', function(){
	  var layedit = layui.layedit;
	  layedit.build('demo2'); //建立编辑器
	});	
	</script>>
</body>
</html>