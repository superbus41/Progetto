package progetto.stageandwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progetto.stageandwork.dao.UserDAO;
import progetto.stageandwork.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public User loadUserByUsername(String username) {
		
		return userDAO.loadUserByUsername(username);
	}

}
