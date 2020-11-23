package progetto.stageandwork.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="work")
public class Work {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "validated")
	private boolean validated = false;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "sector")
	private String sector;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="details_id")
	private Details details;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="company_id")
	private Company company;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "work_student",
		joinColumns = @JoinColumn(name = "work_id"),
		inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Student> subs;
	
	public Work() {	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
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

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
		Work other = (Work) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
