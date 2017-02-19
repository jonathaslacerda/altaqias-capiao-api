package altaqias.ragatanga.api.controller;

import java.util.List;

import org.hibernate.Session;

import altaqias.ragatanga.api.persistence.HibernateFactory;
import altaqias.ragatanga.api.query.ClienteQuery;
import altaqias.ragatanga.api.webservice.exception.ClienteAutenticarException;
import altaqias.ragatanga.model.Cliente;

public class ClienteController {
	public static Cliente cadastrar(Cliente cliente){
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(cliente);
		session.getTransaction().commit();
		session.close();
		return cliente;
	}
	
	public static Cliente autenticar(String email, String senha) throws ClienteAutenticarException{
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		Cliente cliente = (Cliente) session.createQuery(ClienteQuery.AUTENTICAR)
				.setParameter("email", email)
				.setParameter("senha", senha)
				.uniqueResult();
		session.close();
		if(cliente == null){
			throw new ClienteAutenticarException("Usuário não encontrado com as credenciais informadas");
		}
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean existePorEmail(String email){
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Cliente> clientes = (List<Cliente>) session.createQuery(ClienteQuery.EXISTE_POR_EMAIL).
		setParameter("email", email).
		list();
		session.close();
		return clientes.size() > 0 ? true : false;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean existePorDocumento(String documento){
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		List<Cliente> clientes = (List<Cliente>) session.createQuery(ClienteQuery.EXISTE_POR_DOCUMENTO).
		setParameter("documento", documento).
		list();
		session.close();
		return clientes.size() > 0 ? true : false;
	}
	
	public static void main(String[] args) {
		existePorDocumento("ioasenha");
	}
}
