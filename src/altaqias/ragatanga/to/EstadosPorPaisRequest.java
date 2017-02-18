package altaqias.ragatanga.to;

import altaqias.ragatanga.model.Pais;
import lombok.Getter;
import lombok.Setter;

public class EstadosPorPaisRequest extends RequestTO {

	@Getter @Setter
	private Pais pais;
}
