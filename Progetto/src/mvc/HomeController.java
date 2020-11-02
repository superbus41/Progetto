package mvc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	User loggedUser;
	
	@RequestMapping("/")
	public String showMainMenu() {
		return "main-menu";
	}
	
	@RequestMapping("/login")
	public String showLoginForm() {
		return "login-form";
	}
	
	@RequestMapping("/processForm")
	public String processLogin(HttpServletRequest request, Model model) {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection succesful");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		return "user-confirmation";
		
	}
}
