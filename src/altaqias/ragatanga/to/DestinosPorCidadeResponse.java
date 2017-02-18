package altaqias.ragatanga.to;

import java.util.List;

import altaqias.ragatanga.model.Destino;
import lombok.Getter;
import lombok.Setter;

public class DestinosPorCidadeResponse extends ResponseTO{

	@Getter @Setter
	private List<Destino> destinos;
}
