package altaqias.ragatanga.model;

import lombok.Getter;
import lombok.Setter;

public class Estado {

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private Pais pais;
}
