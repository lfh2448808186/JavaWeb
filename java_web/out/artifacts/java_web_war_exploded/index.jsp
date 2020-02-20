<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/15
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户登录</title>
    <link rel="stylesheet" href="resource/bootstrap-3.3.7-dist/css/bootstrap.min.css">

    <script>
      window.onload = function () {
        var img = document.getElementById("checkCode");
        img.onclick = function () {
          var date = new Date().getTime();
          img.src = "/CheckCodeServlet?"+date;
        }
      }
    </script>
  </head>
  <body>
  <div align="center">
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
      用户名<input type="text"name="username"><br>
      密码<input type="password"name="password"><br>
      验证码 <input type="text" name="checkCode">
      <img id="checkCode" src="${pageContext.request.contextPath}/CheckCodeServlet"><br>
      <input type="button" value="注册"  onclick="location='webroot/addUser.jsp'">
      <input type="reset" value="重置">
      <input type="submit" value="提交">
    </form>
    <div class="alert alert-warning" role="alert"> ${cc_error}</div>
    <div class="alert alert-danger" role="alert">${login_error}</div>
    <div class="alert alert-danger" role="alert">${login_msg}</div>


  </div>

  </body>
</html>
