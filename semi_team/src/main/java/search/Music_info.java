package search;

public class Music_info{
	
	//占쏙옙占쏙옙占쏙옙占�
	private String song_id;
	private String album_id;
	private String song_name;
	private String artist_name;
	private String genre;
	
	//占쏙옙占쏙옙트 占쏙옙占쏙옙占쏙옙
	public Music_info() {};
	
	//占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙占� 占쌔댐옙占싹댐옙 占쏙옙占쏙옙 占쌨댐옙 占쏙옙占쏙옙占쏙옙
	public Music_info(String song_id, String album_id, String song_name, String artist_name, String genre) {
		this.song_id = song_id;
		this.album_id = album_id;
		this.song_name = song_name;
		this.artist_name = artist_name;
		this.genre = genre;
	}
	
	//占쏙옙占쏙옙 占싯삼옙 占쏙옙占쏙옙 (2占쏙옙占쏙옙占쏙옙) 占쏙옙占쏙옙占쏙옙
	public Music_info(String song_name, String artist_name) {
		this.song_name = song_name;
		this.artist_name = artist_name;
	}
	
	//Getter------------------------------------
	public String getSong_id() {
		return song_id;
	}
	public String getAlbum_id() {
		return album_id;
	}
	public String getSong_name() {
		return song_name;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public String getGenre() {
		return genre;
	}
	
	//Setter------------------------------------
	
	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}
	public void setAlbum_id(String album_id) {
		this.album_id = album_id;
	}
	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}