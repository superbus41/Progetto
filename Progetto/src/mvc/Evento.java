package mvc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eventi")
public class Evento {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="titolo")
	private String titolo;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="data")
	private Date data;
	
	public Evento() {
		
	}
	
	public Evento(String titolo, String descrizione) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
