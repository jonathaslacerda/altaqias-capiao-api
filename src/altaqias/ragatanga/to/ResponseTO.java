package altaqias.ragatanga.to;

import lombok.Getter;
import lombok.Setter;

public abstract class ResponseTO {
	
	@Getter @Setter
	private String codigo;
	
	@Getter @Setter
	private String mensagem;
	
}
