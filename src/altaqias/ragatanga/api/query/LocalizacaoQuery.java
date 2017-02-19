package altaqias.ragatanga.api.query;

public class LocalizacaoQuery {

	public static final String PAISES = "SELECT p FROM Pais p";
	public static final String ESTADOS_POR_PAIS = "SELECT e FROM Estado e WHERE e.pais = :pais";
	public static final String CIDADES_POR_ESTADO = "SELECT c FROM Cidade c WHERE c.estado = :estado";
	public static final String DESTINOS_POR_CIDADE = "SELECT d FROM Destino d WHERE d.cidade = :cidade";
	public static final String SERVICOS = "SELECT s FROM Servico s";
	public static final String CIDADES = "SELECT c FROM Cidade c";

}
 