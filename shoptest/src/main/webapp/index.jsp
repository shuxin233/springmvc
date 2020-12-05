<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index</title>
</head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/index.css">
<style>
    /* 下拉按钮样式 */
    .dropbtn {
        background-color: #4CAF50;
        color: white;
        padding: 16px;
        font-size: 16px;
        border: none;
        cursor: pointer;
    }

    /* 容器 <div> - 需要定位下拉内容 */
    .dropdown {
        position: relative;
        display: inline-block;
        margin-left: 400px;
        margin-top: 20px;
    }

    /* 下拉内容 (默认隐藏) */
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    }

    /* 下拉菜单的链接 */
    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    /* 鼠标移上去后修改下拉菜单链接颜色 */
    .dropdown-content a:hover {background-color: #f1f1f1}

    /* 在鼠标移上去后显示下拉菜单 */
    .dropdown:hover .dropdown-content {
        display: block;
    }

    /* 当下拉内容显示后修改下拉按钮的背景颜色 */
    .dropdown:hover .dropbtn {
        background-color: #3e8e41;
    }
</style>
<body>

<div class="dropdown">
    <button class="dropbtn">请选择品牌</button>
    <div class="dropdown-content">
        <a onclick="findBrand('小米')">小米</a>
        <a onclick="findBrand('Apple')">Apple</a>
        <a onclick="findBrand('华为')">华为</a>
    </div>
</div>

<div class="container">
    <h3 style="text-align: center">${brand.bname}商品信息</h3>
    <table class="table table-bordered table-hover  table-striped table-condensed" id="my_table">
        <tr class="success">
            <td>sid</td><td>sname</td><td>num</td><td>price</td><td>修改信息</td>
        </tr>
    </table>
    <table class="table table-bordered table-hover  table-striped table-condensed" >
        <tr class="success">添加商品信息</tr>
    <tr class="success">
        <form action="insertShop">
            <td><input type="text" name="newsid" placeholder="sid"></td>
            <td><input type="text" name="newsname" placeholder="sname"></td>
            <td><input type="text" name="newnum"placeholder="num"></td>
            <td><input type="text" name="newprice"placeholder="price"></td>
            <td><input type="text" name="brand" placeholder="品牌"></td>
            <td><input type="submit" value="提交"></td>
        </form>
    </tr>
    </table>
</div>
<%--<div class="container">
    <h3 style="text-align: center">${brand.bname}商品信息</h3>
    <table class="table table-bordered table-hover  table-striped table-condensed">
        <tr class="success">
            <td>sid</td><td>sname</td><td>num</td><td>price</td><td>pic</td><td></td>
        </tr>
        <c:forEach items="${brand.shops}" var="shop">
            <tr>
                  &lt;%&ndash;  <div id="show" style="display: block">
                    <td>${shop.sname}</td>
                    <td>${shop.num}</td>
                    <td>${shop.price}</td>
                    <td>${shop.pic}</td>
                    <td><a class="btn btn-default btn-sm" onclick="update()">修改</a>
                    </div>&ndash;%&gt;
                        <form action="updateShop" method="post">
                            <td><input value="${shop.sid}" name="sid" style="display: none">${shop.sid}</td>
                        <td><input value="${shop.sname}" name="sname" style="display: none">${shop.sname}</td>
                        <td><input value="${shop.num}" name="newnum"></td>
                        <td><input value="${shop.price}" name="newprice"></td>
                        <td><input value="${shop.pic}" name="pic" style="display: none"><img style="width: 100px;height: 100px" src="${shop.pic}"></td>
                        <td><a class="btn btn-default btn-sm"><input type="submit" value="修改"></a>
                        </form>
                        <a class="btn btn-default btn-sm" href="deleteShopBySid?deleteSid=${shop.sid}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>--%>




<script type="text/javascript">


    
    function findBrand(bname) {
        $(".success1").empty();
            $.ajax({
                type: "get",
                dataType: "json",
                url: "findShop?bname="+bname,
                success: function(data) {
                    console.log(data.brand.shops);
                    for(let i=0;i<data.brand.shops.length;i++){
                        var tr=document.createElement('tr');//创建tr标签
                        tr.className="success1";
                        document.getElementById("my_table").appendChild(tr);//把tr标签放进table中

                        var td=document.createElement('td');//创建sid的td标签
                        tr.appendChild(td);//将td添加为tr的子标签
                        td.className="table-bordered";
                        td.innerHTML=data.brand.shops[i].sid;//賦值

                        var td=document.createElement('td');//创建sname的td标签
                        tr.appendChild(td);//将td添加为tr的子标签
                        td.className="table-bordered";
                        td.innerHTML=data.brand.shops[i].sname;

                        var td=document.createElement('td');//创建num的td标签
                        tr.appendChild(td);//将td添加为tr的子标签
                        td.className="table-bordered";
                        td.innerHTML=data.brand.shops[i].num;

                        var td=document.createElement('td');//创建price的td标签
                        tr.appendChild(td);//将td添加为tr的子标签
                        td.className="table-bordered";
                        td.innerHTML=data.brand.shops[i].price;


                        var td=document.createElement('td');//创建date的td标签
                        var inputUpdata=document.createElement("input");//创建修改按钮
                        var inputDelete=document.createElement("input");//创建删除按钮
                        inputUpdata.type="button";inputUpdata.value="修改";
                        inputDelete.type="button";inputDelete.value="删除";
                        td.className="table-bordered";
                        tr.appendChild(td);//将td添加为tr的子标签
                        td.appendChild(inputUpdata);//将input添加为td的子标签
                        td.appendChild(inputDelete);//将input添加为td的子标签
                    }
                }
            });


    }
</script>


<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.js"></script>


</body>
</html>
