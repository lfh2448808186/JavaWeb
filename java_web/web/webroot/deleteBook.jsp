<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/17
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下架图书</title>
</head>
<body>
<div>
    <h4><a href="${pageContext.request.contextPath }/webroot/home.jsp" >回到首页</a></h4>
</div>
<div align="center">
    <form action="/deleteByBookNoServlet" method="post">
        图书下架<input type="text" placeholder="请输入你要删除的书号" name = "bookNo">
        <input type="submit" value="提交">
    </form>
</div>


</body>
</html>