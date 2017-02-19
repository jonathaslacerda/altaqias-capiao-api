package altaqias.ragatanga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Servico {

	@Getter @Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	@Column(name="nome", columnDefinition="VARCHAR(100)", nullable=false)
	private String nome;
}
