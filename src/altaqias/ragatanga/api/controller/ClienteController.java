package altaqias.ragatanga.api.controller;

import org.hibernate.Session;

import altaqias.ragatanga.api.persistence.HibernateFactory;
import altaqias.ragatanga.api.query.ClienteQuery;
import altaqias.ragatanga.model.Cliente;

public class ClienteController {
	public static Cliente cadastrar(Cliente cliente){
		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		cliente = (Cliente) session.merge(cliente);
		session.getTransaction().commit();
		session.close();
		return cliente;
	}
	
	public static Cliente logar(String email, String senha){
		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		Cliente cliente = (Cliente) session.createQuery(ClienteQuery.LOGIN).
		setParameter("email", email).
		setParameter("senha", senha).
		uniqueResult();
		session.close();
		return cliente;
	}
	
	public static boolean existePorEmail(String email){
		// TODO
		return false;
	}
	
	public static boolean existePorDocumento(String documento){
		// TODO
		return false;
	}
	
	public static void main(String[] args) {
		logar("opamail", "ioasenha");
	}
}
