<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <%--<meta http-equiv="content-type" content="text/html; charset=UTF-8">--%>
    <%--<meta charset="UTF-8">--%>

    <script type="text/javascript">

        function onSubmit() {
            var method = document.getElementById('method').value;
            var action = document.getElementById('action').value;
            var form = document.getElementById('form');
            form.method = method;
            form.action = action;
            form.submit();
        }

        function onSubmit1() {
            var bid = document.getElementById('bid').value;
            var methd = document.getElementById('method1').value;
            var form = document.getElementById('form1');
            form.method = methd;
            form.action = 'http://localhost:8080/image/' + bid;
            form.submit();
        }

    </script>

</head>
<body>
<h2>上传图片</h2>
<ul>
    <li>method:<input type="text" id="method1" value="post"></li>
    <li>bloggerId：<input type="number" id="bid" value="1"></li>
</ul>
<form enctype="multipart/form-data" id="form1">
    <input type="file" name="image"> <br>
    category:<input type="number" name="category"><br>
    bewrite:<input type="text" name="bewrite"><br>
    title:<input type="text" name="title"><br>
    <input type="button" onclick="onSubmit1()" value="提交">
</form>

<hr>
<hr>
<ul>
    <li>method:<input type="text" id="method" value="post"></li>
    <li>action:<input type="text" id="action" value="http://localhost:8080/blogger/1/blog"></li>
</ul>
<h2>新增博文</h2>
<form id="form">
    <ol>
        <li>cids:<input type="text" name="cids"></li>
        <li>lids:<input type="text" name="lids"></li>
        <li>title:<input type="text" name="title"></li>
        <li>content:<input type="text" name="content"/></li>
        <li>summary:<input type="text" name="summary"></li>
        <li>keyWords:<input type="text" name="keyWords"></li>
    </ol>
    <input type="button" onclick="onSubmit()" value="提交">
</form>

</body>
</html>
