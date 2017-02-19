package altaqias.ragatanga.to;

import java.util.List;

import altaqias.ragatanga.model.Servico;
import lombok.Getter;
import lombok.Setter;

public class ServicosResponse extends ResponseTO {
	
	@Getter @Setter
	private List<Servico> servicos;
}
