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
    <link rel="stylesheet" href="<%=basePath%>views/assets/css/style.css"/>
    <style type="text/css">
        .layui-form-item{ margin-bottom: 0;}
    </style>
</head>
<body class="layui-view-body">
<div class="layui-content">
    <!--面包屑导航-->
    <div class="mianb">
        <div class="mblf layui-col-xs6 layui-col-md6">
            <i class="layui-icon">&#xe656;</i>
            <p>职位管理 > <span>职位管理</span></p>
        </div>
        <div class="mbrt layui-col-xs6 layui-col-md6">
            <a href="05发布职位1.html" class="layui-btn layui-btn-normal">发布职位</a>
        </div>
    </div>
    <!--面包屑导航-->
    <div class="layui-row">
        <div class="layui-card">
            <div class="sortbox layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">按企业筛选</label>
                    <div class="layui-input-inline">
                        <select name="interest" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0">河南白象</option>
                            <option value="1" selected="">蜜雪冰城</option>
                            <option value="2">河南卓聘企业信息咨询有限公司</option>
                            <option value="3">音乐</option>
                            <option value="4">旅行</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <table class="layui-table" lay-skin="line" lay-size="lg" id="table">
                    <thead>
                    <tr>
                        <th class="layui-form">
                            <input type="checkbox" name="" lay-skin="primary" title="">
                        </th>
                        <th>招聘岗位</th>
                        <th>企业名称</th>
                        <th>招聘人数</th>
                        <th>悬赏积分</th>
                        <th>发布时间</th>
                        <th>是否紧急</th>
                        <th>置顶</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
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
                            <input type="checkbox" name="open" lay-skin="switch" lay-filter="switchTest" >
                        </td>
                        <td><a class="layui-btn layui-btn-normal layui-btn-xs">置顶</a></td>
                        <td>
                            <div class="layui-table-cell laytable-cell-1-0-10">
                                <a href="07职位管理-详情.html" class="layui-btn layui-btn-xs">查看</a>
                                <a class="layui-btn layui-btn-normal layui-btn-xs">修改</a>
                                <a class="layui-btn layui-btn-danger layui-btn-xs delete">删除</a>
                            </div>
                        </td>
                    </tr>
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
                            <input type="checkbox" name="open" lay-skin="switch" lay-filter="switchTest" >
                        </td>
                        <td><a class="layui-btn layui-btn-primary layui-btn-xs">取消置顶</a></td>
                        <td>
                            <div class="layui-table-cell laytable-cell-1-0-10">
                                <a href="07职位管理-详情.html" class="layui-btn  layui-btn-xs">查看</a>
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
    $('#fabu').on('click', function(){
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.open({
                type: 2,
                title: '发布任务',
                fix: false,
                shadeClose: true,
                shade: 0.8,
                area: ['660px', '420px'],
                content: '02任务发布-发布任务.html',
                end: function () {
                    location.reload();
                }
            });
        });
    })

    //判断弹框
    $(".delete").click(function(){
        layer.confirm('确定要删除该职位信息？', {
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

</body>
</html>