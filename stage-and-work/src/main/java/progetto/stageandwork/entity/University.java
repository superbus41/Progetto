package progetto.stageandwork.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="university")
public class University {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user")
	private User user;

	@OneToMany(mappedBy = "university")
	private List<Event> events;
	
	public University(){
	}
	
	public University(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
