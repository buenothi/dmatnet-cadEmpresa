package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_trabalhadorEstrangeiro")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TrabalhadorEstrangeiroEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idTrabalhador;
	
	@Temporal(TemporalType.DATE)
	private Date dataChegada;
	private int codClassTrabEstrangeiro;
	private boolean casadoBR;
	private boolean filhosBR;
	
	@OneToOne(cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private TrabalhadorCadastroEntity trabalhador;
	
	private static final long serialVersionUID = 1L;
	
}
