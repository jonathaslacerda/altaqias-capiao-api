package altaqias.ragatanga.api.task;

import java.util.TimerTask;

import altaqias.ragatanga.api.thread.ThreadTODO;

public class TaskTODO extends TimerTask {

	@Override
	public void run() {		
		ThreadTODO downloadSelo = new ThreadTODO();
		Thread threadDownload = new Thread(downloadSelo);
		threadDownload.start();
	}
}
