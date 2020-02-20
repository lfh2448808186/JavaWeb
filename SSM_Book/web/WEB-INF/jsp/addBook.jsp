<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2020/2/15
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        书号：  <input type="text" name="bookNo"><br><br><br>
        书名：  <input type="text" name="bookName"><br><br><br>
        作者：  <input type="text" name="author"><br><br><br>
        出版社：<input type="text" name="publish"><br><br><br>
        时间：  <input type="text" name="publishtime"><br><br><br>
        价格    <input type="text" name="price"><br><br><br>
        详情：  <input type="text" name="detail"><br><br><br>
                    <input type="submit" value="添加">
    </form>

</div>