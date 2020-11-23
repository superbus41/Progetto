package progetto.stageandwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import progetto.stageandwork.entity.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public User loadUserByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		
		User user = session.get(User.class,	username);
		
		return user;
	}

}
