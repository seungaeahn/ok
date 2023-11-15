package insert;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import search.Music_info;
import search.Playlist_info;
import search.Playlist_music_info;
import search.User_info;

public class InsertDAO {
	
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jbdcUsername = "shinee";
	private static final String jdbcPassword = "shinee";
	
	Connection connection = null;

	//占시뤄옙占싱몌옙占쏙옙트id 占쌉력받곤옙, 占쌔댐옙占싹울옙 占쌩곤옙占싹댐옙...占쌨쇽옙占쏙옙
	public Music_info insertMusictoPlaylist(int playlist_id, String song_id) {
		
		String searchSQL = null;

		Connection connection = null;
		PreparedStatement insertState = null;
		ResultSet resultSet = null;
		
		String insertSQL = "INSERT INTO playlist_music VALUES(?,?)";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL, jbdcUsername, jdbcPassword);
			
			insertState = connection.prepareStatement(insertSQL);
			
			insertState.setString(1,"%"+playlist_id+"%");
			insertState.setString(2,"%"+song_id+"%");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	//占쏙옙占쏙옙 id占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙체 占시뤄옙占싱몌옙占쏙옙트 占쏙옙회 占쌨쇽옙占쏙옙
	public ArrayList<Playlist_info> getAllPlaylist(String user_id){
		
		String searchSQL = null;

		Connection connection = null;
		PreparedStatement searchState = null;
		ResultSet resultSet = null;
		
		//2. 占썼열 占쏙옙占썽러占쌈쏙옙占싹댐옙 占쏙옙占쏙옙
		ArrayList<Playlist_info> myplaylists = new ArrayList<>();
		
		try {
			
			searchSQL = "SELECT playlist_id, playlist_name FROM playlist_info WHERE user_id=?";
			
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL, jbdcUsername, jdbcPassword);
			
			searchState = connection.prepareStatement(searchSQL);
			
			searchState.setString(1,user_id);
			
			resultSet = searchState.executeQuery();
	
			
			while(resultSet.next()) {
				
				Playlist_info playlist_info = new Playlist_info();
				
				playlist_info.setPlaylist_id(resultSet.getInt("playlist_id"));
				playlist_info.setPlaylist_name(resultSet.getString("playlist_name"));

				//1. 占썼열占쏙옙 占쏙옙체 占쏙옙占쏙옙占쏙옙占쏙옙占� 占싹댐옙 占썼열 占쏙옙占쏙옙占쏙옙챨篤占�
				//3. 占쏙옙占쏙옙占쏙옙擔占쏙옙求占� 占쏙옙占쏙옙鳴篤占�
				myplaylists.add(playlist_info);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return myplaylists;
		
	}
}