package altaqias.ragatanga.api.webservice.configs;

import org.glassfish.jersey.server.ResourceConfig;

import altaqias.ragatanga.api.task.AgendadorTarefas;

public class APIApplication extends ResourceConfig {

	public APIApplication() {
		register(JacksonFeature.class);  
		packages("altaqias.ragatanga.api.webservice.services"); 
		
		startTasks();
	}

	private void startTasks(){
		AgendadorTarefas tarefas = new AgendadorTarefas();
	    tarefas.start();
	}
}
