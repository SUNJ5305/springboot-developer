<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="p-5 mb-5 text-center bg-light">
    <h1 class="mb-3">My Blog</h1>
    <h4 class="mb-3">블로그에 오신 것을 환영합니다.</h4>
</div>

<div class="container">
    <button type="button" id="create-btn"
            onclick="location.href='${pageContext.request.contextPath}/new-article'"
            class="btn btn-secondary btn-sm mb-3">글 등록</button>
    <button type="button"
            onclick="location.href='${pageContext.request.contextPath}/admin'"
            class="btn btn-secondary btn-sm mb-3">관리자페이지</button>

    <c:forEach var="item" items="${articles}">
        <div class="card">
            <div class="card-header">${item.id}</div>
            <div class="card-body">
                <h5 class="card-title">${item.title}</h5>
                <p class="card-text">${item.content}</p>
                <a href="${pageContext.request.contextPath}/articles/${item.id}" class="btn btn-primary">보러 가기</a>
            </div>
        </div>
        <br>
    </c:forEach>
    <button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/logout'">로그아웃</button>
</div>
<script src="${pageContext.request.contextPath}/js/article.js"></script>
</body>
</html>
