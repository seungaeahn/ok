<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.mypage.UserInfo" %>
<%@ page import="com.kh.mypage.MyPageDAO" %>
<%@ page import="com.kh.mypage.FollowList" %>

<%@ page import="com.kh.mypage.followBlobDAO" %> 
<%@ page import="playlist.PlayListDAO" %>
<%@ page import="playlist.PlayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <title>SHINee Music</title>
        <style>
    .col-md-3, .col-md-6 {
	background: transparent;
	border-style: solid;
    border-color: #DAF8FF;
	padding: 40px;
	border-radius: 5px;
	box-shadow: 0.5px 0.5px 2px 1px #eee;
	text-align: left;
	margin-left: 20px;
	margin-right: 20px;
	margin-bottom: 40px;
    }
    .white-box {
    display:inline;
    }
    .playlists {
    }
    
    
        </style>
        <link rel="stylesheet" href="./css/all.css">
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
     <div class="container" style="margin-top:30px;">
        <aside>
            <button style="margin-top: 250px;">
                <img src="images/mypageA.png" style="width:85px; padding:0;" alt="myPage Icon">
                <p><strong>My Page</strong></p>
            </button>
            <button style="margin-top: 50px;">
                <img src="images/lookaround.png" style="width:85px; padding:0;" alt="MyPlaylist Icon" onclick="location.href='playList.jsp'">
                <p><strong>My<br>Playlist</strong></p>
            </button>
            <button style="margin-top: 50px;">
                <img src="images/pixel_search.png" style="width:85px; padding:0;" alt="Search Icon" onclick="location.href='music_search.jsp'">
                <p><strong>search</strong></p>
            </button>
            
            
        </aside>
		
		
		<div style="margin: 0 auto; text-align: left;">
        <section>
        
            <div class="bluetop" style="margin-top:20px; width:1200px;  margin: 0 auto;">
                <p style="margin-top:5px;" ><img src="images/smile.png" style="height: 50px; float: left; margin-top: -17px; "><strong>My Page</strong></p>
            </div>
            <div style="width:1200px; height:30px; background-color: gray;">
                
                <article>
                    <div class="d-flex">
                        <div class="flex-shrink-0">
                        <%
                        
                       
                        
                  // 회원 정보 가져오기!!!!! 
                  //String = nickname값과 id값을 가지고 오겠다.
                  //String userIdValue = request.getParameter("user_id");
                  String id = (String) session.getAttribute("user_id");
                  
                  MyPageDAO mypageDAO = new MyPageDAO();
                  UserInfo userinfo = mypageDAO.getMember(id);
                  
                  
                 
                  
                  
                   %>
                            
                            <br>
                            <br>
                            <br>
                            <img class="profile" src="<%= userinfo.getProfile_img() %>" style="width: 200px; height: 200px;">
                             
                          
                        </div>
                        
                        
                        <div class="flex-grow-1 ms-3">
                          <h3><%= userinfo.getUserNickname() %></h3>
                          <h4><%= userinfo.getUserId() %></h4>
                          <h4><%= userinfo.getEmail() %></h4>
                      
                          <button style="margin-top: 10px; background-color: transparent"  class="btn btn-primary" onclick="location.href='modifyInfo.jsp'">
			                <img src="images/pencil.png" style="width:40px; padding:0;" alt="Modify Icon">
			             
			            </button>
			            <br>
			            <br>
			            <br>
			            <form action="DeleteUserInfoServlet" method="post" id="deleteForm">
					    <input type="hidden" name="user_id" value="<%= userinfo.getUserId() %>">
					    <button type="button" class="btn btn-default pull right" onclick="confirmAndSubmit()">SHINee Music 탈퇴하기</button>
						</form>
						
						<script>
						function confirmAndSubmit() {
						    if (confirm('정말 Shinee Nusic을 탈퇴하시겠습니까?!!')) {
						        // 사용자가 확인을 누르면 폼을 제출한다.
						        document.getElementById('deleteForm').submit();
						    } else {
						        // 사용자가 취소를 누른 경우 아무것도 하지 않는다.
						    }
						}
						</script>
                        </div>
                        
                      </div> 
                      <br><br><br><br>
             <div class="col-md-6">
            <div class="white-box">
              <div class="mb-5">
              <img class="profile" src="images/headset.gif" style="width: 80px; height: 80px;">   
                <h3>My Playlist</h3>
                <%
 				   //회원의 플레이 리스트 가져오기!!!!
                PlayListDAO playlistDAO = new PlayListDAO();
				List<PlayList> playlists = playlistDAO.getAllPlaylists();
		
				for(PlayList p : playlists){
                %>
                <div style="display: inline-block; margin: 10px;">
                    <img class="profile" src="<%= p.getImage() %>" style="width: 200px; height: 200px;">
                    <div><p><strong><%=p.getPlaylistName()%></strong></p></div>
                    
                </div>
                
                <%
                	}
                %>
                

              </div>
              
            </div>
          </div>
                      
                      
                      
          
          <br>
                            
          <div class="col-md-6">
            <div class="white-box">
              <div class="mb-5">
              <img class="profile" src="images/blueheart.gif" style="width: 80px; height: 80px;">   
                <h3>Followings</h3>
                <%
                
                
             	 //Blob 땜에 만든 followBlobDAO도 가져오기
                followBlobDAO fbDAO = new followBlobDAO();
                List<FollowList> followlists = fbDAO.getAllFollowings(id);
                
              
                
               
                for(FollowList f : followlists) {
            %>
                <div style="display: inline-block; margin: 10px;">
                    <img class="profile" src="<%= f.getProfile_img() %>" style="width: 200px; height: 200px;">
                    <div><p><strong><%= f.getUser_nickname() %></strong></p></div>
                    <div><p><strong><%= f.getFollowing_id() %></strong></p></div>
                </div>
            <%
                }
            %>

              </div>
              
            </div>
          </div>





                </article>
            </div>
        </section>
        </div>





        
       
          
          
          
          </div>
    </body>
</html>