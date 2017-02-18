package altaqias.ragatanga.api.query;

public class ClienteQuery {

	public static final String AUTENTICAR = "SELECT c FROM Cliente c WHERE c.email = :email AND c.senha = :senha";
	public static final String EXISTE_POR_EMAIL = "SELECT c FROM Cliente c WHERE c.email = :email";
	public static final String EXISTE_POR_DOCUMENTO = "SELECT c FROM Cliente c WHERE c.documento = :documento";
	
}
