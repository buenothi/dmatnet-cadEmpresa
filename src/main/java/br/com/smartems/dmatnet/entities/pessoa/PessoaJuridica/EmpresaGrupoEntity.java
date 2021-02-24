package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name = "Grupo")
@Entity
@Table(name = "tbl_EmpresaGrupo")
@NamedQueries({
		@NamedQuery(name = "EmpresaGrupo.listarGruposPorUsuario", query = "SELECT grupo FROM EmpresaGrupoEntity grupo "
				+ "inner join grupo.usuarios usuario WHERE usuario.idPessoa in :idUsuario") })
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmpresaGrupoEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idGrupo;
	private String nomeGrupo;
	private String descricaoGrupo;

	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "grupo")
	private List<EmpresaEntity> empresas;

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "tbl_usuarioGruposEmpresas_joinTable", joinColumns = @JoinColumn(name = "usuario_ID"), inverseJoinColumns = @JoinColumn(name = "grupo_ID"))
	private List<UsuarioEntity> usuarios;

	private static final long serialVersionUID = 1L;

}
