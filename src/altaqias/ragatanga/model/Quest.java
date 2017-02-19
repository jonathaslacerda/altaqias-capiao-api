package altaqias.ragatanga.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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
	@Column(name="maximoParticipantes", columnDefinition="INTEGER(11)", nullable=false)
	private Integer maximoParticipantes;
	
	@Getter @Setter
	@Column(name="valor", columnDefinition="DECIMAL(11)", nullable=false)
	private BigDecimal valor;
	
	@Getter @Setter
	@Column(name="fundo", columnDefinition="DECIMAL(11)", nullable=false)
	private BigDecimal fundo;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="destino")
	@Cascade({CascadeType.ALL})
	private Destino destino;
	
	@Getter @Setter
	@OneToMany(mappedBy="quest", orphanRemoval=true, fetch=FetchType.EAGER)
	@OrderBy(value="id")
	@Cascade({CascadeType.ALL})
	private List<Inscricao> inscricoes;
	
	public Quest(){
		this.inscricoes = new ArrayList<Inscricao>();
		this.fundo = new BigDecimal(0.0);
	}
}
