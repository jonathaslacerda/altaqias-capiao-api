package altaqias.ragatanga.api.persistence;

public abstract class HibernateResource {
	
	/*private static Session session;
	
	protected Session getSession(){
		if(session == null || !session.isOpen()){
			session = HibernateFactory.getSessionFactory().openSession();
		}
		return session;
	}
	
	protected void openTransaction(){
		session = getSession();
		session.getTransaction().begin();
	}
	
	protected void commitTransation(){
		session.getTransaction().commit();
		//session.clear();
		session.close();
	}*/
	
}
