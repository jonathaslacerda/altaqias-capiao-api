package altaqias.ragatanga.api.controller;

import java.util.List;

import org.hibernate.Session;

import altaqias.ragatanga.api.persistence.HibernateFactory;
import altaqias.ragatanga.api.query.LocalizacaoQuery;
import altaqias.ragatanga.model.Cidade;
import altaqias.ragatanga.model.Destino;
import altaqias.ragatanga.model.Estado;
import altaqias.ragatanga.model.Pais;

public class LocalizacaoController {

	@SuppressWarnings("unchecked")
	public static List<Pais> todosOsPaises(){
		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		List<Pais> resultado = (List<Pais>) session.createQuery(LocalizacaoQuery.PAISES).list();
		session.close();
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Estado> estadosPorPais(Pais pais){
		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		List<Estado> resultado = (List<Estado>) session.createQuery(LocalizacaoQuery.ESTADOS_POR_PAIS)
				.setParameter("pais", pais)
				.list();
		session.close();
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Cidade> cidadesPorEstado(Estado estado){
		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		List<Cidade> resultado = (List<Cidade>) session.createQuery(LocalizacaoQuery.CIDADES_POR_ESTADO)
				.setParameter("estado", estado)
				.list();
		session.close();
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Destino> destinosPorCidade(Cidade cidade){
		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		List<Destino> resultado = (List<Destino>) session.createQuery(LocalizacaoQuery.DESTINOS_POR_CIDADE)
				.setParameter("cidade", cidade)
				.list();
		session.close();
		return resultado;
	}
}
