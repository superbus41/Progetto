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
	private String descripion;
	
	@OneToOne(mappedBy = "eventDetails", 
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Event event;
}
