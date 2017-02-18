package altaqias.ragatanga.api.webservice.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import altaqias.ragatanga.api.webservice.resources.ClienteResource;
import altaqias.ragatanga.to.ClienteAutenticarRequest;
import altaqias.ragatanga.to.ClienteAutenticarResponse;
import altaqias.ragatanga.to.ClienteCadastrarRequest;
import altaqias.ragatanga.to.ClienteCadastrarResponse;

@Path("/")
public class ClienteService {

	@POST
	@Path("/clientes/v1/autenticar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteAutenticarResponse autenticar(ClienteAutenticarRequest request){
		ClienteResource resource = new ClienteResource();
		return resource.autenticar(request);
	}
	
	@POST
	@Path("/clientes/v1/cadastrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteCadastrarResponse cadastrar(ClienteCadastrarRequest request){
		ClienteResource resource = new ClienteResource();
		return resource.cadastrar(request);
	}
}
