package altaqias.ragatanga.api.query;

public class EmpresaQuery {

	public static final String LOGIN = "SELECT e FROM Empresa e WHERE e.email = :email AND e.senha = :senha";
	
}
