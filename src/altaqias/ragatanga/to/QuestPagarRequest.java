package altaqias.ragatanga.to;

import java.math.BigDecimal;

import altaqias.ragatanga.model.Cliente;
import altaqias.ragatanga.model.Quest;
import lombok.Getter;
import lombok.Setter;

public class QuestPagarRequest extends RequestTO {

	@Getter @Setter
	private Quest quest;
	
	@Getter @Setter
	private Cliente cliente;
	
	@Getter @Setter
	private BigDecimal valor;
}
