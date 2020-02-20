<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/10/12
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>图书管理系统</title>
  <style>
    body{background-color: #166796}
    .no3{
      margin: 150px 0px 0px 0px;
      margin-top: -415px;
      margin-left:370px ;
    }
    .no1{margin: 0px 300px;width: 100%}
    span{
      width: 102px;
      padding: 1px;
    }
    input{
      width: 135px;
      height: 26px;
      margin-left: 27px;
      margin-top: 32px;
      border: #17699b 1px solid;
      border-radius: 10px;
    }
    #log_back{
      width: 990px;}
    .bt1,.bt2{margin-top: 55px;width: 90px;height: 28px;margin-left: 78px}
    .bt1{margin-left: -50px}
    .bt1:hover,.bt2:hover{ background-color: #176998;}
    .select_id {margin-left: 10px}
    #select_id .select_id{ margin-left: 20px;width: 20px;height: 10px}
    #select_id {margin-top:-90px;font-size: 10px}
  </style>

</head>
<body>
<div class="no1">

  <div class="no2">
    <img id="log_back" src="${pageContext.request.contextPath }/images/librarylog.jpg" alt="找不到图片">
    <div class="no3">
      <form action="/User?type=login" method="post">
        <input  type="text" name="username"><br>
        <input  type="password" name="password"><br>
        <input class="bt1" type="button" value="注册" onclick="location='webroot/register.jsp'">
        <input class="bt2" type="submit" value="登陆">
        <div id="select_id" >
          <input name="id" class="select_id" type="radio" value="admin">管理员</input>
          <input name="id" class="select_id" type="radio" value="user" checked>用户</input>

        </div>
      </form>
    </div>

  </div>
</div>
</body>
</html>