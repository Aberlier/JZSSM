
    function changeStatus(){
        var status=document.getElementById("indexStatus").valueOf();
        document.getElementById("status").value=status;
    }
function init(){
    var countNumber=document.getElementById("countNumber").value;
    var sumPage=document.getElementById("sumPageNumber").value;
    var currentPage=document.getElementById("currentPage").value;
    var info="一共<font color='blue'>"+countNumber+"</font>条数据，"+"共<font color='blue'>"+sumPage+"</font>页，"+
        "当前第<font color='blue'>"+currentPage+"</font>页，";
    document.getElementById("pageInfo").innerHTML=info;
}
//上一页
function toPrePage(){
    var currentPageObject=document.getElementById("currentPage");
    var currentPage=parseInt(currentPageObject.value);
    if(currentPage==1){
        alert("数据已经到顶！");
    }else{
        currentPageObject.value=currentPage-1;
        var PageSize=parseInt(document.getElementById("pageSize").value);
        var startPageObject=document.getElementById("startPage");
        startPageObject.value=parseInt(startPageObject.value)-PageSize;
        document.getElementById("listForm").submit();
    }
}
function toNextPage(){
    var currentPageObject=document.getElementById("currentPage");
    var currentPage=parseInt(currentPageObject.value);
    var sumPage=parseInt(document.getElementById("sumPageNumber").value);
    if(currentPage>=sumPage){
        alert("数据已经到底！");
    }else{
        currentPageObject.value=currentPage+1;
        var pageSize=parseInt(document.getElementById("pageSize").value);
        var startPageObject=document.getElementById("startPage");
        startPageObject.value=parseInt(startPageObject.value)+pageSize;
        document.getElementById("listForm").submit();
    }
}

function toLocationPage(){
    var pageNumber=document.getElementById("pageNumber").value;
    var currentPageObject=document.getElementById("currentPage");
    var currentPage=currentPageObject.value;
    if(pageNumber==null||pageNumber==""){
        alert("请输入需要跳转得页数！");
    }else{
        pageNumber=parseInt(pageNumber);
        var sumPage=parseInt(document.getElementById("sumPageNumber").value);
        if(pageNumber<1){
            alert("数据已经到顶！");
        }else if(pageNumber>sumPage){
            alert("数据已经到底！");
        }else{
            currentPageObject.value=pageNumber;
            var pageSize=parseInt(document.getElementById("pageSize").value);
            var startPageObject=document.getElementById("startPage");
            if(pageNumber>currentPage){
                startPageObject.value=parseInt(startPageObject.value)+pageSize;
            }else if(pageNumber<currentPage){
                startPageObject.value=parseInt(startPageObject.value)-pageSize;
            }
            document.getElementById("listForm").submit();
        }
    }
}
