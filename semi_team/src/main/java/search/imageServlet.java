package search;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageServlet")
public class imageServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUser = "shinee";
		String jdbcPassword = "shinee";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
			
			String searchSQL = "SELECT user_id, user_nickname, profile_img FROM user_info WHERE user_id LIKE ? OR user_nickname LIKE ?";
			
			PreparedStatement ps = conn.prepareStatement(searchSQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Blob blob = rs.getBlob("image");
				byte[] imageData = blob.getBytes(1, (int)blob.length());
				
				response.setContentType("image/jpg");
				response.getOutputStream().write(imageData);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}