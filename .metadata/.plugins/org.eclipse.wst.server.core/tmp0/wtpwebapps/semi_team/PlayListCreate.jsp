<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "search.SearchDAO" %>
<%@ page import = "search.Music_info" %>
<%@ page import = "search.Playlist_info" %>
<%@ page import = "playlist.PlayList" %>
<%@ page import = "playlist.PlayListDAO" %>
<%@ page import="com.kh.mypage.UserInfo" %>
<%@ page import="com.kh.mypage.MyPageDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
    <head>
        <title>SHINee Music_create</title>
        <link rel="stylesheet" href="all.css">
        <link rel="stylesheet" href="main.css">
        
    </head>
    <body>
        <div class="container" style="margin-top:30px;">
            <aside>
            <button style="margin-top: 250px;">
                <img src="images/mypageA.png" style="width:85px; padding:0;" alt="myPage Icon" onclick="location.href='mypageMain.jsp'">
                <p><strong>My Page</strong></p>
            </button>
            <button style="margin-top: 50px;">
                <img src="images/lookaround.png" style="width:85px; padding:0;" alt="MyPlaylist Icon" >
                <p><strong>My<br>Playlist</strong></p>
            </button>
            <button style="margin-top: 50px;">
                <img src="images/pixel_search.png" style="width:85px; padding:0;" alt="Search Icon" onclick="location.href='music_search.jsp'">
                <p><strong>search</strong></p>
            </button>
            
            
        </aside>
        
            <section>
            <%
                        
                       
                        
                  // 회원 정보 가져오기!!!!! 
                  //String = nickname값과 id값을 가지고 오겠다.
                  //String userIdValue = request.getParameter("user_id");
                  String id = (String) session.getAttribute("user_id");
                  MyPageDAO mypageDAO = new MyPageDAO();
                  UserInfo userinfo = mypageDAO.getMember(id);
                  
                  
                  
                 
                  
                  
                   %>
                <div class="bluetop" style="margin-top:20px; width:1200px;">
                    <p style="margin-top:5px;" ><img src="./img/Save.png" style="height: 28px; float: left; margin-top: -8px; "><strong>My_PlayList</strong></p>
                </div>
                <div style="width:1200px; height:30px; background-color: gray;">
                <button id="backToList"><a href="playList.jsp">Back To PlayList</a></button>
                
                </div>
              
                <article id="create">
                  
                <div style="text-align: center; margin-top: 5%;">
           		<form action="UploadServlet" method="post" enctype="multipart/form-data">  
           		
                        <label for = "PlaylistID"></label>
                        <input name="user_id" type="text" value="<%= userinfo.getUserId() %>" readonly="readonly">
                        <label for = "title" style="font-size: 20px;">PlayList_Name : </label> 
                        <input type="text" name = "title" required>
                      
                        <br><br><br><br><br>
                        <p style="text-align: center;">플레이리스트 대표사진 </p>
                        
                       <br>
                        <label for ="image">이미지 : </label>
						<input type="file" name="image" id="image" required><br>
                       
                        
                        <br>
                        <button id = "saveButton" type = "submit" style="margin-top: 20%;">생성하기</button>  
                   </form>
                    </div>
                </article>
            
            </section>
             <aside>
        
		 <%
	 	//만약 mno값이 존재할 경우 빈(null)값이 아닐경우
	 	
	 	if(session.getAttribute("user_id") != null){
	 %>
	 <button id="logoutButton" style="margin-top: 800px; margin-left: 1450px" onclick="location.href='logout.jsp'">
         <img src="images/로그아웃.png" style="width:85px; padding:0;" alt="Logout Icon" >
          <p style="margin-top: 7px;"><strong>Logout</strong></p>
     </button>
	 	
	 <%
	 	}
	
	%>
        </aside>

        </div><!--container-->
        <script>
          
            
            //생성하기 버튼 스크립트
            document.getElementById("saveButton").addEventListener("click", function(){
                const playlistContent = document.getElementById("ListPost").value;
                if(playlistContent.trim() !==""){
                    const timestamp=new Date().getTime();
                    const ListPost ={
                        id: timestamp,
                        content: playlistContent
                    };
                    const savedPosts = JSON.parse(localStorage.getItem("ListPosts"))||[];
                    savedPosts.push(ListPost);
                    localStorage.setItem("ListPosts", JSON.stringify(savedPosts));

                    alert("플레이리스트가 생성되었습니다.");

                    window.location.href="playList.jsp";
                }else{
                    alert("플레이리스트 내용을 다시 입력해주세요.");
                }
            });
        	//검색버튼 누르면 검색 창으로 이동 (기본 음악검색)
			document.getElementById("gotoSearchButton").addEventListener("click",()=>{
				window.location.href = "music_search.jsp";
			});
			
			//마이페이지 버튼 누르면 이동
			document.getElementById("gotoMyPageButton").addEventListener("click",()=>{
				window.location.href = "mypageMain.jsp";
			});
			
			//마이플레이리스트 버튼
			document.getElementById("gotoMyPlaylistButton").addEventListener("click",()=>{
				window.location.href = "playList.jsp";
			});
			
			//검색 카테고리 이동 버튼
			document.getElementById("music_searchButton").addEventListener("click",()=>{
				window.location.href = "music_search.jsp";
			});
			
			document.getElementById("playlist_searchButton").addEventListener("click",()=>{
				window.location.href = "playlist_search.jsp";
			});
			
			document.getElementById("user_searchButton").addEventListener("click",()=>{
				window.location.href = "user_search.jsp";
			});
        </script>
    </body>
</html>