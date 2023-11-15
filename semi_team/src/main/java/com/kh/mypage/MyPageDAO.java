package com.kh.mypage;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyPageDAO {
    private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String jdbcUsername = "shinee";
    private static final String jdbcPassword = "shinee";
    Connection con = null;

    public MyPageDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UserInfo getMember(String user_id) {
        UserInfo ui = null;
        try {
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String sql = "SELECT * FROM USER_INFO WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user_id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                String userId = resultSet.getString("user_id");
                String userName = resultSet.getString("user_name");
                String userNickname = resultSet.getString("user_nickname");
                String userPassword = resultSet.getString("user_password");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
       
                
                Blob blob = resultSet.getBlob("profile_img");
                byte[] imageData = blob.getBytes(1, (int) blob.length());
                String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageData);
                String profile_img = "data:image/jpeg;base64, " + imageBase64;

                ui = new UserInfo(userId, userName, userNickname, userPassword, email, phoneNumber, profile_img);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ui;
    }
}