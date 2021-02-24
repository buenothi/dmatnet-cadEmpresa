package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_usuariosGrupo")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UsuarioGrupoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGrupo;
	private String nomeGrupo;

	@OneToMany(mappedBy = "grupo")
	private List<UsuarioEntity> usuarios;

	private static final long serialVersionUID = 1L;

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo.toUpperCase();
	}

}
