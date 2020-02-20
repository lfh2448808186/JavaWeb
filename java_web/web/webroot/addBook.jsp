<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/17
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="../resource/jquery-3.3.1.min.js">
    <title>新书上架</title>
    <script>
        var defaultDate = document.querySelectorAll('.date-picker');
        for (var i = 0; i<defaultDate.length; i++) {
            defaultDate[i].valueAsDate = new Date();
        }
    </script>

</head>
<body>
<h4><a href="${pageContext.request.contextPath }/webroot/home.jsp" >回到首页</a></h4>
</div>
<div align="center">
    <form action="${pageContext.request.contextPath}/addBookServlet" method="post" >
        <p>请输入相关内容</p>
        <p>书号<input type="text" name="bookNo"></p>
        <p>书名<input type="text" name="bookName"></p>
        <p>作者<input type="text" name="author"> </p>
        <p>出版社<input type="text" name="publish"></p>
        <p>出版时间<input class="date-picker" type="date"  id="bt" name="publishTime"></p>
        <p>价格<input type="text" name="price"></p>
        <input type="reset" value="重置">
        <input type="submit" value="提交" >
    </form>

</div>
</body>
</html>
