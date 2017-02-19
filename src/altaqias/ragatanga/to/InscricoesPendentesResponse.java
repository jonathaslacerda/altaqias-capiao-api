package altaqias.ragatanga.to;

import java.util.List;

import altaqias.ragatanga.model.Inscricao;
import lombok.Getter;
import lombok.Setter;

public class InscricoesPendentesResponse extends ResponseTO{
	
	@Getter @Setter
	private List<Inscricao> inscricoes;

}
