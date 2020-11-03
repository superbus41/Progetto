package entity;

import javax.persistence.*;

@Entity
@Table(name = "event_details")
public class EventDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String descripion;
}
