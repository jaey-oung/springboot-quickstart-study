<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta content="text/html; charset=UTF-8">
    <title>글 목록</title>
    <style>
        body {
            text-align: center;
            font-family: sans-serif;
        }
        table {
            border-collapse: collapse;
            width: 700px;
            margin: 0 auto;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
        }
        th {
            background-color: orange;
        }
        td.title {
            text-align: left;
        }
        a {
            text-decoration: none;
            color: #0366d6;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>게시글 목록</h1>
<table>
    <thead>
    <tr>
        <th width="100">번호</th>
        <th width="200">제목</th>
        <th width="150">작성자</th>
        <th width="150">등록일</th>
        <th width="100">조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="board" items="${boardList}">
        <tr>
            <td>${board.seq}</td>
            <td class="title">
                <a href="getBoard?seq=${board.seq}">${board.title}</a>
            </td>
            <td>${board.writer}</td>
            <td><fmt:formatDate value="${board.createDate}" pattern="yyyy-MM-dd"/></td>
            <td>${board.cnt}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="insertBoard">새글 등록</a>
</body>
</html>