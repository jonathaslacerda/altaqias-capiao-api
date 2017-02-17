package altaqias.ragatanga.api.task;

import java.util.Timer;
import java.util.TimerTask;

import org.hibernate.Session;

import altaqias.ragatanga.api.persistence.HibernateFactory;

/**
* @author jonny
* Classe agendadora de tarefas
*
*/
public class AgendadorTarefas{

	public void start(){
//		task para download de selos
		Session session = HibernateFactory.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		final Timer timerEnvio = new Timer(); 
		TimerTask taskEnvio = new TaskTODO();
		timerEnvio.schedule(taskEnvio, 1000, 60000); 
		//this.commitTransation();
	}
}
