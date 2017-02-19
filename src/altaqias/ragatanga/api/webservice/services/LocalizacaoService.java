package altaqias.ragatanga.api.webservice.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import altaqias.ragatanga.api.webservice.resources.LocalizacaoResource;
import altaqias.ragatanga.to.CidadesPorEstadoRequest;
import altaqias.ragatanga.to.CidadesPorEstadoResponse;
import altaqias.ragatanga.to.DestinosPorCidadeRequest;
import altaqias.ragatanga.to.DestinosPorCidadeResponse;
import altaqias.ragatanga.to.EstadosPorPaisRequest;
import altaqias.ragatanga.to.EstadosPorPaisResponse;
import altaqias.ragatanga.to.PaisesResponse;
import altaqias.ragatanga.to.ServicosResponse;

@Path("/")
public class LocalizacaoService {

	@POST
	@Path("/localizacao/v1/paises")
	@Produces(MediaType.APPLICATION_JSON)
	public PaisesResponse paises(){
		LocalizacaoResource resource = new LocalizacaoResource();
		return resource.paises();
	}
	

	@POST
	@Path("/localizacao/v1/cidades")
	@Produces(MediaType.APPLICATION_JSON)
	public CidadesPorEstadoResponse cidades(){
		LocalizacaoResource resource = new LocalizacaoResource();
		return resource.cidades();
	}
	
	@POST
	@Path("/localizacao/v1/estados_por_pais")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public EstadosPorPaisResponse estadosPorPais(EstadosPorPaisRequest request){
		LocalizacaoResource resource = new LocalizacaoResource();
		return resource.estadosPorPais(request);
	}
	
	@POST
	@Path("/localizacao/v1/cidades_por_estado")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public CidadesPorEstadoResponse cidadesPorEstado(CidadesPorEstadoRequest request){
		LocalizacaoResource resource = new LocalizacaoResource();
		return resource.cidadesPorEstado(request);
	}
	
	@POST
	@Path("/localizacao/v1/destinos_por_cidade")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public DestinosPorCidadeResponse destinosPorCidade(DestinosPorCidadeRequest request){
		LocalizacaoResource resource = new LocalizacaoResource();
		return resource.destinosPorCidade(request);
	}
	
	@GET
	@Path("/localizacao/v1/servicos")
	@Produces(MediaType.APPLICATION_JSON)
	public ServicosResponse servicos(){
		LocalizacaoResource resource = new LocalizacaoResource();
		return resource.servicos();
	}
	
}
