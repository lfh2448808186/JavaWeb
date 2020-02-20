<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/1
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <div>
        <div>
            <h4><a href="${pageContext.request.contextPath }/index.jsp" >回到登陆界面</a></h4>
        </div>
        <div>
            <form action="/User?type=register" method="post"  >
                请输入用户名：<input type="text" name="username">
                请输入密码：<input type="password" >
                请确认密码：<input type="password" name="password">
                <input type="reset" value="重置">
                <input type="submit" value="提交" >
            </form>

        </div>
    </div>
</body>
</html>
