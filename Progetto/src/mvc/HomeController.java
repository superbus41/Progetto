package mvc;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/eventi")
	public String showEventi() {
		return "eventi-action";
	}
	
	@RequestMapping("/addEvento")
	public String showNewEventoForm(Model model) {
		
		Evento e = new Evento();
		
		model.addAttribute("evento", e);
		
		return "evento-form";
	}
	
	@RequestMapping("/searchEvento")
	public String showAllEventi() {
		return "eventi-list";
	}
	
	@RequestMapping("/processEvento")
	public String processEvento(@ModelAttribute("evento") Evento evento) {
		SessionFactory factory = new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Evento.class).
									buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(evento);
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
		return "main-menu";
	}
	
	@RequestMapping("/processForm")
	public String processLogin(HttpServletRequest request, Model model) {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		/*try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection succesful");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}*/
		
		return "user-confirmation";
		
	}
}
