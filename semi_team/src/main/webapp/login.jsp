<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Log in</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <link rel="stylesheet" type="text/css" href="css/all.css">
        
	</head>
	<body>
        <div class="container" style="margin-top:30px;">
            <aside>
                <button style="margin-top: 250px;" >
                    <img src="images/mypageA.png" style="width:85px; padding:0;" alt="myPage Icon">
                    <p><strong>mypage</strong></p>
                </button>
                <button style="margin-top: 50px;">
                    <img src="images/lookaround.png" style="width:85px; padding:0;" alt="lookaround Icon">
                    <p><strong>my<br>Playlist</strong></p>
                </button>
                <button style="margin-top: 50px;">
                    <img src="images/pixel_search.png" style="width:85px; padding:0;" alt="Search Icon">
                    <p><strong>search</strong></p>
                </button>
            </aside>
            <section>
                <div class="bluetop" style="margin-top:20px; width:1200px;">
                    <p style="margin-top:5px">log in</p>
                </div>
                <div style="width:1200px; height:30px; background-color: gray;">
                </div>
                <article>
                    <div style="text-align: center; margin-top: 20%;">
                        <h3>Log in</h3><br>
                        <form action="LoginServlet" method="post">
	                        <input type="text" id="user_id" name="user_id" placeholder="ID" style="width:200px; height: 30px; margin-bottom:10px; border-style:none;"><br>
	                        <input type="password" id="user_password" name="user_password" placeholder="user_password" style="width:200px; height: 30px; margin-bottom:15px; border-style:none;"><br>
	                    	<input type="submit" value="로그인" style="background-color:blue; color:white; width:80px; height: 30px; border-style:none;">
                    	</form><br>
                    		<a href="SHINeeRegister.jsp" style="font-size:xsmall; margin-top:10px;">계정이 없으신가요?</a> <!-- 회원가입 페이지로 이동 -->
                    </div>
                </article>
            </section>
        </div><!--container-->
        <%
			//로그인이 실패했을 상황 가정 (로그인 실패시 보일 함수 호출)
			String loginError = (String)request.getAttribute("loginError");
		
			if(loginError != null){
		%>
			<script>
				displayLoginFail();
			</script>
		<%
			} //if(loginError != null)
		%>
	</body>
</html>