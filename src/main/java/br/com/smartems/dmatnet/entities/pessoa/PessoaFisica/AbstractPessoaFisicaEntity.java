package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.smartems.dmatnet.entities.pessoa.AbstractPessoaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractPessoaFisicaEntity extends AbstractPessoaEntity implements Serializable {
	
	private int genero;
	
	private int raca;
	
	private int estadoCivil;
	
	private PessoaFisicaDocumentosEntity documentosPessoais;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	private static final long serialVersionUID = 1L;

}
