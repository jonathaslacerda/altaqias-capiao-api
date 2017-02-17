package altaqias.ragatanga.api.webservice.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import altaqias.ragatanga.api.webservice.resources.SampleResource;
import altaqias.ragatanga.api.webservice.response.SampleResponse;
import altaqias.ragatanga.api.webservice.to.SampleTO;

@Path("/")
public class SIGSService {

	@POST
	@Path("/sample")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public SampleResponse obterSelo(SampleTO sampleTo){
		SampleResource resource = new SampleResource();
		return resource.sample(sampleTo);
	}
	
}
