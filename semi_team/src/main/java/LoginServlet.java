import java.io.IOException;
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
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "shinee";
		String userPassword = "shinee";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, userName, userPassword);
			
			
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			
			
			String selectSQL = "SELECT * FROM user_info WHERE user_id =? AND user_password =?";
			
			PreparedStatement selectState = connection.prepareStatement(selectSQL);
			
			selectState.setString(1, user_id);
			selectState.setString(2, user_password);
			
			ResultSet resultSet = selectState.executeQuery();
			
			if(resultSet.next()) {
				
				HttpSession session = request.getSession();
				session.setAttribute("user_id", resultSet.getString("user_id"));
				session.setAttribute("user_name", resultSet.getString("user_name"));
				session.setAttribute("user_nickname", resultSet.getString("user_nickname"));
				session.setAttribute("user_password", resultSet.getString("user_password"));
				session.setAttribute("email", resultSet.getString("email"));
				session.setAttribute("phone_number", resultSet.getString("phone_number"));
				
				
				response.sendRedirect("playList.jsp");
				request.getRequestDispatcher("playList.jsp");
				
				
				
			} else {
				//�α��� ����
				request.setAttribute("loginError", "true");
				request.getRequestDispatcher("login.jsp").forward(request, response); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}