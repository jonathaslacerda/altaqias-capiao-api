package altaqias.ragatanga.to;

import java.util.List;

import altaqias.ragatanga.model.Pais;
import lombok.Getter;
import lombok.Setter;

public class PaisesResponse extends ResponseTO {

	@Getter @Setter
	List<Pais> paises;
	
	public PaisesResponse(){
		this.setMensagem(new MensagemTO());
	}
}
