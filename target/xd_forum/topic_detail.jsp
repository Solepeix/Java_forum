<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小滴课堂开发者论坛</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap.min.css">

    <script src="${pageContext.request.contextPath}/static/bootstrap.min.js"> </script>

    <script src="${pageContext.request.contextPath}/static/jquery.min.js"> </script>
</head>
<body>

<div class="container">
    <ul class="nav nav-tabs">
        <c:forEach items="${categoryList}" var="category">
            <li>
                <a href="${pageContext.request.contextPath}/topic?method=list&c_id=${category.id}">${category.name}</a>
            </li>

        </c:forEach>

        <c:choose>
            <c:when test="${empty loginUser}">
                <li style="float: right"> <a href="${pageContext.request.contextPath}/user/register.jsp">注册</a></li>
                <li style="float: right"> <a href="${pageContext.request.contextPath}/user/login.jsp">登录</a></li>
            </c:when>
            <c:otherwise>
                <li style="float: right"> <a href="${pageContext.request.contextPath}/user?method=logout">注销</a></li>
                <li style="float: right"> <a href="#">${loginUser.username}</a></li>
                <li style="float: right">

                    <img src="${loginUser.img}"class="img-circle"width="25px"height="25px"style="margin-top: 8.5px">
                </li>

                <li style="float: right"><a href="${pageContext.request.contextPath}/publish.jsp">发布主题</a> </li>
                <li style="float: right"><a href="${pageContext.request.contextPath}/reply.jsp?topic_id=${param.topic_id}">盖楼回复</a> </li>
            </c:otherwise>
        </c:choose>

    </ul>

    <table class="table table-striped">

        <thead>
        <tr>
            <th>标题</th>
            <th>内容</th>
            <th>作者</th>
            <th>发布时间</th>

        </tr>

        </thead>
        <tr>
            <td>${topic.title}</td>
            <td>${topic.content}</td>
            <td>${topic.username}</td>
            <td>${topic.createTime}</td>
        </tr>
    </table>


    <table class="table table-striped">

        <thead>
        <tr>
            <th>用户</th>
            <th>内容</th>
            <th>回复时间</th>
            <th>楼层</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${replyPage.list}" var="reply">
            <tr>
                <td>${reply.username}</td>
                <td>${reply.content}</td>
                <td>${reply.createTime}</td>
                <td>第 ${topic.floor} 楼</td>
            </tr>


        </c:forEach>
        </tbody>
    </table>


    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>

        <c:if test="${replyPage.totalPage>0}">
            <c:forEach var="i" begin="0" end="${replyPage.totalPage-1}" step="1">
                <li>
                    <a href="${pageContext.request.contextPath}/topic?method=findDetailById&topic_id=${param.topic_id}&page=${i+1}">${i+1}</a>
                </li>
            </c:forEach>
        </c:if>

        <li><a href="#">&raquo;</a></li>
    </ul>

</div>


</body>
</html>
