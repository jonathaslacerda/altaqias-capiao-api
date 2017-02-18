package altaqias.ragatanga.api.webservice.response;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class SampleResponse extends APIResponse {
	
	@Getter @Setter
	private Map<Integer, Integer> quantidades;
	
	public SampleResponse(){
		this.quantidades = new HashMap<Integer, Integer>();
	}
	
}
