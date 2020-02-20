<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/9
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改图书信息</title>
</head>
<body>
<div>
    <h4><a href="${pageContext.request.contextPath }/Book?type=home" >回到首页</a></h4>

    <%--<h4><a href="${pageContext.request.contextPath }/Book?method=home" >回到首页</a></h4>--%>
</div>
<div align="center">
    <form action="/Book?type=updateBook" method="post" >
        <p>请输入相关内容</p>
        <p>书号<input type="text" name="bookNo"></p>
        <p>书名<input type="text" name="bookName"></p>
        <p>作者<input type="text" name="author"> </p>
        <p>出版社<input type="text" name="publish"></p>
        <p>出版时间<input type="text" name="publishTime"></p>
        <p>价格<input type="text" name="price"></p>
        <input type="reset" value="重置">
        <input type="submit" value="提交" >
    </form>
</div>
</body>
</html>
