<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과거 날씨</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/style.css" type="text/css">

</head>
<body>
	<div id="wrap">
		<div class="d-flex">
			<div class="left bg-info">
				<header class="d-flex justify-content-center align-items-center">
					<img class="mr-3" width=100 src="https://www.kma.go.kr/kma/resources/images/sub/sig2.png">
				</header>
				<nav class="menu">
					<ul class="navbar-nav ml-2 mt-2">
						<li class="nav-item"><a class="nav-link text-white font-weight-bold" href="">날씨</a></li>
						<li class="nav-item"><a class="nav-link text-white font-weight-bold" href="">날씨입력</a></li>
						<li class="nav-item"><a class="nav-link text-white font-weight-bold" href="">테마날씨</a></li>
						<li class="nav-item"><a class="nav-link text-white font-weight-bold" href="">관측 기후</a></li>
					</ul>
				</nav>
			</div>
			<section class="contents p-4">
				<h2 class="ml-4">과거 날씨</h2>
				<table class="table ml-4 text-center">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="weather" items="${weatherHistory }" >
							<tr>
								<td><fmt:formatDate value="${weather.date }" pattern="yyyy년 M월 d일" />
								<c:choose>
									<c:when test="${weather.weather eq '비' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg"></td>
									</c:when>
									<c:when test="${weather.weather eq '맑음' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg"></td>
									</c:when>
									<c:when test="${weather.weather eq '구름조금' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg"></td>
									</c:when>
									<c:when test="${weather.weather eq '흐림' }">
										<td><img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg"></td>
									</c:when>
									<c:otherwise>
										${weather.weather }
									</c:otherwise>
								</c:choose>
								<td>${weather.temperatures }&#8451</td>
								<td>${weather.precipitation }mm</td>
								<td>${weather.microDust }</td>
								<td>${weather.windSpeed }km/h</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</section>
		</div>
		<footer class="d-flex">
			<div class="logo d-flex justify-content-center align-items-center">
				<img width=150 src="https://www.weather.go.kr/plus/resources/image/foot_logo.png">
			</div>
			<div class="copyright">
				<div class="small text-secondary m-3">
					(07062) 서울시 동작구 여의대방로16길 61<br>
					Copyright@2020 KMA. All Rights RESERVED.
				</div>
			</div>
		</footer>
	</div>
</body>
</html>