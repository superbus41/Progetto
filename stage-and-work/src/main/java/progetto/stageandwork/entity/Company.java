package progetto.stageandwork.entity;

import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@Column(name="partita_iva")
	private int partitaIva;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	public Company() {
	}

	public Company(int partitaIva, String name) {
		this.partitaIva = partitaIva;
		this.name = name;
	}

	public int getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(int partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}
