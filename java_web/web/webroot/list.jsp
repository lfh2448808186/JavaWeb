<%--
  Created by IntelliJ IDEA.
  User: LFH
  Date: 2019/11/17
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>显示所有图书信息</title>
    <link rel="stylesheet" href="../resource/bootstrap-3.3.7-dist/css/bootstrap.min.css">

    <script>
        function deleteBook(bookNo) {
           <%--给用户提示--%>
            if (confirm("您确定要删除吗？")) {
                location.href="${pageContext.request.contextPath}/deleteByBookNoServlet?bookNo="+bookNo;
            }
        }
    </script>
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/webroot/addBook.jsp">添加书籍</a>
    <a href="${pageContext.request.contextPath}/webroot/deleteBook.jsp">删除书籍</a>
    <a href="${pageContext.request.contextPath}/webroot/queryAuthor.jsp">作者名查询</a>
    <a href="${pageContext.request.contextPath}/webroot/queryBookName.jsp">图书名查询</a>

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
        <%--items="${books}"--%>
        <c:forEach items="${books}" var="book" varStatus="s">
            <tr align="center">
                <td>${s.count}</td>
                <td>${book.bookNo}</td>
                <td>${book.bookName}</td>
                <td>${book.author}</td>
                <td>${book.publish}</td>
                <td>${book.publishTime}</td>
                <td>${book.price}</td>
                <td><a href="${pageContext.request.contextPath}/queryByNoServlet?no=${book.no}">修改</a></td>
                <td><a href="javascript:deleteBook(${book.bookNo});">删除</a></td>
            </tr>
        </c:forEach>
        </table>


</div>
</body>
</html>
