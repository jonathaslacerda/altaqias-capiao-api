package altaqias.ragatanga.to;

import java.util.List;

import altaqias.ragatanga.model.Quest;
import lombok.Getter;
import lombok.Setter;

public class QuestUltimasResponse extends ResponseTO {

	@Getter @Setter
	private List<Quest> quests;
}
