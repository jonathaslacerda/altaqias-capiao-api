package altaqias.ragatanga.api.webservice.exception;

import lombok.Getter;
import lombok.Setter;

public class Mensagem {
	
	public static final String COD_SUCESSO = "00";
	public static final String MSG_SUCESSO = "SUCESSO";
	public static final String COD_FILE_NOT_FOUND_EXCEPTION = "31";
	public static final String MSG_FILE_NOT_FOUND_EXCEPTION = "DIRETORIO {0} NAO ENCONTRADO";
	public static final String COD_IO_EXCEPTION = "32";
	public static final String MSG_IO_EXCEPTION = "DIRETORIO {0} NAO ENCONTRADO";
	public static final String COD_PARAMETRO_NAO_ENCONTRADO_EXCEPTION = "33";
	public static final String MSG_PARAMETRO_NAO_ENCONTRADO_EXCEPTION = "O PARAMETRO {0} NAO ENCONTRADO";
	public static final String COD_METODO_NAO_PERMITIDO_EXCEPTION = "34";
	public static final String MSG_METODO_NAO_PERMITIDO_EXCEPTION = "O METODO {0} NAO E PERMITIDO";

	@Getter @Setter
	private String cod;
	@Getter @Setter
	private String msg;
	
	public Mensagem(){
		this.cod = Mensagem.COD_SUCESSO;
		this.msg = Mensagem.MSG_SUCESSO;
	}
	
	public Mensagem(String cod, String msg){
		this.cod = cod;
		this.msg = msg;
	}
}
