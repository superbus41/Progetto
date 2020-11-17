package progetto.stageandwork.entity;

import javax.persistence.*;

import progetto.stageandwork.entity.Event;

@Entity
@Table(name = "event_details")
public class EventDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne(mappedBy = "eventDetails", 
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Event event;
	
	public EventDetails() {}
	
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
