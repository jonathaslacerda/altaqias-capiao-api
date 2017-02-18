package altaqias.ragatanga.api.controller;

import org.hibernate.Session;

import altaqias.ragatanga.api.persistence.HibernateFactory;
import altaqias.ragatanga.api.query.EmpresaQuery;
import altaqias.ragatanga.model.Empresa;

public class EmpresaController {
	public static Empresa cadastrar(Empresa empresa){
		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		empresa = (Empresa) session.merge(empresa);
		session.getTransaction().commit();
		session.close();
		return empresa;
	}
	
	public static Empresa autenticar(String email, String senha){
		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		Empresa empresa = (Empresa) session.createQuery(EmpresaQuery.LOGIN).
		setParameter("email", email).
		setParameter("senha", senha).
		uniqueResult();
		session.close();
		return empresa;
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
		autenticar("opamail", "ioasenha");
	}
}
