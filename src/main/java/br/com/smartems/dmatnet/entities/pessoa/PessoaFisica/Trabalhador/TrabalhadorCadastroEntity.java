package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.AbstractPessoaFisicaCadastro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_trabalhadorCadastro")
@Getter
@Setter
@NoArgsConstructor
public class TrabalhadorCadastroEntity extends AbstractPessoaFisicaCadastro implements Serializable {

	private long idEventoEsocial;
	private Long numNIS;
	private Long numCTPS;
	private Long numCTPSSerie;
	private String ufCTPS;
	private String numOrgaoClasse;

	@OneToOne(mappedBy="trabalhador", cascade={CascadeType.ALL})
	private TrabalhadorEstrangeiroEntity trabalhadorEstrageiro;
	
	@OneToOne(mappedBy="trabalhador", cascade={CascadeType.ALL})
	private TrabalhadorDeficienteEntity trabalhadorDeficiente;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="trabalhador_ID")
	private List<TrabalhadorAfastamentoEntity> afastamentos;
	
	private static final long serialVersionUID = 1L;

}
