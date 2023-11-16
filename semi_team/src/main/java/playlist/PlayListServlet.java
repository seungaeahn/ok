package playlist;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PlayListServlet")
public class PlayListServlet extends HttpServlet {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername="shinee";
	private static final String jdbcPassword="shinee";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection connection =null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
            // 예외 처리 추가
        }
		
		try {
			
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String user_id = request.getParameter("user_id");
			
			String sql = "SELECT * FROM playlist_info WHERE user_id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user_id);
			
			ResultSet resultSet = ps.executeQuery();
			//���옣�븷 ArrayList
			ArrayList<PlayList> playlistList = new ArrayList<>(); 
			
			while(resultSet.next()) {
				int playlistId = resultSet.getInt("playlist_id");
				String playlistName = resultSet.getString("playlist_name");
				
				Blob Image = resultSet.getBlob("image");
				byte[] imageData = Image.getBytes(1,(int)Image.length());
				String imageBase64 = Base64.getEncoder().encodeToString(imageData);
				String image = "data:image/jpeg;base64," + imageBase64;
				
				response.setContentType("image/jpeg");
				response.getOutputStream().write(imageData);
				PlayList playlist = new PlayList(playlistId, playlistName, user_id, image);
				//�븯�굹�뵫 add�빐�꽌 �꽔�뼱以�
				playlistList.add(playlist);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}