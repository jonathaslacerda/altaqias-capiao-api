package altaqias.ragatanga.api.webservice.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import altaqias.ragatanga.api.webservice.resources.QuestResource;
import altaqias.ragatanga.to.QuestCriarRequest;
import altaqias.ragatanga.to.QuestCriarResponse;
import altaqias.ragatanga.to.QuestEntrarRequest;
import altaqias.ragatanga.to.QuestEntrarResponse;

@Path("/")
public class QuestService {

	@POST
	@Path("/quest/v1/criar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public QuestCriarResponse questCriar(QuestCriarRequest request){
		QuestResource resource = new QuestResource();
		return resource.criar(request);
	}
	
	@POST
	@Path("/quest/v1/entrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public QuestEntrarResponse questEntrar(QuestEntrarRequest request){
		QuestResource resource = new QuestResource();
		return resource.entrar(request);
	}
	
}
