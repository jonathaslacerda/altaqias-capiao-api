package altaqias.ragatanga.api.query;

public class ClienteQuery {

	public static final String LOGIN = "SELECT c FROM Cliente c WHERE c.email = :email AND c.senha = :senha";
	
}
