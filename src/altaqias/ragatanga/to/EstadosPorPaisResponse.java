package altaqias.ragatanga.to;

import java.util.List;

import altaqias.ragatanga.model.Estado;
import lombok.Getter;
import lombok.Setter;

public class EstadosPorPaisResponse extends ResponseTO {

	@Getter @Setter
	private List<Estado> estados;
}
