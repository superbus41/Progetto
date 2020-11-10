package progetto.stageandwork.entity;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

@Entity
@Table(name="stage")
public class Stage {

	final static boolean STAGE_CURRICULARE = true;
	final static boolean STAGE_EXTRACURRICULARE = false;
	
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
	
	@Column(name = "tipo")
	private boolean tipo;
	
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@Column(name = "ending_date")
	private LocalDate endingDate;
	
	public Stage() {}

	public Stage(String title, String sector, boolean tipo, LocalDate startingDate, LocalDate endingDate) {
		this.validated = false;
		this.title = title;
		this.sector = sector;
		this.tipo = tipo;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
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

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	};
	
	public int getDuration() {
		return Period.between(endingDate, startingDate).getMonths();

	}
}
