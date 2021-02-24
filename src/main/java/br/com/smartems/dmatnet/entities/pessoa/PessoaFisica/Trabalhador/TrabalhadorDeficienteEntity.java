package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_trabalhadorDeficiente")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TrabalhadorDeficienteEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idPessoa;
	private boolean defFisica;
	private boolean defVisual;
	private boolean defAuditiva;
	private boolean defMental;
	private boolean defIntelectual;
	private boolean reabilitadoReadaptado;
	private String observacao;
	
	@OneToOne(cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private TrabalhadorCadastroEntity trabalhador;
	
	private static final long serialVersionUID = 1L;

	public void setObservacao(String observacao) {
		this.observacao = observacao.toUpperCase();
	}
	
}
