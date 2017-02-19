package altaqias.ragatanga.api.webservice.resources;

import java.util.List;

import altaqias.ragatanga.api.controller.ClienteController;
import altaqias.ragatanga.api.controller.QuestController;
import altaqias.ragatanga.api.webservice.exception.RegistroNaoEncontradoException;
import altaqias.ragatanga.model.Inscricao;
import altaqias.ragatanga.model.Quest;
import altaqias.ragatanga.to.InscricoesPendentesRequest;
import altaqias.ragatanga.to.InscricoesPendentesResponse;
import altaqias.ragatanga.to.MensagemTO;
import altaqias.ragatanga.to.QuestCriarRequest;
import altaqias.ragatanga.to.QuestCriarResponse;
import altaqias.ragatanga.to.QuestEntrarRequest;
import altaqias.ragatanga.to.QuestEntrarResponse;
import altaqias.ragatanga.to.QuestPagarRequest;
import altaqias.ragatanga.to.QuestPagarResponse;
import altaqias.ragatanga.to.QuestUltimasResponse;

public class QuestResource {
	
	public QuestUltimasResponse questsUltimas(){
		QuestUltimasResponse response = new QuestUltimasResponse();
		try {
			List<Quest> quests = QuestController.ultimas(20);
			response.setQuests(quests);
		} catch (Exception e) {
			response.setMensagem(new MensagemTO("21", e.getMessage()));
		}
		return response;
	}  

	public QuestCriarResponse criar(QuestCriarRequest request) {
		QuestCriarResponse response = new QuestCriarResponse();
		try {
			Quest quest = QuestController.criar(request.getQuest());
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
			QuestController.entrar(request.getIdCliente(), request.getIdQuest());
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

	public InscricoesPendentesResponse inscricoesPendentes(InscricoesPendentesRequest request) {
		InscricoesPendentesResponse response = new InscricoesPendentesResponse();
		try {
			List<Inscricao> inscricoes = QuestController.inscricoesPendentes(request.getCliente());
			response.setInscricoes(inscricoes);
		} catch (Exception e) {
			response.setMensagem(new MensagemTO("25", e.getMessage()));
		}
		return response;
	}

	public QuestPagarResponse pagar(QuestPagarRequest request) {
		QuestPagarResponse response = new QuestPagarResponse();
		try {
			Quest quest = QuestController.pagar(request.getCliente(), request.getQuest(), request.getValor());
			response.setQuest(quest);
		} catch (Exception e) {
			response.setMensagem(new MensagemTO("26", e.getMessage()));
		}
		return response;
	}

}
