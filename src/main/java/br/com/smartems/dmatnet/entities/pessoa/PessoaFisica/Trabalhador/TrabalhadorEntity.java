package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.AbstractPessoaFisicaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "Trabalhadores")
@Entity
@Table(name = "tbl_trabalhador")
@Getter
@Setter
@NoArgsConstructor
public class TrabalhadorEntity extends AbstractPessoaFisicaEntity implements Serializable {

	private long codESocialEmpregado;// código atribuído ao empregado para atendimento do eSocial

	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Temporal(TemporalType.DATE)
	private Date dataDesligamento;

	private String nomeMae;
	private String nomePai;
	private int grauInstrucao;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "trabalhador_ID")
	private List<TrabalhadorCadastroEntity> cadastrosTrabalhador;

	@OneToOne(cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private DeficienciaFisicaEntity deficienciaFisica;

	private static final long serialVersionUID = 1L;

}
