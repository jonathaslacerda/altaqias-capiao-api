package altaqias.ragatanga.to;

import altaqias.ragatanga.model.Estado;
import lombok.Getter;
import lombok.Setter;

public class CidadesPorEstadoRequest extends RequestTO {
	
	@Getter @Setter
	private Estado estado;

}
