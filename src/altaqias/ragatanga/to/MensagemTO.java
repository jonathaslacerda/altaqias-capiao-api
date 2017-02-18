package altaqias.ragatanga.to;

import lombok.Getter;
import lombok.Setter;

public class MensagemTO {
	
	public static final String CODIGO_SUCESSO = "00";
	public static final String MENSAGEM_SUCESSO = "SUCESSO";

	@Getter @Setter
	private String codigo;
	
	@Getter @Setter
	private String mensagem;
	
	public MensagemTO(){
		this.codigo = CODIGO_SUCESSO;
		this.mensagem = MENSAGEM_SUCESSO;
	}
	
	public MensagemTO(String codigo, String mensagem){
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	
	public static MensagemTO mensagemSucesso(){
		return new MensagemTO();
	}
}
