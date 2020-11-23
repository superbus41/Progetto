package progetto.stageandwork.entity;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Details {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne(mappedBy = "details")
	private Event event;
	
	public Details() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String descripion) {
		this.description = descripion;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	
}
