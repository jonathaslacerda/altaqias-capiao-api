package altaqias.ragatanga.model;

import lombok.Getter;
import lombok.Setter;

public class Empresa {

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private String documento;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String telefone;
	
	@Getter @Setter
	private Pais nacionalidade;
}
