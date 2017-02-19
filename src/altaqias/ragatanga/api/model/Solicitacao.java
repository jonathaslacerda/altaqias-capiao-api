package altaqias.ragatanga.api.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Table(name="solicitacao")
@Entity
@DynamicUpdate(value=true)
@DynamicInsert(value=true)
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Solicitacao implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private long id;
	
	@Column(name="horario", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter
	private Calendar horario;
	
	@Column(name="resultado", nullable=false)
	@Getter @Setter
	private String resultado;
	
	@Column(name="descriçãoSolicitacao", nullable=false)
	@Getter @Setter
	private String descricaoSolicitacao;
	
}
