package altaqias.ragatanga.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class Quest {

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private Cliente criador;
	
	@Getter @Setter
	private BigDecimal valor;
	
	@Getter @Setter
	private Date prazo;
	
	@Getter @Setter
	private Destino destino;
	
}
