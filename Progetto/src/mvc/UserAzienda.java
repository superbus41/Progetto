package mvc;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserAzienda implements User {
	
	@Id
	@Column(name="partita_iva")
	private int partitaIva;
	
	@Column(name="name")
	private String name;
}
