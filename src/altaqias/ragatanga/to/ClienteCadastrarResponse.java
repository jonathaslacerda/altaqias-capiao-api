package altaqias.ragatanga.to;

import altaqias.ragatanga.model.Cliente;
import lombok.Getter;
import lombok.Setter;

public class ClienteCadastrarResponse extends ResponseTO {

	@Getter @Setter
	private Cliente cliente;
}
