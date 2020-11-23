package progetto.stageandwork.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="event")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="sector")
	private String sector;
	
	@Column(name="date")
	private Date date;
	
	@Column(name = "place")
	private String place;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="details_id")
	private Details details;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "event_student",
		joinColumns = @JoinColumn(name = "event_id"),
		inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Student> subs;
	
	public Event() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Set<Student> getSubs() {
		return subs;
	}

	public void setSubs(Set<Student> subs) {
		this.subs = subs;
	}

	public void addSub(Student student) {
		subs.add(student);
		student.addSubscription(this);
	}

	public void removeSub(Student student) {
		subs.remove(student);
		student.removeSubscription(this);	
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
		Event other = (Event) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
