<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/16
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    欢迎您，${username}登陆成功！
    <a href="${pageContext.request.contextPath}/bookListServlet">查询所有图书信息</a>
    <a href="${pageContext.request.contextPath}/queryBookByPageServlet">分页查询所有图书信息</a>
</body>
</html>
