package progetto.stageandwork.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	@OneToOne(cascade = CascadeType.ALL,
			mappedBy = "user")
	private Student student;
	
	@OneToOne(cascade = CascadeType.ALL,
			mappedBy = "user")
	private Company company;

	@OneToOne(cascade = CascadeType.ALL,
			mappedBy = "user")
	private University university;
	
	
	public User() {}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	
	public Subscriber getSubscriber() {
		
		if (student != null )
			return student;
		else
			return company;
	}
}
