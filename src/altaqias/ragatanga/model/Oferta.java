package altaqias.ragatanga.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class Oferta {
	
	@Getter @Setter
	private Integer id;

	@Getter @Setter
	private Empresa empresa;
	
	@Getter @Setter
	private Servico servico;
	
	@Getter @Setter
	private Cidade cidade;
	
	@Getter @Setter
	private BigDecimal valor;
	
	@Getter @Setter
	private String descricao;
	
}
