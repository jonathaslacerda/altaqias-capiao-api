package altaqias.ragatanga.api.webservice.to;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class SampleTO {
	@Getter @Setter
	private Integer sistema;
	@Getter @Setter
	private List<Integer> tipos;
	
	public SampleTO(Integer sistema, List<Integer> tipos){
		this.sistema = sistema;
		this.tipos = tipos;
	}
	
	public SampleTO(){ 
		
	}
}
