package entity;

import java.time.LocalDate;

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
	private LocalDate date;
	
	@Column(name = "place")
	private String place;
	
	private EventDetails detailsEvent;
	
	public Event() {
		
	}

	public Event(String title, String sector, LocalDate date, String place) {
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	
}
