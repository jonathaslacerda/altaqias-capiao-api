package altaqias.ragatanga.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Despesa {

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private Quest quest;
	
	@Getter @Setter
	private BigDecimal valor;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private List<Autorizacao> autorizacoes;
}
