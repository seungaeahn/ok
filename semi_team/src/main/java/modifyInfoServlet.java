import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modifyInfoServlet")
public class modifyInfoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JDBC �ҷ�����
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername = "shinee";
		String jdbcPassword = "shinee";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		
			//�ְ����ϴ� DB �� ����
			/*
			 * CREATE TABLE MemberInfo (
				    MNO INT PRIMARY KEY,
				    MName VARCHAR(50),
				    MEmail VARCHAR(100),
				    MBirth  DATE
			);*/
			   //int mno = Integer.parseInt(request.getParameter("mno"));
	            String user_name = request.getParameter("user_name");
	            String user_nickname = request.getParameter("user_nickname");
	            String user_password = request.getParameter("user_password");
	            String email = request.getParameter("email");
	            String phone_number = request.getParameter("phone_number");
	            String user_id = request.getParameter("user_id");
	            
			
			// update 
	            //"update web_member set pw=?, tel=?, address=? where email=?";
	           
	            String sql = "UPDATE USER_INFO SET user_name=?, user_nickname=?, user_password=?, email=?, phone_number=? WHERE user_id=?";
	            
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, user_name);
	            preparedStatement.setString(2, user_nickname);
	            preparedStatement.setString(3, user_password);
	            preparedStatement.setString(4, email);
	            preparedStatement.setString(5, phone_number);
	            preparedStatement.setString(6, user_id);

	            preparedStatement.executeUpdate();
			
			
	            request.getSession().setAttribute("user_name", user_name);
	            request.getSession().setAttribute("user_nickname", user_nickname);
	            request.getSession().setAttribute("user_password", user_password);
	            request.getSession().setAttribute("email", email);
		
			
			response.sendRedirect("mypageMain.jsp");
			
		} catch (SQLException e) {
			
			response.sendRedirect("register_error.jsp");
			e.printStackTrace();
		}
	}

}