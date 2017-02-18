package altaqias.ragatanga.api.webservice.resources;

import altaqias.ragatanga.api.controller.ClienteController;
import altaqias.ragatanga.api.utils.EmailUtils;
import altaqias.ragatanga.api.webservice.exception.ClienteAutenticarException;
import altaqias.ragatanga.api.webservice.exception.ClienteCadastrarException;
import altaqias.ragatanga.model.Cliente;
import altaqias.ragatanga.to.ClienteAutenticarRequest;
import altaqias.ragatanga.to.ClienteAutenticarResponse;
import altaqias.ragatanga.to.ClienteCadastrarRequest;
import altaqias.ragatanga.to.ClienteCadastrarResponse;
import altaqias.ragatanga.to.MensagemTO;

public class ClienteResource{
	
	public ClienteAutenticarResponse autenticar(ClienteAutenticarRequest request){
		ClienteAutenticarResponse response = new ClienteAutenticarResponse(); 
		try {
			this.validarAutenticar(request);
			Cliente cliente = ClienteController.autenticar(request.getEmail(), request.getSenha());
			response.setCliente(cliente);
		} catch (ClienteAutenticarException e) {
			response.setMensagem(new MensagemTO("11", e.getMessage()));
		}
		return response;
	}
	
	public ClienteCadastrarResponse cadastrar(ClienteCadastrarRequest request){
		ClienteCadastrarResponse response = new ClienteCadastrarResponse();
		try {
			this.validarCadastrar(request);
			Cliente cliente = ClienteController.cadastrar(request.getCliente());
			response.setCliente(cliente);
		} catch (Exception e) {
			response.setMensagem(new MensagemTO("12", e.getMessage()));
		}
		return response;
	}
	
	private void validarCadastrar(ClienteCadastrarRequest request) throws ClienteCadastrarException {
		Cliente cliente = request.getCliente();
		if(ClienteController.existePorDocumento(cliente.getDocumento())){
			throw new ClienteCadastrarException("O CPF " + cliente.getDocumento() + "  já está em uso");
		}
		if(ClienteController.existePorEmail(cliente.getEmail())){
			throw new ClienteCadastrarException("O E-mail " + cliente.getEmail() + " já está em uso");
		}
	}

	private void validarAutenticar(ClienteAutenticarRequest request) throws ClienteAutenticarException{
		if(request.getEmail() == null || request.getEmail().isEmpty()){
			throw new ClienteAutenticarException("E-mail não informado");
		}
		if(!EmailUtils.validarEmail(request.getEmail())){
			throw new ClienteAutenticarException("E-mail inválido");
		}
		if(request.getSenha() == null || request.getSenha().isEmpty()){
			throw new ClienteAutenticarException("Senha não informada");
		}
	}
}