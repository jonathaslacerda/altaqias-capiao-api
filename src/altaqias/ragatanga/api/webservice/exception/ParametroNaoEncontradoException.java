package altaqias.ragatanga.api.webservice.exception;

import java.text.MessageFormat;

@SuppressWarnings("serial")
public class ParametroNaoEncontradoException extends APIException{

	public ParametroNaoEncontradoException(String sistemaLocal) {
		super(Mensagem.COD_PARAMETRO_NAO_ENCONTRADO_EXCEPTION, MessageFormat.format(Mensagem.MSG_PARAMETRO_NAO_ENCONTRADO_EXCEPTION, sistemaLocal));
	}
	
	public Mensagem getMensagem(){
		return super.getMensagem();
	}
}
