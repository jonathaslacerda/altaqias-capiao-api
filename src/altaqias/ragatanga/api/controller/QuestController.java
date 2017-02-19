package altaqias.ragatanga.api.controller;

import java.util.List;

import org.hibernate.Session;

import altaqias.ragatanga.api.persistence.HibernateFactory;
import altaqias.ragatanga.api.query.QuestQuery;
import altaqias.ragatanga.api.webservice.exception.RegistroNaoEncontradoException;
import altaqias.ragatanga.model.Cliente;
import altaqias.ragatanga.model.Inscricao;
import altaqias.ragatanga.model.Quest;
import altaqias.ragatanga.to.QuestEntrarRequest;

public class QuestController {
	public static Quest cadastrar(Quest quest){
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

	public static void entrar(QuestEntrarRequest request) throws RegistroNaoEncontradoException {
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		try {
			Quest quest = ler(request.getIdQuest());
			Cliente cliente = ClienteController.lerPorId(request.getIdCliente());
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
}
