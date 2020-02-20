<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/4
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>查询结果</title>
</head>
<body>
<div>
    <h4><a href="${pageContext.request.contextPath }/Book?type=home" >回到首页</a></h4>
</div>

    <div>
        <table border="1" width="500" align="center">
            <tr align="center">
                <td>序号</td>
                <td>书号</td>
                <td>书名</td>
                <td>作者</td>
                <td>出版社</td>
                <td>出版时间</td>
                <td>价格</td>
            </tr>





            <c:forEach items="${bookList}" var="book" varStatus="s">
                <tr align="center">
                    <td>${s.count}</td>
                    <td>${book.bookNo}</td>
                    <td>${book.bookName}</td>
                    <td>${book.author}</td>
                    <td>${book.publish}</td>
                    <td>${book.publishTime}</td>
                    <td>${book.price}</td>
                    <td><a href="${pageContext.request.contextPath}/webroot/updateBook.jsp">修改</a></td>
                    <td><a href="">删除</a></td>
                </tr>
            </c:forEach>

            <c:forEach items="${authorList}" var="book" varStatus="s">
                <tr align="center">
                    <td>${s.count}</td>
                    <td>${book.bookNo}</td>
                    <td>${book.bookName}</td>
                    <td>${book.author}</td>
                    <td>${book.publish}</td>
                    <td>${book.publishTime}</td>
                    <td>${book.price}</td>
                    <td><a href="">修改</a></td>
                    <td><a href="">删除</a></td>
                </tr>
            </c:forEach>

            <c:forEach items="${bookNameList}" var="book" varStatus="s">
                <tr align="center">
                    <td>${s.count}</td>
                    <td>${book.bookNo}</td>
                    <td>${book.bookName}</td>
                    <td>${book.author}</td>
                    <td>${book.publish}</td>
                    <td>${book.publishTime}</td>
                    <td>${book.price}</td>
                    <td><a href="">修改</a></td>
                    <td><a href="">删除</a></td>
                </tr>
            </c:forEach>

        </table>
    </div>
</body>
</html>
