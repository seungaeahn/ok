package semi_SHINee;

import java.sql.Blob;

public class SHINeeUserData {
	private String userId;
	private String userName;
	private String userNickname;
	private String userPW;
	private String email;
	private String phoneNumber;
	private String profile_img;
	
	
	public SHINeeUserData(String userId, String userName, String userNickname, String userPW,  String email, String phoneNumber, String profile_img) {
		this.userId = userId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userPW = userPW;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.profile_img = profile_img;
	}
	
	public SHINeeUserData() {
		
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

}