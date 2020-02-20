<%@ page import="java.util.ArrayList" %>
<%@ page import="java.awt.print.Book" %><%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/10/13
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>图书馆主页</title>
    <style>
        body{
            background-color: white;
        }
        .main-container{
            margin-left: 10%;
            margin-right: 10%;
            hight:1000px;
            /*background-color: #166796;*/
            border: black 1px solid;

        }
        .top-log{
            width: 100%;
            height: 100px;
            border: black 1px solid;
            /*background-color: #17699b;*/
            text-align: center;
        }
        .middle-container{
            width: 100%;

        }
        .middle-container div{
            float: left
        }
        .container-1,.container-3{
            width: 15%;
            height: 800px;
            /*background-color:#166796;*/
            text-align: center;
        }
        .container-2{
            width: 70%;
            height: 800px;
            border: 1px solid black;
        }
        .bottom{
            height: 10%;
            width: 100%;
            margin-top: 800px;
            border: black 1px solid;
            text-align: center;
        }
        .list-1{ list-style: none; }
        .list-1 li {
            margin-top: 100px;
        }
        .list-1 a{
            font-size: 15px;
            text-decoration-line: none;
            padding: 1px ;
        }
        /*.list-1:hover{*/
            /*background-color: green;*/
            /*padding: 1px;*/
            /*border: yellow 1px ridge;*/
        /*}*/

        .container-2{text-align: center;
            border: 1px black solid;}

        .container-2 #bookName{
            width: 500px;
            margin-top: 10px;
            margin-left: 100px;
        }
        .explore-results{
            text-align: center;
        }
        .results{
            cellspacing:10px ;cellpadding:1px;
            margin-left: 50px;
            width: 800px;
            border: solid 2px black;
            text-align: center;}
        .results td{border-left: 1px solid black}
    </style>

    <script src="../webroot/js/jquery-3.3.1.min.js"></script>
    <script src="selectBookName.jsp"></script>

</head>

<body>
<%--在此页面添加UserBean和AdminBean的属性，根据Servlet返回的信息再进行身份的判断登陆--%>
<div class="main-container">
    <div class="top-log">
        <h1>欢迎你，${user}来到图书管理系统</h1>
    </div>
    <div class="middle-container">
        <div class="container-1">
            <ur class="list-1">

                <li><a href="${pageContext.request.contextPath }/Book?type=selectAllBooks" id="operate-1">图书浏览</a></li>
                <li><a href="${pageContext.request.contextPath }/webroot/selectBookName.jsp" id="operate-2">图书名查询</a></li>
                <li><a href="${pageContext.request.contextPath }/webroot/newBooks.jsp" id="operate-3">新书上架</a></li>
                <li><a href="${pageContext.request.contextPath }/webroot/deleteBooks.jsp" id="operate-4">图书下架</a></li>
                <li><a href="${pageContext.request.contextPath }/webroot/selectAuthor.jsp" id="operate-5">作者图书查询</a></li>
            </ur>
        </div>
        <div class="container-2">
            <div class="explore-bookName">
                <form action="${pageContext.request.contextPath }/Book?type=queryBooks" method="post" >
                    <input type="text" placeholder="请输入书名或作者名" name="target">
                    <input type="submit" id="query" value="搜索" >
                </form>
            </div><br><br><hr>
            <div class="explore-results">
                ${pageContex.session.id}
            </div>


        </div>
        <div class="container-3">
            <a href="${pageContext.request.contextPath }/index.jsp">注销</a>
        </div>
    </div>
    <div class="bottom">

    </div>

</div>




</body>
</html>
