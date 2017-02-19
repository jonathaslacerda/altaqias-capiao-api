package altaqias.ragatanga.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class Inscricao {

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private Cliente cliente;
	
	@Getter @Setter
	private Quest quest;
	
	@Getter @Setter
	private BigDecimal valor;
	
	@Getter @Setter
	private String tokenAutorizacao;
}
