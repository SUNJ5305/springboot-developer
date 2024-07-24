<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>블로그 글</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
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
                    <input type="text" class="form-control" placeholder="제목" id="title" value="${article.title}">
                </header>
                <section class="mb-5">
                    <textarea class="form-control h-25" rows="10" placeholder="내용" id="content">${article.content}</textarea>
                </section>
                <c:choose>
                    <c:when test="${article.id != null}">
                        <button type="button" id="modify-btn" class="btn btn-primary btn-sm">수정</button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" id="create-btn" class="btn btn-primary btn-sm">등록</button>
                    </c:otherwise>
                </c:choose>
            </article>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/article.js"></script>
</body>
</html>
