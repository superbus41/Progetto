package progetto.stageandwork.entity;

import java.sql.Date;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="event_details_id")
	private EventDetails eventDetails;
	
	public Event() {
		
	}

	public Event(String title, String sector, Date date, String place) {
		this.title = title;
		this.sector = sector;
		this.date = date;
		this.place = place;
	}

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

	public EventDetails getEventDetails() {
		return eventDetails;
	}

	public void setDetailsEvent(EventDetails eventDetails) {
		this.eventDetails = eventDetails;
	}

	
	
}
