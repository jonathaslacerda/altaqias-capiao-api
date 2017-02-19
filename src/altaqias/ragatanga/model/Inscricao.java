package altaqias.ragatanga.model;

import java.math.BigDecimal;

import javax.persistence.Column;
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
public class Inscricao {

	@Getter @Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="quest")
	private Quest quest;
	
	@Getter @Setter
	@Column(name="valor", columnDefinition="DECIMAL(11)")
	private BigDecimal valor;
	
	@Getter @Setter
	@Column(name="nome", columnDefinition="VARCHAR(100)")
	private String tokenAutorizacao;
}
