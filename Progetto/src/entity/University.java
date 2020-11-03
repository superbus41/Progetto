package entity;

import javax.persistence.*;

@Entity
@Table(name="university")
public class University implements User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
}
