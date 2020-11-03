package entity;

import javax.persistence.*;

@Entity
@Table(name="company")
public class Company implements User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="partita_iva")
	private int partitaIva;
	
	@Column(name="name")
	private String name;
}
