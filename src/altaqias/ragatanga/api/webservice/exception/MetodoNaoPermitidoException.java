package altaqias.ragatanga.api.webservice.exception;

import java.text.MessageFormat;

@SuppressWarnings("serial")
public class MetodoNaoPermitidoException extends APIException{

	public MetodoNaoPermitidoException(String metodo) {
		super(Mensagem.COD_METODO_NAO_PERMITIDO_EXCEPTION, MessageFormat.format(Mensagem.MSG_METODO_NAO_PERMITIDO_EXCEPTION, metodo));
	}
	
	public Mensagem getMensagem(){
		return super.getMensagem();
	}
}
