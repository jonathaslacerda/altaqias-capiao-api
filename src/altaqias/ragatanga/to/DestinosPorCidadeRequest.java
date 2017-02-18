package altaqias.ragatanga.to;

import altaqias.ragatanga.model.Cidade;
import lombok.Getter;
import lombok.Setter;

public class DestinosPorCidadeRequest extends RequestTO{

	@Getter @Setter
	private Cidade cidade;
}
