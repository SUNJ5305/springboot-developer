<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>블로그 글</title>
    <link rel="stylesheet" href="http://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="p-5 mb-5 text-center bg-light">
    <h1 class="mb-3">My Blog</h1>
    <h4 class="mb-3">블로그에 오신 것을 환영합니다.</h4>
</div>

<div class="container mt-5">
    <div class="row">
        <div class="col-lg-8">
            <article>
                <input type="hidden" id="article-id" value="${article.id}">
                <header class="mb-4">
                    <h1 class="fw-bolder mb-1">${article.title}</h1>
                    <div class="text-muted fst-italic mb-2">
                        <fmt:formatDate value="${article.createdAt}" pattern="yyyy-MM-dd HH:mm" />
                    </div>
                </header>
                <section class="mb-5">
                    <p class="fs-5 mb-4">${article.content}</p>
                </section>
                <button type="button" id="modify-btn"
                        onclick="location.href='${pageContext.request.contextPath}/new-article?id=${article.id}'" class="btn btn-primary btn-sm">수정</button>
                <button type="button" id="delete-btn" class="btn btn-secondary btn-sm">삭제</button>
            </article>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/article.js"></script>
</body>
</html>
