<%--
  Created by IntelliJ IDEA.
  User: Angular
  Date: 2021/1/10
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>轮播图</title>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/view.css"/>
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/admin.css"/>
</head>
<body class="layui-view-body">
<div class="layui-content">
    <!--面包屑导航-->
    <div class="mianb">
        <div class="mblf layui-col-xs6 layui-col-md6">
            <i class="layui-icon">&#xe656;</i>
            <p>首页管理 > <span>轮播图</span></p>
        </div>
        <div class="mbrt layui-col-xs6 layui-col-md6">
            <a href="javascript:;" class="layui-btn layui-btn-normal" id="addbanner">增加</a>
        </div>
    </div>
    <!--面包屑导航-->
    <div class="layui-row">
        <div class="layui-card">
            <div class="table-responsive">
                <table class="layui-table" lay-skin="line" lay-size="lg" id="table">
                    <thead>
                    <tr>
                        <th width="15%">排序</th>
                        <th>图片预览</th>
                        <th>显示</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input type="text"  placeholder="1" class="layui-input"></td>
                        <td>
                            <div id="layer-photos-demo" class="layer-photos-demo">
                                <img layer-pid="" layer-src="../assets/images/banner01.png" src="../assets/images/banner01.png" alt="图片名">
                            </div>
                        </td>
                        <td class="layui-form">
                            <input type="checkbox" checked="" name="open" lay-skin="switch" lay-filter="switchTest" >
                        </td>
                        <td>
                            <div class="layui-table-cell laytable-cell-1-0-10">
                                <a class="layui-btn layui-btn-normal layui-btn-xs">修改</a>
                                <a class="layui-btn layui-btn-danger layui-btn-xs delete">删除</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="text"  placeholder="2" class="layui-input"></td>
                        <td>
                            <div id="layer-photos-demo" class="layer-photos-demo">
                                <img layer-pid="" layer-src="../assets/images/banner02.png" src="../assets/images/banner02.png" alt="图片名">
                            </div>
                        </td>
                        <td class="layui-form">
                            <input type="checkbox" checked="" name="open" lay-skin="switch" lay-filter="switchTest" >
                        </td>
                        <td>
                            <div class="layui-table-cell laytable-cell-1-0-10">
                                <a class="layui-btn layui-btn-normal layui-btn-xs">修改</a>
                                <a class="layui-btn layui-btn-danger layui-btn-xs delete">删除</a>
                            </div>
                        </td>
                    </tr>
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
<script>
    var element = layui.element;
    layui.use(['laypage', 'layer'], function(){
        var laypage = layui.laypage
            ,layer = layui.layer;

        //页码完整功能
        laypage.render({
            elem: 'page'
            ,count: 100
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
            ,jump: function(obj){
                console.log(obj)
            }
        });
    });

    //弹框
    $('#addbanner').on('click', function(){
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.open({
                type: 2,
                title: '添加轮播图',
                fix: false,
                shadeClose: true,
                shade: 0.8,
                area: ['660px', '420px'],
                content: '01轮播图-添加图片.html',
                end: function () {
                    location.reload();
                }
            });
        });
    })

    //判断弹框
    $(".delete").click(function(){
        layer.confirm('确定要删除此图片？', {
            btn: ['是','否'] //按钮
        }, function(){
            layer.msg('已删除', {icon: 1});
        }, function(){
            layer.msg('已取消',  {icon: 2});
        });
    })

    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
</script>
<script>
    //调用示例
    layer.photos({
        photos: '.layer-photos-demo'
        ,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
    });
</script>
</body>
</html>