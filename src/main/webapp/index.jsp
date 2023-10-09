<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="/resources/css/reset.css">
      <link rel="stylesheet" href="/resources/css/index.css">
      <script src="https://kit.fontawesome.com/dbb376a4c5.js" crossorigin="anonymous"></script>
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
      <link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>
      <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	  <script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
      <title>Special Alone</title>
   </head>
   <body>
      <header class="navbar navbar-expand navbar-dark bg-dark bd-navbar sticky-top">
		  <a class="navbar-brand" href="#">MSG</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active"><a class="nav-link" href="#">홈</a></li>
		      <li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
		      <li class="nav-item"><a class="nav-link" href="#">질문게시판</a></li>
		    </ul>
		  </div>
		</header>

		<div class="container-fluid">
		  <div class="row flex-nowrap">
		    <div class="col-3 bd-sidebar">
		      <div class="bd-sidebar-body">
		        <ul class="nav">
		          <li><a href="/moim/moimSide.do">회의방</a></li>
		          <li><a href="/moim/workingSchedule.do">출결 관리</a></li>
		          <li><a>대화방 추가+</a></li>
		        </ul>
		        <br>
		      </div>
		      <div class='bd-sidebar-footer'>
		        참가자
		        <br>
		        jys <button>알림 문자</button>
		      </div>
		    </div>
		    <main class="col-9 py-md-3 pl-md-5 bd-content" role="main">
		      <h1>Group A</h1>
		      <hr>
		      <div class="mainFlex">
			      <div class="profile"></div>
			      <div class="calrender"></div>
			      <div class="right">
				      <div class="workingTime">
				      	<button>출근</button>
				      	<button>퇴근</button>
				      </div>
				      <div class="calDetail"></div>
				  </div>
			  </div>
		    </main>
		  </div>
		</div>

   </body>
</html>