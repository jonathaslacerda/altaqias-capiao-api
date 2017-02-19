package altaqias.ragatanga.api.webservice.resources;

import altaqias.ragatanga.api.controller.ClienteController;
import altaqias.ragatanga.api.controller.QuestController;
import altaqias.ragatanga.api.webservice.exception.RegistroNaoEncontradoException;
import altaqias.ragatanga.model.Quest;
import altaqias.ragatanga.to.MensagemTO;
import altaqias.ragatanga.to.QuestCriarRequest;
import altaqias.ragatanga.to.QuestCriarResponse;
import altaqias.ragatanga.to.QuestEntrarRequest;
import altaqias.ragatanga.to.QuestEntrarResponse;

public class QuestResource {

	public QuestCriarResponse criar(QuestCriarRequest request) {
		QuestCriarResponse response = new QuestCriarResponse();
		try {
			Quest quest = QuestController.cadastrar(request.getQuest());
			response.setQuest(quest);
		} catch (Exception e) {
			response.setMensagem(new MensagemTO("22", e.getMessage()));
		}
		return response;
	}

	public QuestEntrarResponse entrar(QuestEntrarRequest request) {
		QuestEntrarResponse response = new QuestEntrarResponse();
		try {
			this.questEntrarValidar(request);
			QuestController.entrar(request);
		} catch (RegistroNaoEncontradoException e) {
			response.setMensagem(new MensagemTO("24", e.getMessage()));
		}
		return response;
	}

	private void questEntrarValidar(QuestEntrarRequest request) throws RegistroNaoEncontradoException {
		if(!QuestController.existePorId(request.getIdQuest())){
			throw new RegistroNaoEncontradoException("A Quest informada não foi encontrada");
		}
		if(!ClienteController.existePorId(request.getIdCliente())){
			throw new RegistroNaoEncontradoException("O cliente informado não foi encontrado");
		}
		
	}

}
