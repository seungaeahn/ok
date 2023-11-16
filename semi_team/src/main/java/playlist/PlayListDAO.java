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
import java.util.List;

import javax.servlet.http.Part;

public class PlayListDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "shinee";
	private static final String jdbcPassword = "shinee";
	
	public PlayListDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<PlayList> getAllPlaylists(String user_id){
		List<PlayList> playlists = new ArrayList<>();
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			String sql = "SELECT * FROM playlist_info WHERE user_id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user_id);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				int playlistId = resultSet.getInt("playlist_id");
				String playlistName = resultSet.getString("playlist_name");
				user_id = resultSet.getString("user_id");
				Blob Image = resultSet.getBlob("image");
				byte[] imageData = Image.getBytes(1, (int) Image.length());
				String imageBase64 = Base64.getEncoder().encodeToString(imageData);
				String image = "data:image/jpeg;base64," + imageBase64;
				
				
			    
				PlayList playlist = new PlayList(playlistId,user_id, playlistName,image);
				playlists.add(playlist);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return playlists;

	}
	public PlayList getPlaylistID(int playlistId) {
		PlayList playlist = null;
		//select�빐�꽌 �븯�굹�뵫 蹂닿린
		Connection connection;
		try {
			connection =DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT * FROM playlist_info WHERE playlist_id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1,playlistId);
			ResultSet resultSet = ps.executeQuery();
			
			//new playlist �씠�슜�빐�꽌 媛� 媛��졇�삤湲�
			if(resultSet.next()) {
				playlistId = resultSet.getInt("playlist_id");
				String user_id = resultSet.getString("user_id");
				String playlistName = resultSet.getString("playlist_name");
				
				Blob image = resultSet.getBlob("image");
				byte[] imageData = image.getBytes(1, (int) image.length());
				String imageBase64 = Base64.getEncoder().encodeToString(imageData);
				String Image = "data:image/jpeg;base64," + imageBase64;
				playlist = new PlayList(playlistId, user_id, playlistName,Image);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return playlist;
	}

	

	

}