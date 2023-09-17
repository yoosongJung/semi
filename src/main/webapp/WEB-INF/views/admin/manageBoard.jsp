<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<link rel="stylesheet" href="/resources/css/reset.css">
	    <link rel="stylesheet" href="/resources/css/header.css">
	    <link rel="stylesheet" href="/resources/css/footer.css">
	    <link rel="stylesheet" href="/resources/css/index.css">
	    <link rel="stylesheet" href="/resources/css/admin/manageBoard.css">
		<script src="https://kit.fontawesome.com/dbb376a4c5.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<title>게시글/리뷰 관리</title>
	</head>
	<body>
		<!-- header -->
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <!-- main -->
        <main>
        	<div id="main_left">
                <table>
                    <tr>
                        <td><a href="/member/list.do">회원관리</a></td>
                    </tr>
                    <tr>
                        <td><a href="/singo/list.do">신고회원</a></td>
                    </tr>
                    <tr>
                        <td style="background-color: black;"><a href="/manageBoard/list.do" style="color:white;">게시글/리뷰 관리</a></td>
                    </tr>
                    <tr>
                        <td><a href="#">댓글 관리</a></td>
                    </tr>
                </table>
            </div>
            <div id="main_middle">
            	<h2><b>게시글/리뷰 관리</b></h2>
                <hr>
                <div class="search">
                	<select>
                		<option>안전 상품</option>
                		<option>안전 리뷰</option>
                		<option>취미 게시글</option>
                		<option>음식 추천</option>
                		<option>음식 포토 리뷰</option>
                		<option>식당 추천</option>
                		<option>식당 리뷰</option>
                	</select>
                	<br><hr>
                    <form action="/singo/search.do" method="get">
						<input type="text" name="searchKeyword" placeholder="아이디를 입력하세요." style="width:30%">
						<button id="findProduct" type="submit"><i class="fa-solid fa-magnifying-glass" style="color: blue;"></i></button>
					</form>	
                </div>
            </div>
        	<div id="main_right"></div>
        </main>
        <!-- footer -->
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        <script>
        	
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	</body>	
</html>