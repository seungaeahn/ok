package search;

import java.util.Date;


public class Playlist_info {

	//멤버변수
	int playlist_id;
	String user_id;
	String playlist_name;
	String image;
	
	//생성자
	public Playlist_info() {}
	
	//플레이리스트 검색 생성자
	public Playlist_info(String user_id, String playlist_name) {
		this.user_id = user_id;
		this.playlist_name = playlist_name;
	}

	
	//Getter----------------------------------
	
	public int getPlaylist_id() {
		return playlist_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getPlaylist_name() {
		return playlist_name;
	}


	//Setter----------------------------------
	
	public void setPlaylist_id(int playlist_id) {
		this.playlist_id = playlist_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setPlaylist_name(String playlist_name) {
		this.playlist_name = playlist_name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
}