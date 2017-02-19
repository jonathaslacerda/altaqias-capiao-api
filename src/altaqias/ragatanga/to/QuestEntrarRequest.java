package altaqias.ragatanga.to;

import lombok.Getter;
import lombok.Setter;

public class QuestEntrarRequest extends RequestTO {

	@Getter @Setter
	private Integer idCliente;
	
	@Getter @Setter
	private Integer idQuest;
}
