<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/17
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h4><a href="${pageContext.request.contextPath}/webroot/home.jsp" >回到首页</a></h4>
</div>
<div class="explore-bookName">
    <form action="/queryBookNameServlet" method="post">
        <input type="text" placeholder="请输入书名" name="bookName">
        <input type="submit"  value="搜索">
    </form>
</div>


</body>
</html>
