package altaqias.ragatanga.to;

import lombok.Getter;
import lombok.Setter;

public class ClienteAutenticarRequest extends RequestTO {

	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String senha;
}
