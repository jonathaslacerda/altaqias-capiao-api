package altaqias.ragatanga.to;

import altaqias.ragatanga.model.Empresa;
import lombok.Getter;
import lombok.Setter;

public class EmpresaCadastrarRequest extends RequestTO {

	@Getter @Setter
	private Empresa empresa;
}
