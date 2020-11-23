package progetto.stageandwork.entity;

import java.util.List;

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
	@JoinColumn(name="user")
	private User user;
	
	@OneToMany(mappedBy = "company")
	private List<Stage> stages;
	
	@OneToMany(mappedBy = "company")
	private List<Work> works;
	
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
