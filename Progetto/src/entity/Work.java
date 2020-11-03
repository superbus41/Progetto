package entity;

import javax.persistence.*;

@Entity
@Table(name="work")
public class Work implements Offer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "validated")
	private boolean validated;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "sector")
	private String sector;
	
	
	public Work() {}

	public Work(String title, String sector) {
		this.validated = false;
		this.title = title;
		this.sector = sector;
	}

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

	
}
