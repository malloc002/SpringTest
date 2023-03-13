<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨 찾기 목록</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<h1>즐겨 찾기 목록</h1>
	<table class="table text-center">
		<thead>
			<tr>
				<th>No.</th>
				<th>이름</th>
				<th>주소</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="favorite" items="${favoriteList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${favorite.name }</td>
					<td>${favorite.url }</td>
					<td><button class="deleteBtn btn bg-danger text-white btn-sm" data-favorite-id="${favorite.id }">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script>
	
	$(document).ready(function(){
		
		$(".deleteBtn").on("click", function(){
			
			//삭제 대상의 id
			let id = $(this).data("favorite-id");
			
			//ajax를 통해서 delete api 호출
			$.ajax({
				type: "get"
				, url: "/ajax/delete"
				, data: {"id": id}
				, success: function(data){
					if(data.deleted)
					{
						location.reload();
					}
					else{ 
						alert("삭제 실패");
					}
				}
				, error: function(){
					alert("삭제 에러");
				}
				
			})
			
			
		});
		
	});
	
	</script>
</body>
</html>