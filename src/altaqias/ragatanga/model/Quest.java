package altaqias.ragatanga.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Quest {

	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private Cliente criador;
	
	@Getter @Setter
	private BigDecimal valor;
	
	@Getter @Setter
	private Date prazo;
	
	@Getter @Setter
	private Destino destino;
	
	@Getter @Setter
	private List<Servico> servicos;
	
	public Quest(){
		this.servicos = new ArrayList<Servico>();
	}
}
