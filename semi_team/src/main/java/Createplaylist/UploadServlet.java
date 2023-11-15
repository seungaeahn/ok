package Createplaylist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(
		fileSizeThreshold =1024*1024,//占쏙옙占싹듸옙占쏙옙占싶몌옙 占쏙옙크占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占싹깍옙 占쏙옙占쏙옙 占쌨모리울옙 占쏙옙占쏙옙占실댐옙 占쌍댐옙크占쏙옙(1MB)
		maxFileSize = 1024*1024 *5,//占쏙옙占싸듸옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌍댐옙 크占쏙옙(5MB)
		maxRequestSize =1024*1024*10,//占쏙옙청 占쏙옙占쏙옙占쏙옙占쏙옙 占쌍댐옙 크占쏙옙(10MB)
		location="/org"//占쏙옙占쏙옙占쏙옙 占쏙옙크占쏙옙 占쏙옙占쏙옙占� 占쌈쏙옙 占쏙옙占싶몌옙
		)
public class UploadServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcURL="jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUser ="shinee";
		String jdbcPW = "shinee";
		
		String title = request.getParameter("title");
		String user_id = "im2ho"; //占쌈시뤄옙 占쏙옙占쏙옙占쏙옙 占쌍억옙占�. 占싸깍옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌨아울옙占쏙옙 占쏙옙占실울옙占쏙옙 占쏙옙 占쏙옙占싶억옙占쏙옙
		Part imagePart = request.getPart("image");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPW);
			String sql = "INSERT INTO playlist_info(playlist_id,playlist_name,user_id,image)"+
			"VALUES(playlist_seq.nextval,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, title);
			ps.setString(2, user_id);
			ps.setBinaryStream(3, imagePart.getInputStream(),(int) imagePart.getSize());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("playList.jsp");
	}

}