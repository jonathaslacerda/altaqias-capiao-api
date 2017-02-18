package altaqias.ragatanga.api.webservice.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import altaqias.ragatanga.api.webservice.resources.EmpresaResource;
import altaqias.ragatanga.to.EmpresaAutenticarRequest;
import altaqias.ragatanga.to.EmpresaAutenticarResponse;
import altaqias.ragatanga.to.EmpresaCadastrarRequest;
import altaqias.ragatanga.to.EmpresaCadastrarResponse;

@Path("/")
public class EmpresaService {

	@POST
	@Path("/empresa/v1/autenticar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public EmpresaAutenticarResponse autenticar(EmpresaAutenticarRequest request){
		EmpresaResource resource = new EmpresaResource();
		return resource.autenticar(request);
	}
	
	@POST
	@Path("/empresa/v1/cadastrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public EmpresaCadastrarResponse cadastrar(EmpresaCadastrarRequest request){
		EmpresaResource resource = new EmpresaResource();
		return resource.cadastrar(request);
	}
	
}
