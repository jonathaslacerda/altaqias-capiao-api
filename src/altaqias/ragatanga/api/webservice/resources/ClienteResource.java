package altaqias.ragatanga.api.webservice.resources;

import altaqias.ragatanga.model.Cliente;
import altaqias.ragatanga.to.ClienteAutenticarRequest;
import altaqias.ragatanga.to.ClienteAutenticarResponse;
import altaqias.ragatanga.to.ClienteCadastrarRequest;
import altaqias.ragatanga.to.ClienteCadastrarResponse;

public class ClienteResource{
	
	public ClienteAutenticarResponse autenticar(ClienteAutenticarRequest request){
		ClienteAutenticarResponse response = new ClienteAutenticarResponse(); 
		Cliente cliente = ClienteController.autenticar(request.getEmail(), request.getSenha());
		
		response.
		response.setCliente(cliente);
		return response;
	}
	
	public ClienteCadastrarResponse cadastrar(ClienteCadastrarRequest request){
		return null;
	}
}