package altaqias.ragatanga.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Table(name="parametro")
@Entity
@DynamicUpdate(value=true)
@DynamicInsert(value=true)
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Parametro implements Serializable{
	
	@Getter @Setter 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Getter @Setter
	@Column(name="chave", columnDefinition="VARCHAR(100)", nullable=false)
	private String chave;
	
	@Getter @Setter
	@Column(name="valor", columnDefinition="VARCHAR(100)", nullable=false)
	private String valor;

}
