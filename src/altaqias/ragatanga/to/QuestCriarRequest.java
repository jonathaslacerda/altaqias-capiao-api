package altaqias.ragatanga.to;

import altaqias.ragatanga.model.Quest;
import lombok.Getter;
import lombok.Setter;

public class QuestCriarRequest extends ResponseTO {

	@Getter @Setter
	private Quest quest;
}
