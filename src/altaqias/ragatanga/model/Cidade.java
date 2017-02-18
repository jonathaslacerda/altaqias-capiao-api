package altaqias.ragatanga.model;

import lombok.Getter;
import lombok.Setter;

public class Cidade {

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private Estado estado;
}
