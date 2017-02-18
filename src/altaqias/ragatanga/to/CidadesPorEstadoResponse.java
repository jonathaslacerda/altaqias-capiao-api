package altaqias.ragatanga.to;

import java.util.List;

import altaqias.ragatanga.model.Cidade;
import lombok.Getter;
import lombok.Setter;

public class CidadesPorEstadoResponse extends ResponseTO {

	@Getter @Setter
	private List<Cidade> cidades;
}
