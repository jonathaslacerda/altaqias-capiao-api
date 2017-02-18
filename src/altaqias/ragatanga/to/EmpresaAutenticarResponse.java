package altaqias.ragatanga.to;

import altaqias.ragatanga.model.Empresa;
import lombok.Getter;
import lombok.Setter;

public class EmpresaAutenticarResponse extends ResponseTO {

	@Getter @Setter
	private Empresa empresa;
}
