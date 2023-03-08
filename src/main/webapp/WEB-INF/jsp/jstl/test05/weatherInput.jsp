<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력</title>

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
				<h2 class="ml-4">날씨 입력</h2>
				
				<form method="get" action="/jstl/add">
					<div class="p-5">
						<div class="d-flex">
							<label class="mr-2">날짜</label><input type="text" class="form-control col-3 mr-5" name="date">
							<label class="mr-2">날씨</label>
							<select class="form-control col-2 mr-5" name="weather">
								<option value="맑음">맑음</option>
								<option value="구름조금">구름조금</option>
								<option value="흐림">흐림</option>
								<option value="비">비</option>
							</select>
							<label class="mr-2">미세먼지</label>
							<select class="form-control col-2" name="microDust">
								<option value="좋음">좋음</option>
								<option value="보통">보통</option>
								<option value="나쁨">나쁨</option>
								<option value="최악">최악</option>
							</select>
						</div>
						<div class="d-flex mt-5">
							<div class="input-group mb-3">
								<label class="mr-2">기온</label>
								<input type="text" class="form-control col-7">
								<div class="input-group-append">
									<span class="input-group-text" id="basic-addon2">&#8451</span>
								</div>
							</div>
							<div class="input-group mb-3 mr-4">
								<label class="mr-2">강수량</label>
								<input type="text" class="form-control col-7">
								<div class="input-group-append">
									<span class="input-group-text" id="basic-addon2">mm</span>
								</div>
							</div>
							<div class="input-group mb-3">
								<label class="mr-2">풍속</label>
								<input type="text"  class="form-control col-7">
								<div class="input-group-append">
									<span class="input-group-text" id="basic-addon2">km/h</span>
								</div>
							</div>
						</div>
						<button class="btn bg-success text-white d-flex justify-content-end">저장</button>
						
					</div>
				</form>
					
				
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