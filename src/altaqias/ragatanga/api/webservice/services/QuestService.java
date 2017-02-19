package altaqias.ragatanga.api.webservice.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import altaqias.ragatanga.api.webservice.resources.QuestResource;
import altaqias.ragatanga.to.InscricoesPendentesRequest;
import altaqias.ragatanga.to.InscricoesPendentesResponse;
import altaqias.ragatanga.to.QuestCriarRequest;
import altaqias.ragatanga.to.QuestCriarResponse;
import altaqias.ragatanga.to.QuestEntrarRequest;
import altaqias.ragatanga.to.QuestEntrarResponse;
import altaqias.ragatanga.to.QuestPagarRequest;
import altaqias.ragatanga.to.QuestPagarResponse;
import altaqias.ragatanga.to.QuestUltimasResponse;

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
	
	@POST
	@Path("/quest/v1/ultimas")
	@Produces(MediaType.APPLICATION_JSON)
	public QuestUltimasResponse ultimas(){
		QuestResource resource = new QuestResource();
		return resource.questsUltimas();
	}
	
	@POST
	@Path("/quest/v1/inscricoes_pendentes")
	@Produces(MediaType.APPLICATION_JSON)
	public InscricoesPendentesResponse inscricoesPendentes(InscricoesPendentesRequest request){
		QuestResource resource = new QuestResource();
		return resource.inscricoesPendentes(request);
	}
	
	@POST
	@Path("/quest/v1/pagar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public QuestPagarResponse questPagar(QuestPagarRequest request){
		QuestResource resource = new QuestResource();
		return resource.pagar(request);
	}
}
