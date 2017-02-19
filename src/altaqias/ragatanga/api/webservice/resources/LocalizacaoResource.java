package altaqias.ragatanga.api.webservice.resources;

import java.util.List;

import altaqias.ragatanga.api.controller.LocalizacaoController;
import altaqias.ragatanga.model.Cidade;
import altaqias.ragatanga.model.Destino;
import altaqias.ragatanga.model.Estado;
import altaqias.ragatanga.model.Pais;
import altaqias.ragatanga.model.Servico;
import altaqias.ragatanga.to.CidadesPorEstadoRequest;
import altaqias.ragatanga.to.CidadesPorEstadoResponse;
import altaqias.ragatanga.to.DestinosPorCidadeRequest;
import altaqias.ragatanga.to.DestinosPorCidadeResponse;
import altaqias.ragatanga.to.EstadosPorPaisRequest;
import altaqias.ragatanga.to.EstadosPorPaisResponse;
import altaqias.ragatanga.to.PaisesResponse;
import altaqias.ragatanga.to.ServicosResponse;

public class LocalizacaoResource{
	
	public PaisesResponse paises() {
		PaisesResponse response = new PaisesResponse();
		List<Pais> paises = LocalizacaoController.todosOsPaises();
		response.setPaises(paises);
		return response;
	}

	public EstadosPorPaisResponse estadosPorPais(EstadosPorPaisRequest request) {
		EstadosPorPaisResponse response = new EstadosPorPaisResponse();
		List<Estado> estados = LocalizacaoController.estadosPorPais(request.getPais());
		response.setEstados(estados);
		return response;
	}
	
	public CidadesPorEstadoResponse cidadesPorEstado(CidadesPorEstadoRequest request) {
		CidadesPorEstadoResponse response = new CidadesPorEstadoResponse();
		List<Cidade> cidades = LocalizacaoController.cidadesPorEstado(request.getEstado());
		response.setCidades(cidades);
		return response;
	}
	
	public DestinosPorCidadeResponse destinosPorCidade(DestinosPorCidadeRequest request) {
		DestinosPorCidadeResponse response = new DestinosPorCidadeResponse();
		List<Destino> destinos = LocalizacaoController.destinosPorCidade(request.getCidade());
		response.setDestinos(destinos);
		return response;
	}

	public ServicosResponse servicos() {
		ServicosResponse response = new ServicosResponse();
		List<Servico> servicos = LocalizacaoController.todosOsServicos();
		response.setServicos(servicos);
		return response;
	}

	public CidadesPorEstadoResponse cidades() {
		CidadesPorEstadoResponse response = new CidadesPorEstadoResponse();
		List<Cidade> cidades = LocalizacaoController.todasAsCidades();
		response.setCidades(cidades);
		return response;
	}
}