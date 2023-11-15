<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.kh.mypage.UserInfo" %>
<%@ page import="com.kh.mypage.MyPageDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <title>SHINee Music</title>
        <style>
    .white-box {
	background: white;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0.5px 0.5px 2px 1px #eee;
    }
        </style>
        <link rel="stylesheet" href="./css/all.css">
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <aside>
            <button style="margin-top: 250px;">
                <img src="mypage.png" style="width:85px; padding:0;" alt="myPage Icon">
                <p><strong>My Page</strong></p>
            </button>
            <button style="margin-top: 50px;">
                <img src="lookaround.png" style="width:85px; padding:0;" alt="MyPlaylist Icon">
                <p><strong>My<br>Playlist</strong></p>
            </button>
            <button style="margin-top: 50px;">
                <img src="pixel_search.png" style="width:85px; padding:0;" alt="Search Icon">
                <p><strong>search</strong></p>
            </button>
            
            
        </aside>

        <section>
            <div class="bluetop" style="margin-top:20px; width:1200px;">
                <p style="margin-top:5px;" ><img src="smile.png" style="height: 50px; float: left; margin-top: -17px; "><strong>My Page</strong></p>
            </div>
            <div style="width:1200px; height:30px; background-color: gray;">
                
                <article>
                    <div class="d-flex">
                        <div class="flex-shrink-0">
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                              <img class="profile" src="./img/루피.jpg" style="width: 200px; height: 200px;">    
                          
                        </div>
                        
                        <div class="flex-grow-1 ms-3">
                          <h3>로그인 후 이용해주세요.</h3>
                          
                          
                        </div>
                        
                      </div> 
                      <br><br>
          <div class="col-md-3">
            <div class="white-box">
              <h2>My Playlist</h2>
              <p>로그인 후 이용해주세요.</p>
            </div>
          </div>
          <br><br>
          <div class="col-md-6">
            <div class="white-box">
              <div class="mb-5">
                <h2>Followings</h2>
                <p>
                로그인 후 이용해주세요.
                </p>
              </div>
              
            </div>
          </div>





                </article>
            </div>
        </section>
        





        
       
          
          
          
          
    </body>
    </html>