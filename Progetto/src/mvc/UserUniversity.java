package mvc;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserUniversity implements User {

	@Id
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
}
