package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_trabalhadorAfastamentos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TrabalhadorAfastamentoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAfastamento;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	
	@Temporal(TemporalType.DATE)
	private Date dataRetornoEfetivo;
	
	private int codMotivoAfastamento;//informar código da tabela 18 do eSocial
	
	private static final long serialVersionUID = 1L;
	
}
