<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/17
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>修改图书信息</title>
</head>
<body>
<div>
    <h4><a href="${pageContext.request.contextPath }/webroot/home.jsp" >回到首页</a></h4>


    <script>
        var defaultDate = document.querySelectorAll('.date-picker');
        for (var i = 0; i<defaultDate.length; i++) {
            defaultDate[i].valueAsDate = new Date();
        }
    </script>
</div>
<div align="center">
    <form action="${pageContext.request.contextPath}/updateBookServlet" method="post" >
        <p>请输入相关内容</p>
        <p><input type="hidden" name="no"  value="${books.no}"></p>
        <p>书号<input type="text" readonly name="bookNo" value="${books.bookNo}"></p>
        <p>书名<input type="text" readonly name="bookName" value="${books.bookName}"></p>
        <p>作者<input type="text" name="author" value="${books.author}"> </p>
        <p>出版社<input type="text" name="publish" value="${books.publish}"></p>
        <p>出版时间<input class="date-picker" type="date"  id="bt" name="publishTime" value="${books.publishTime}"></p>
        <p>价格<input type="text" name="price"  value="${books.price}"></p>
        <input type="reset" value="重置">
        <input type="submit" value="提交" >
    </form>
</div>
</body>
</html>
