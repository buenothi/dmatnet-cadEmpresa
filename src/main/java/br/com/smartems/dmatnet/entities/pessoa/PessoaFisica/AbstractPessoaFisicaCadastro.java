package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public abstract class AbstractPessoaFisicaCadastro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPessoaCadastro;
	private char sexo;
	private int racaCor;
	private int estadoCivil;
	private int grauInstrucao;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimCadastro;

	private long codMunicipioNascimento;
	private String ufNascimento;
	private long paisNascimento; // conforme tabela 6 do eSocial
	private long nacionalidade; // conforme tabela 6 do eSocial
	private String nomeMae;
	private String nomePai;

	@Embedded
	private PessoaFisicaDocumentosEntity documentos;

	private static final long serialVersionUID = 1L;

}
