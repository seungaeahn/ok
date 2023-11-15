
package Createplaylist;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.BLOB;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcURL="jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUser ="shinee";
		String jdbcPW = "shinee";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPW);
			
			//sql
			String sql = "SELECT image From playlist_info";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Blob Image = rs.getBlob("image");
				if (Image != null) {
					byte[] imageData = Image.getBytes(1,(int)Image.length());
					String base64Image = Base64.getEncoder().encodeToString(imageData);					
					String imageBase64 = "data:image/jpeg;base64, " + base64Image;
				    response.getWriter().print(imageBase64);
				}else { //null占쏙옙占싸곤옙占� 처占쏙옙
					System.out.println("占싱뱄옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙.");
					
					
				}
				// 占싱뱄옙占쏙옙 占쏙옙占쏙옙占싶몌옙 Base64占쏙옙 占쏙옙占쌘듸옙 DB占쏙옙占쏙옙 占쏙옙占쏙옙占싶억옙占싹기때占쏙옙占쏙옙 
				
				
					//response.setContentType("image/jpeg");
					//response.getOutputStream().write(imageData);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}