<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/11/29
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>


<body>

<a onclick="findBrand()">哈哈哈哈</a>





</body>


<script type="text/javascript">
    function findBrand() {
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "findShop",
            success: function(data) {
                console.log(data);
                console.log(data.brand.shops);
                for(let i=0;i<data.brand.shops.length;i++){
                    var tr=document.createElement('tr');//创建tr标签
                    tr.className="success";
                    document.getElementById("my_table").appendChild(tr);//把tr标签放进table中

                    var td=document.createElement('td');//创建sid的td标签
                    tr.appendChild(td);//将td添加为tr的子标签
                    td.innerHTML=data.brand.shops[i].sid;//賦值

                    var td=document.createElement('td');//创建sname的td标签
                    tr.appendChild(td);//将td添加为tr的子标签
                    td.innerHTML=data.brand.shops[i].sname;

                    var td=document.createElement('td');//创建num的td标签
                    tr.appendChild(td);//将td添加为tr的子标签
                    td.innerHTML=data.brand.shops[i].num;

                    var td=document.createElement('td');//创建price的td标签
                    tr.appendChild(td);//将td添加为tr的子标签
                    td.innerHTML=data.brand.shops[i].price;

                    var td=document.createElement('td');//创建date的td标签
                    tr.appendChild(td);//将td添加为tr的子标签

                }
            }
            });
    }
</script>

<div class="container">
    <h3 style="text-align: center">${brand.bname}商品信息</h3>
    <table class="table table-bordered table-hover  table-striped table-condensed" id="my_table">
        <tr class="success">
            <td>sid</td><td>sname</td><td>num</td><td>price</td><td>pic</td><td></td>
        </tr>
    </table>
</div>




<script src="js/jquery-3.4.1.min.js"></script>
</html>
