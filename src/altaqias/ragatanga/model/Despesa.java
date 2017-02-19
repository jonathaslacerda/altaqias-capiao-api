package altaqias.ragatanga.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicUpdate(value=true)
@DynamicInsert(value=true)
//@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Despesa {

	@Getter @Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="quest", nullable=false)
	private Quest quest;
	
	@Getter @Setter
	@Column(name="valor", columnDefinition="DECIMAL(11)", nullable=false)
	private BigDecimal valor;
	
	@Getter @Setter
	@Column(name="descricao", columnDefinition="VARCHAR(100)", nullable=false)
	private String descricao;
	
	@Getter @Setter
	@Transient
	private List<Autorizacao> autorizacoes;
}
