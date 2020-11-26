package progetto.stageandwork.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student implements Subscriber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="department")
	private String department;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user")
	private User user;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy="students")
	private Set<Event> subscribedEvents;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="subs")
	private Set<Stage> subscribedStages;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="subs")
	private Set<Work> subscribedWorks;
	
	public Student() {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<Event> getSubscribedEvents() {
		return subscribedEvents;
	}

	public void setSubscribedEvents(Set<Event> subscribedEvents) {
		this.subscribedEvents = subscribedEvents;
	}

	public Set<Stage> getSubscribedStages() {
		return subscribedStages;
	}

	public void setSubscribedStages(Set<Stage> subscribedStages) {
		this.subscribedStages = subscribedStages;
	}

	public Set<Work> getSubscribedWorks() {
		return subscribedWorks;
	}

	public void setSubscribedWorks(Set<Work> subscribedWorks) {
		this.subscribedWorks = subscribedWorks;
	}

	public void addSubscription(Event event) {
		subscribedEvents.add(event);
	}
	
	public void removeSubscription(Event event) {
		subscribedEvents.remove(event);
	}
	
	public void addSubscription(Stage stage) {
		subscribedStages.add(stage);
	}
	
	public void removeSubscription(Stage stage) {
		subscribedStages.remove(stage);
	}
	
	public void addSubscription(Work work) {
		subscribedWorks.add(work);
	}
	
	public void removeSubscription(Work work) {
		subscribedWorks.remove(work);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
