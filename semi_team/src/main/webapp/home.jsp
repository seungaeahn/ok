<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- 로그아웃 상태에서 처음 접속 화면 -->
		<title>SHINee Music Home</title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
        <link rel="stylesheet" type="text/css" href="css/all.css">
	</head>
	<body>
		<%
			//user_id 값이 존재할 경우
			if(session.getAttribute("user_id") != null){
		%>
			<h3>로그인 상태에서 보일 창을 만들겟어요</h3>
			<p>myplaylist 페이지로 자동 연결할지도</p>
			<div class="container" style="margin-top:30px;">
	            <aside>
	                <button style="margin-top: 250px;" onclick="location.href='mypageMain.jsp'">
	                    <img src="img/mypage.png" style="width:85px; padding:0;" alt="myPage Icon">
	                    <p><strong>mypage</strong></p>
	                </button>
	                <button style="margin-top: 50px;">
	                    <img src="img/lookaround.png" style="width:85px; padding:0;" alt="lookaround Icon">
	                    <p><strong>my<br>Playlist</strong></p>
	                </button>
	                <button id="gotoSearchButton" style="margin-top: 50px;" onclick="location.href='music_search.jsp'">
	                    <img src="img/pixel_search.png" style="width:85px; padding:0;" alt="Search Icon">
	                    <p><strong>search</strong></p>
	                </button>
	            </aside>
	            <section>
	                <div class="bluetop" style="margin-top:20px; width:1200px;">
	                    <p style="margin-top:5px">Update My Info</p>
	                </div>
	                <div style="width:1200px; height:30px; background-color: gray;">
	                </div>
	                <article>
	                    <div style="text-align: center; margin-top:8%">
	                        <img src="img/dino.gif" alt="샤이니뮤직 로고" style="width:300px;">
	                    </div>
	              </article>
	            </section>
	        </div>
		<%
			} else {
				//로그아웃 상태에서 보일 페이지 내용
		%>
	        <div class="container" style="margin-top:30px;">
	            <aside>
	                <button style="margin-top: 250px;">
	                    <img src="img/mypage.png" style="width:85px; padding:0;" alt="myPage Icon">
	                    <p><strong>mypage</strong></p>
	                </button>
	                <button style="margin-top: 50px;">
	                    <img src="img/lookaround.png" style="width:85px; padding:0;" alt="lookaround Icon">
	                    <p><strong>my<br>Playlist</strong></p>
	                </button>
	                <button id="gotoSearchButton" style="margin-top: 50px;">
	                    <img src="img/pixel_search.png" style="width:85px; padding:0;" alt="Search Icon">
	                    <p><strong>search</strong></p>
	                </button>
	            </aside>
	            <section>
	                <div class="bluetop" style="margin-top:20px; width:1200px;">
	                    <p style="margin-top:5px">Update My Info</p>
	                </div>
	                <div style="width:1200px; height:30px; background-color: gray;">
	                </div>
	                <article>
	                    <div style="text-align: center; margin-top:8%">
	                        <img src="img/dino.gif" alt="샤이니뮤직 로고" style="width:300px;">
	                    </div>
	                    <div style="text-align: center; margin-top: 20px;">
	                        <h3>로그인 후 이용해주세요</h3><br>
	                        <button id="gotoLoginButton" style="width: 200px; padding: 10px; background-color: blue; color:white;">로그인 하기</button><br>
	                        <button id="joinButton" style="width: 200px; padding: 10px; margin-top: 5px;">회원가입 하기</button>
	                    </div>
	                </article>
	            </section>
	        </div><!--container-->			
		<%
			} //else (로그아웃 상태에서 보여질 창)
		%>
		<script>
			//로그인하기 버튼 누르면 로그인 창으로 이동
			document.getElementById("gotoLoginButton").addEventListener("click",()=>{
				window.location.href = "login.jsp";
			});
			//검색버튼 누르면 검색 창으로 이동
			document.getElementById("gotoSearchButton").addEventListener("click",()=>{
				window.location.href = "search.jsp";
			})
		</script>
	</body>
	</html>