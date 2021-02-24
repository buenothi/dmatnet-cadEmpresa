package br.com.smartems.dmatnet.entities.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_telefoneTipo")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TelefoneTipoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTelefoneTipo;
	private String tipo;
	private static final long serialVersionUID = 1L;

}
