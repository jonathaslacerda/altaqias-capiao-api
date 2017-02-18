package altaqias.ragatanga.model;

import lombok.Getter;
import lombok.Setter;

public class Destino {

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private Cidade cidade;
}
