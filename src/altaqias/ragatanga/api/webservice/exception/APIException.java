package altaqias.ragatanga.api.webservice.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
public class APIException extends Exception {
	
	@Getter @Setter
	private Mensagem mensagem;
	
	public APIException(String cod, String msg) {
		super(cod + "-" + msg);
		this.setMensagem(new Mensagem());
		this.mensagem.setCod(cod);
		this.mensagem.setMsg(msg);
	}
}
