<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/4
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
Created by IntelliJ IDEA.
User: LFH
Date: 2019/10/20
Time: 11:05
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作者名查询</title>
</head>
<body>
<div>
    <h4><a href="${pageContext.request.contextPath }/Book?type=home" >回到首页</a></h4>
</div>

<div class="explore-bookName" align="center">
    <form action="/Book?type=selectAuthor" method="post">
        <input type="text" placeholder="请输入作者名" name="author">
        <input type="submit"  value="搜索" >
    </form>
</div>


</body>
</html>
</body>
</html>
