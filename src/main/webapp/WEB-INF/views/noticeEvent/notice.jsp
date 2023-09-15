<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/resources/css/reset.css">
	    <link rel="stylesheet" href="/resources/css/header.css">
	    <link rel="stylesheet" href="/resources/css/footer.css">
	    <link rel="stylesheet" href="/resources/css/index.css">
	    <link rel="stylesheet" href="/resources/css/noticeEvent/notice.css">
	    <script src="https://kit.fontawesome.com/dbb376a4c5.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<title>공지사항</title>
	</head>
	<body>
		<!-- header -->
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <!-- main -->
        <main>
        	<div id="main_left">
                <table>
                    <tr>
                        <td style="background-color: black;"><a href="/notice/list.do" style="color:white;">공지사항</a></td>
                    </tr>
                    <tr>
                        <td><a href="/event/list.do">행사</a></td>
                    </tr>
                    <tr>
                        <td><a href="/newsRoom/list.do">뉴스룸</a></td>
                    </tr>
                </table>
            </div>
            <div id="main_middle">
                <h2><b>공지 사항</b></h2>
                <hr>
                <div class="search">
                    <form action="/notice/search.do" method="get">
						<input type="text" name="searchKeyword" placeholder="제목을 입력하세요." style="width:30%">
						<button id="findProduct" type="submit"><i class="fa-solid fa-magnifying-glass" style="color: blue;"></i></button>
					</form>	
	                <%-- <c:if test="${memberId eq 'admin' }"> --%>
	                <button class="insertNotice" onclick="javascript: location.href='/noticeEvent/write.do'" style="margin-top:-30px;">공지사항 등록</button>
	                <%-- </c:if> --%>
                </div>
                <table class="table table-striped table-hover">
                	<colgroup>
						<col width="10%"></col>
						<col width="50%"></col>
						<col width="20%"></col>
					</colgroup>
                    <thead>
                        <tr style="text-align:center">
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성일</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
						<c:forEach var="notice" items="${nList}">
							<tr>
								<td style="text-align:center">${notice.boardNo }</td>
								<td><a href="/noticeEvent/detail.do?boardNo=${notice.boardNo }">${notice.boardTitle }</a></td>
								<td style="text-align:center"><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${notice.bCreateDate }"/></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr align="center">
							<td colspan="3">
							<c:if test="${pInfo.currentPage != 1 }">
								<a href="/notice/list.do?currentPage=${pInfo.currentPage - 1 }">&lt;</a>&nbsp;
							</c:if>
							<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
								<c:url var="pageUrl" value="/notice/list.do">
									<c:param name="currentPage" value="${p }"></c:param>
								</c:url>
								<c:if test="${pInfo.currentPage == p }"><a href="${pageUrl }" style="color:black;">${p }</a>&nbsp;</c:if>
								<c:if test="${pInfo.currentPage != p }"><a href="${pageUrl }">${p }</a>&nbsp;</c:if>
							</c:forEach>
							<c:if test="${pInfo.currentPage ne pInfo.naviTotalCount }">
								<a href="/notice/list.do?currentPage=${pInfo.currentPage + 1 }">&gt;</a>
							</c:if>
							</td>
						</tr>
					</tfoot>
                </table>
            </div>
        	<div id="main_right"></div>
        </main>
		<!-- footer -->
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	</body>
</html>