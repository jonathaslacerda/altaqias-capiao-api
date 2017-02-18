package altaqias.ragatanga.to;

import altaqias.ragatanga.model.Empresa;
import lombok.Getter;
import lombok.Setter;

public class EmpresaCadastrarResponse extends ResponseTO {

	@Getter @Setter
	private Empresa empresa;
	
	public EmpresaCadastrarResponse(){
		this.setMensagem(new MensagemTO());
	}
}
