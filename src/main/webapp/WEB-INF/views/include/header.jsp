<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="sticky-top navbar navbar-expand-lg" style="padding-top: 0px;">
	<div class="logo">
        <a class="navbar-brand" href="/index.jsp"><img src="/resources/images/logo.png" alt=""></a>
    </div>
    <div id="nav" class="container-fluid">
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
	    </button>
	   <div class="collapse navbar-collapse" id="navbarNavDropdown">
	      <ul class="navbar-nav" style="background-color:gray;">
	         <li class="nav-item dropdown">
	            <a class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">NOTICE</a>
				<ul class="dropdown-menu" style="background-color: gray;">
					<li>
						<a class="dropdown-item" href="/notice/list.do">공지사항</a>
					</li>
					<li><a class="dropdown-item" href="/event/list.do">행사</a></li>
					<li><a class="dropdown-item" href="/newsRoom/list.do">뉴스룸</a></li>
				</ul>
	         </li>
	         <li class="nav-item" style="margin-top: 13px;">
	            <a href="#">FOOD</a>
	         </li>
	         <li class="nav-item" style="margin-top: 13px;">
	            <a href="#">HOBBY</a>
	         </li>
	         <li class="nav-item" style="margin-top: 13px;">
	            <a href="#">SECURITY</a>
	         </li>
	         <li class="nav-item" style="margin-top: 13px;">
	            <a href="/member/list.do">관리자 페이지</a>
	         </li>
	      </ul>
	   </div>
	</div>
	<div class="nav_right">
      <ul>
         <li style="margin-top: 13px;">
            <a href="#">Login</a>
         </li>
         <li style="margin-top: 13px;">
            <a href="#">Register</a>
         </li>
      </ul>
    </div>
</header>