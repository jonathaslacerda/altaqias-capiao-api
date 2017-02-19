package altaqias.ragatanga.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicUpdate(value=true)
@DynamicInsert(value=true)
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Quest {

	@Getter @Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="criador")
	private Cliente criador;
	
	@Getter @Setter
	private Integer maximoParticipantes;
	
	@Getter @Setter
	private BigDecimal valor;
	
	@Getter @Setter
	private Date prazo;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="destino")
	private Destino destino;
	
	@Getter @Setter
	private List<Despesa> despesas;
	
	public Quest(){
		this.despesas = new ArrayList<Despesa>();
	}
}
