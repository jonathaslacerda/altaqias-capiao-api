package altaqias.ragatanga.api.controller;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Session;

import altaqias.ragatanga.api.persistence.HibernateFactory;
import altaqias.ragatanga.api.query.QuestQuery;
import altaqias.ragatanga.api.webservice.exception.RegistroNaoEncontradoException;
import altaqias.ragatanga.model.Cliente;
import altaqias.ragatanga.model.Inscricao;
import altaqias.ragatanga.model.Quest;
import autorizador.api.controller.Processador;
import autorizador.api.exception.AutorizacaoException;
import autorizador.api.model.ConfirmacaoPagamento;

public class QuestController {

	@SuppressWarnings("unchecked")
	public static List<Quest> ultimas(int quantidade){
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Quest> resultado = (List<Quest>) session.createQuery(QuestQuery.ULTIMAS_QUESTS_ABERTAS)
				.setMaxResults(quantidade)
				.list();
		session.close();
		return resultado;
	}

	public static Quest criar(Quest quest){
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(quest);
		session.getTransaction().commit();
		session.close();
		return quest;
	}

	@SuppressWarnings("unchecked")
	public static boolean existePorId(Integer idQuest) {
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Quest> quests = (List<Quest>) session.createQuery(QuestQuery.EXISTE_POR_ID)
				.setParameter("id", idQuest)
				.list();
		session.close();
		return quests.size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public static Quest ler(Integer idQuest) throws RegistroNaoEncontradoException {
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Quest> quests = (List<Quest>) session.createQuery(QuestQuery.LER)
				.setParameter("id", idQuest)
				.list();
		session.close();
		if(quests == null || quests.isEmpty()){
			throw new RegistroNaoEncontradoException("A quest informada não foi encontrada");
		}
		return quests.get(0);
	}

	public static void entrar(Integer idCliente, Integer idQuest) throws RegistroNaoEncontradoException {
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		try {
			Quest quest = ler(idQuest);
			Cliente cliente = ClienteController.lerPorId(idCliente);
			Inscricao inscricao = new Inscricao();
			inscricao.setCliente(cliente);
			inscricao.setQuest(quest);
			session.saveOrUpdate(inscricao);
			session.getTransaction().commit();
			session.close();
		} catch (RegistroNaoEncontradoException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Inscricao> inscricoesPendentes(Cliente cliente) {
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Inscricao> inscricoes = (List<Inscricao>) session.createQuery(QuestQuery.INSCRICOES_PENDENTES_ID_CLIENTE)
				.setParameter("id", cliente.getId())
				.list();
		session.close();
		return inscricoes;
	}

	public static Quest pagar(Cliente cliente, Quest quest, BigDecimal valor) throws AutorizacaoException, RegistroNaoEncontradoException {
		try {
			Session session = HibernateFactory.getSessionFactory().openSession();
			session.getTransaction().begin();
			ConfirmacaoPagamento pagamento = Processador.autorizar(cliente, valor);
			pagamento.tokenizar();
			quest = ler(quest.getId());
			for (Inscricao inscr : quest.getInscricoes()) {
				if(inscr.getCliente().getId() == cliente.getId()){
					quest.getFundo().add(pagamento.getValor());
					inscr.setValor(pagamento.getValor());
					inscr.setTokenAutorizacao(pagamento.getToken());
					break;
				}
			}
			session.saveOrUpdate(quest);
			session.getTransaction().commit();
			session.close();
			return quest;
		} catch (AutorizacaoException e) {
			throw e;
		} catch (NoSuchAlgorithmException e) {
			throw new AutorizacaoException("Erro na autorização: " + e.getMessage());
		} catch (RegistroNaoEncontradoException e) {
			throw e;
		}
		
	}
}
