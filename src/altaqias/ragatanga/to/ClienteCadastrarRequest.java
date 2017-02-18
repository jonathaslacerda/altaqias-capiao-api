package altaqias.ragatanga.to;

import altaqias.ragatanga.model.Cliente;
import lombok.Getter;
import lombok.Setter;

public class ClienteCadastrarRequest extends RequestTO {

	@Getter @Setter
	private Cliente cliente;
}
