/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.82
 * Generated at: 2023-11-16 08:23:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import playlist.PlayList;
import playlist.PlayListDAO;
import search.SearchDAO;
import search.Music_info;
import search.Playlist_info;

public final class playList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("playlist.PlayListDAO");
    _jspx_imports_classes.add("search.Playlist_info");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("search.SearchDAO");
    _jspx_imports_classes.add("playlist.PlayList");
    _jspx_imports_classes.add("search.Music_info");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    ");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>플레이리스트 목록</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/all.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/하은언니.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\" style=\"margin-top:30px;\">\r\n");
      out.write("            <aside>\r\n");
      out.write("            <button style=\"margin-top: 250px;\">\r\n");
      out.write("                <img src=\"images/mypageA.png\" style=\"width:85px; padding:0;\" alt=\"myPage Icon\" onclick=\"location.href='mypageMain.jsp'\">\r\n");
      out.write("                <p><strong>My Page</strong></p>\r\n");
      out.write("            </button>\r\n");
      out.write("            <button style=\"margin-top: 50px;\">\r\n");
      out.write("                <img src=\"images/lookaround.png\" style=\"width:85px; padding:0;\" alt=\"MyPlaylist Icon\" >\r\n");
      out.write("                <p><strong>My<br>Playlist</strong></p>\r\n");
      out.write("            </button>\r\n");
      out.write("            <button style=\"margin-top: 50px;\">\r\n");
      out.write("                <img src=\"images/pixel_search.png\" style=\"width:85px; padding:0;\" alt=\"Search Icon\" onclick=\"location.href='music_search.jsp'\">\r\n");
      out.write("                <p><strong>search</strong></p>\r\n");
      out.write("            </button>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </aside>\r\n");
      out.write("       \r\n");
      out.write("            <section>\r\n");
      out.write("                <div class=\"bluetop\" style=\"margin-top:20px; width:1200px;\">\r\n");
      out.write("                    <p style=\"margin-top:5px;\" ><img src=\"images/Save.png\" style=\"height: 28px; float: left; margin-top: -8px; \"><strong>My_PlayList</strong></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div style=\"width:1200px; height:30px; background-color: gray;\">\r\n");
      out.write("                <button id=\"new\"><a href=\"PlayListCreate.jsp\">NEW</a></button>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("      <article id=\"articleP\">\r\n");
      out.write("                <div style=\"text-align: center; margin-top: 0%;\">\r\n");
      out.write("                </div>\r\n");
      out.write("         \r\n");
      out.write("                <table>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th></th>\r\n");
      out.write("			<th></th>\r\n");
      out.write("			<th></th>\r\n");
      out.write("			<th></th>\r\n");
      out.write("			\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("	");

	 String id_3 = (String) session.getAttribute("user_id");
		PlayListDAO playlistDAO = new PlayListDAO();
		List<PlayList> playlists = playlistDAO.getAllPlaylists(id_3);
		
		for(PlayList p : playlists){
			
      out.write("\r\n");
      out.write("			<form action=\"DeleteServlet\" method=\"post\">\r\n");
      out.write("			<tr>\r\n");
      out.write("			<div class=\"window\" style=\"width: 600px; height:200px; float: left; margin-left: 20%; margin-bottom: 5px; margin-top:10px;\">\r\n");
      out.write("			<div class=\"title-bar\">\r\n");
      out.write("				<div class=\"title-bar-text\" style=\"margin-left:5px;\">\r\n");
      out.write("				 MY_PlayList_♡ \r\n");
      out.write("				<td>");
      out.print(p.getPlaylistId() );
      out.write("</td>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"title-bar-controls\">\r\n");
      out.write("				<input type=\"hidden\" name=\"playlistId\" value=\"");
      out.print( p.getPlaylistId() );
      out.write("\">\r\n");
      out.write("				<button type=\"submit\" class=\"btn btn-default pull right\"  onclick=\"DeleteCheck()\">X</button>\r\n");
      out.write("										\r\n");
      out.write("										\r\n");
      out.write("				</div></div>\r\n");
      out.write("	\r\n");
      out.write("				<td></td>\r\n");
      out.write("\r\n");
      out.write("				<td><a href=\"playListDetail.jsp?playlistId=");
      out.print(p.getPlaylistId());
      out.write("\"><img src=\"");
      out.print(p.getImage());
      out.write("\"style=\"width : 150px; height: 150px; margin-left:10px; margin-top:10px; border: 3px inset lightgray;\"></a></td>\r\n");
      out.write("				\r\n");
      out.write("				<td>\r\n");
      out.write("				<div style=\"float:right; width: 300px; text-align: left; margin-right:100px; \">\r\n");
      out.write("				<div style=\"background-color:white; margin-top:20px; padding-right: 20px; width:300px; height: 22px; border: 2px inset lightgray;\">\r\n");
      out.write("				<p style=\"margin-left: 30px; margin-top:1px;\">");
      out.print(p.getPlaylistName());
      out.write("</p></div></div>\r\n");
      out.write("				</td>\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("			</tr>\r\n");
      out.write("			<br>\r\n");
      out.write("			</form>\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("			");

			
		}
	
	
      out.write("\r\n");
      out.write("                </article>\r\n");
      out.write("                \r\n");
      out.write("                </section>\r\n");
      out.write("                     <aside>\r\n");
      out.write("        \r\n");
      out.write("		 ");

	 	//만약 mno값이 존재할 경우 빈(null)값이 아닐경우
	 	
	 	if(session.getAttribute("user_id") != null){
	 
      out.write("\r\n");
      out.write("	 <button id=\"logoutButton\" style=\"margin-top: 800px; margin-left: 1450px\" onclick=\"location.href='logout.jsp'\">\r\n");
      out.write("         <img src=\"images/로그아웃.png\" style=\"width:85px; padding:0;\" alt=\"Logout Icon\" >\r\n");
      out.write("          <p style=\"margin-top: 7px;\"><strong>Logout</strong></p>\r\n");
      out.write("     </button>\r\n");
      out.write("	 	\r\n");
      out.write("	 ");

	 	}
	
	
      out.write("\r\n");
      out.write("        </aside>\r\n");
      out.write("	\r\n");
      out.write("	 <script>\r\n");
      out.write("            const List = document.getElementById(\"List\");\r\n");
      out.write("            const savedPosts = JSON.parse(localStorage.getItem(\"ListPosts\")) || [];\r\n");
      out.write("\r\n");
      out.write("            savedPosts.forEach(post => {\r\n");
      out.write("                const listItem = document.createElement(\"li\");\r\n");
      out.write("                listItem.textContent = post.content;\r\n");
      out.write("                List.appendChild(listItem);\r\n");
      out.write("  \r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            document.getElementById(\"new\").addEventListener(\"click\",function(){\r\n");
      out.write("                window.location.href=\"PlayListCreate.jsp\";\r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
      out.write("          \r\n");
      out.write("            \r\n");
      out.write("			//검색버튼 누르면 검색 창으로 이동 (기본 음악검색)\r\n");
      out.write("			document.getElementById(\"gotoSearchButton\").addEventListener(\"click\",()=>{\r\n");
      out.write("				window.location.href = \"music_search.jsp\";\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			//마이페이지 버튼 누르면 이동\r\n");
      out.write("			document.getElementById(\"gotoMyPageButton\").addEventListener(\"click\",()=>{\r\n");
      out.write("				window.location.href = \"mypageMain.jsp\";\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			//마이플레이리스트 버튼\r\n");
      out.write("			document.getElementById(\"gotoMyPlaylistButton\").addEventListener(\"click\",()=>{\r\n");
      out.write("				window.location.href = \"playList.jsp\";\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			//검색 카테고리 이동 버튼\r\n");
      out.write("			document.getElementById(\"music_searchButton\").addEventListener(\"click\",()=>{\r\n");
      out.write("				window.location.href = \"music_search.jsp\";\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			document.getElementById(\"playlist_searchButton\").addEventListener(\"click\",()=>{\r\n");
      out.write("				window.location.href = \"playlist_search.jsp\";\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			document.getElementById(\"user_searchButton\").addEventListener(\"click\",()=>{\r\n");
      out.write("				window.location.href = \"user_search.jsp\";\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			function DeleteCheck(){\r\n");
      out.write("				if(!confirm(\"이 플레이리스트를 삭제 하시겠습니까?\")){\r\n");
      out.write("					event.preventDefault();\r\n");
      out.write("					return false;\r\n");
      out.write("				}else{\r\n");
      out.write("					\r\n");
      out.write("					alert(\"선택하신 플레이리스트가 삭제 되었습니다.\")\r\n");
      out.write("					return true;\r\n");
      out.write("					\r\n");
      out.write("					/*\r\n");
      out.write("					var btn = document.getElementsByClassName(\"btn btn-default pull right\");\r\n");
      out.write("					btn.submit();  이건 안써도됨\r\n");
      out.write("					*/\r\n");
      out.write("				};\r\n");
      out.write("        </script>\r\n");
      out.write("       \r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
