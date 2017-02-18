package altaqias.ragatanga.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Table(name="cliente")
@Entity
@DynamicUpdate(value=true)
@DynamicInsert(value=true)
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cliente {

	@Getter @Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	@Column(name="documento", columnDefinition="VARCHAR(11)", nullable=false)
	private String documento;
	
	@Getter @Setter
	@Column(name="nome", columnDefinition="VARCHAR(255)", nullable=false)
	private String nome;
	
	@Getter @Setter
	@Column(name="email", columnDefinition="VARCHAR(50)", nullable=false)
	private String email;
	
	@Getter @Setter
	@Column(name="senha", columnDefinition="VARCHAR(25)", nullable=false)
	private String senha;
	
	@Getter @Setter
	@Column(name="telefone", columnDefinition="VARCHAR(12)", nullable=false)
	private String telefone;
	
	@Getter @Setter
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="nacionalidade")
	private Pais nacionalidade;
	
	@Getter @Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	@Getter @Setter
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "idiomas_clientes", joinColumns = @JoinColumn(name = "idioma"), inverseJoinColumns = @JoinColumn(name = "cliente"))
	private List<Idioma> idiomas;
	
}
