package altaqias.ragatanga.api.webservice.resources;

import altaqias.ragatanga.api.controller.EmpresaController;
import altaqias.ragatanga.api.utils.EmailUtils;
import altaqias.ragatanga.api.webservice.exception.EmpresaAutenticarException;
import altaqias.ragatanga.api.webservice.exception.EmpresaCadastrarException;
import altaqias.ragatanga.model.Empresa;
import altaqias.ragatanga.to.EmpresaAutenticarRequest;
import altaqias.ragatanga.to.EmpresaAutenticarResponse;
import altaqias.ragatanga.to.EmpresaCadastrarRequest;
import altaqias.ragatanga.to.EmpresaCadastrarResponse;
import altaqias.ragatanga.to.MensagemTO;

public class EmpresaResource{
	
	public EmpresaAutenticarResponse autenticar(EmpresaAutenticarRequest request){
		EmpresaAutenticarResponse response = new EmpresaAutenticarResponse(); 
		try {
			this.validarAutenticar(request);
			Empresa empresa = EmpresaController.autenticar(request.getEmail(), request.getSenha());
			response.setEmpresa(empresa);
		} catch (EmpresaAutenticarException e) {
			response.setMensagem(new MensagemTO("11", e.getMessage()));
		}
		return response;
	}
	
	public EmpresaCadastrarResponse cadastrar(EmpresaCadastrarRequest request){
		EmpresaCadastrarResponse response = new EmpresaCadastrarResponse();
		try {
			this.validarCadastrar(request);
			Empresa empresa = EmpresaController.cadastrar(request.getEmpresa());
			response.setEmpresa(empresa);
		} catch (Exception e) {
			response.setMensagem(new MensagemTO("12", e.getMessage()));
		}
		return response;
	}
	
	private void validarCadastrar(EmpresaCadastrarRequest request) throws EmpresaCadastrarException {
		Empresa empresa = request.getEmpresa();
		if(EmpresaController.existePorDocumento(empresa.getDocumento())){
			throw new EmpresaCadastrarException("O CPF " + empresa.getDocumento() + "  já está em uso");
		}
		if(EmpresaController.existePorEmail(empresa.getEmail())){
			throw new EmpresaCadastrarException("O E-mail " + empresa.getEmail() + " já está em uso");
		}
	}

	private void validarAutenticar(EmpresaAutenticarRequest request) throws EmpresaAutenticarException{
		if(request.getEmail() == null || request.getEmail().isEmpty()){
			throw new EmpresaAutenticarException("E-mail não informado");
		}
		if(!EmailUtils.validarEmail(request.getEmail())){
			throw new EmpresaAutenticarException("E-mail inválido");
		}
		if(request.getSenha() == null || request.getSenha().isEmpty()){
			throw new EmpresaAutenticarException("Senha não informada");
		}
	}
}