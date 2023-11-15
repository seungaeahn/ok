package search;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchServlet")

public class SearchServlet extends HttpServlet {
	
	
	//占쏙옙兆�듸옙占쏙옙 DB占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쌍곤옙 占쌨쇽옙占쏙옙 占쏙옙 static占쏙옙 占시뤄옙占쏙옙占쏙옙占쏙옙
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jbdcUsername = "shinee";
	private static final String jdbcPassword = "shinee";
	
	Connection connection = null;
	
	//doGet() : 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쌨쇽옙占쏙옙
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DB占쏙옙占쏙옙
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL, jbdcUsername, jdbcPassword);
			
			String search_Text = request.getParameter("searchText");
			
			String searchSQL = "SELECT song_name, artist_name FROM music_info WHERE song_name =? ";
			PreparedStatement searchState = connection.prepareStatement(searchSQL);
			
			searchState.setString(1,search_Text);
			
			ResultSet resultSet = searchState.executeQuery();
			
			//2. 占썼열 占쏙옙占썽러占쌈쏙옙占싹댐옙 占쏙옙占쏙옙
			ArrayList<Music_info> musicList = new ArrayList<>();
			
			while(resultSet.next()) {
				
				String song_name = resultSet.getString("song_name");
				String artist_name = resultSet.getString("artist_name");
				
				//MusicSearch_info클占쏙옙占쏙옙 占쏙옙체 占쏙옙占쏙옙
				Music_info music_info = new Music_info(song_name, artist_name);

				//1. 占썼열占쏙옙 占쏙옙체 占쏙옙占쏙옙占쏙옙占쏙옙占� 占싹댐옙 占썼열 占쏙옙占쏙옙占쏙옙챨篤占�
				//3. 占쏙옙占쏙옙占쏙옙擔占쏙옙求占� 占쏙옙占쏙옙鳴篤占�
				musicList.add(music_info);
			}
			
			//占쏙옙占실몌옙占쏙옙占� 占쏙옙占쏙옙占쌌시댐옙
			request.setAttribute("musicList", musicList);
			//request.getRequestDispatcher("/search.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

} //class