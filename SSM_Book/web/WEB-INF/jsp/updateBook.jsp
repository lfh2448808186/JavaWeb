<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2020/2/15
  Time: 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
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
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bookID" value="${book.getBookNo()}"/>

        书    名：<input type="text" name="bookName"  value="${book.getBookName()}"><br><br><br>
        作    者：<input type="text" name="author" value="${book.getAuthor()}"><br><br><br>
        出 版 社：<input type="text" name="publish" value="${book.getPublish()}"><br><br><br>
        出版时间：<input type="text" name="publishtime" value="${book.getPublishtime()}"><br><br><br>
        价    格<input type="text" name="price" value="${book.getPrice()}"><br><br><br>
        详    情：<input type="text" name="detail" value="${book.getDetail()}"><br><br><br>
        <input type="submit" value="提交"/>
    </form>


</div>