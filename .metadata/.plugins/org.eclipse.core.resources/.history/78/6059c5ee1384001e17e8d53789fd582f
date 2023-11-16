package com.kh.mypage;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class followBlobDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521";
	private static final String jdbcUsername = "shinee";
	private static final String jdbcPassword = "shinee";
	
	public followBlobDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Connection con = null;
	
	public List<FollowList> getAllFollowings(String follower_id) {
		List<FollowList> followlists = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT * " +
	                "FROM follow_list " +
	                "INNER JOIN user_info ON follow_list.following_id = user_info.user_id " +
	                "WHERE follow_list.follower_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, follower_id);
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
	            
				String followerId = resultSet.getString("follower_id");
	            String followingId = resultSet.getString("following_id");
	            String userNickname = resultSet.getString("user_nickname");
	           
	            Blob blob = resultSet.getBlob("profile_image");
                byte[] imageData = blob.getBytes(1, (int) blob.length());
                String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageData);
                String profile_image = "data:image/jpeg;base64, " + imageBase64;
				
	            FollowList followlist = new FollowList(followerId, followingId, userNickname, profile_image);
	            followlists.add(followlist);

	        }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return followlists;
	}
}