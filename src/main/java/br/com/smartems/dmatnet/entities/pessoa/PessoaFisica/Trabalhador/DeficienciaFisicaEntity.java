package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_deficienciafisica")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class DeficienciaFisicaEntity implements Serializable {

	@Id
	private long idDeficienciaFisica;

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeficiencia;

	private boolean isDeficienciaFisica;
	private boolean isDeficienciaVisual;
	private boolean isDeficienciaAuditiva;
	private boolean isDeficienciaMental;
	private boolean isDeficienciaIntelectual;
	private boolean isReabilitadoReadaptado;
	private String observacao;

}
