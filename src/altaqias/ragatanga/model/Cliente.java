package altaqias.ragatanga.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Cliente {

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
	
	@Getter @Setter
	private Date dataNascimento;
	
	@Getter @Setter
	private List<Idioma> idiomas;
	
}
