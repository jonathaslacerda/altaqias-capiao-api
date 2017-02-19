package altaqias.ragatanga.api.query;

public class QuestQuery {

	public static final String EXISTE_POR_ID = "SELECT q FROM Quest q WHERE q.id = :id";
	public static final String LER = "SELECT q FROM Quest q WHERE q.id = :id";
	public static final String ULTIMAS_QUESTS_ABERTAS = 
			"SELECT q FROM Quest q WHERE q.prazo <= CURRENT_DATE() ORDER BY q.id DESC";
	public static final String INSCRICOES_PENDENTES_ID_CLIENTE = 
			"SELECT i FROM Inscricao i WHERE i.cliente.id = : id";
}
