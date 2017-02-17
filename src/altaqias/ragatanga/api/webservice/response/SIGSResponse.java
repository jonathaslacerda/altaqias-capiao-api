package altaqias.ragatanga.api.webservice.response;

import altaqias.ragatanga.api.webservice.exception.Mensagem;
import lombok.Getter;
import lombok.Setter;

public abstract class SIGSResponse {

	@Getter @Setter
	private Mensagem mensagem;
}
