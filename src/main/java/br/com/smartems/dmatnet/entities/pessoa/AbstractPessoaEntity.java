package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "enderecos", "telefones", "emails", "dataCadastroPessoa", "usuarioCriador" })
public abstract class AbstractPessoaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPessoa;

	private String nome;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PESSOA_ID")
	private Set<EnderecoEntity> enderecos;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PESSOA_ID")
	private Set<TelefoneEntity> telefones;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PESSOA_ID")
	private Set<EmailEntity> emails;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastroPessoa;

	@ManyToOne
	@JoinColumn(name = "usuarioCriador_ID")
	private UsuarioEntity usuarioCriador;

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "PessoaEntity [idPessoa=" + idPessoa + ", nome=" + nome + "]";
	}

}
