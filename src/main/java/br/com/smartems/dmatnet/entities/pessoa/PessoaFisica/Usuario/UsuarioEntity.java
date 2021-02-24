package br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.AbstractPessoaFisicaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;
import br.com.smartems.dmatnet.util.CriptografiaString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "Usuario")
@Entity
@Table(name="tbl_usuarios")
@NamedQueries({
	@NamedQuery(name="Usuario.logarUsuario", 
			query="SELECT u FROM UsuarioEntity u WHERE u.login=:login AND u.senha=:senha"),
	@NamedQuery(name="Usuario.listarUsuariosFilhos", 
			query="SELECT u FROM UsuarioEntity u WHERE u.idUsuarioPai=:idUsuarioPai"),
	@NamedQuery(name="Usuario.listarUsuariosMaster", 
			query="SELECT u, g FROM UsuarioEntity u, UsuarioGrupoEntity g WHERE g.nomeGrupo = 'MASTER'")
})
@Getter
@Setter
@NoArgsConstructor
public class UsuarioEntity extends AbstractPessoaFisicaEntity implements Serializable {

	@Column(unique = true)
	private String login;
	private String senha;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="usuarioGrupo_ID")
	private UsuarioGrupoEntity grupo;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="tbl_usuarioEmpresas_joinTable",
		joinColumns=@JoinColumn(name="usuario_ID"),
		inverseJoinColumns=@JoinColumn(name="empresa_ID"))
	private Set<EmpresaEntity> empresasGerenciadas;
	
	@JsonBackReference
	@ManyToMany(mappedBy="usuarios")
	private List<EmpresaGrupoEntity> gruposGerenciados;
	
	private Long idUsuarioPai;

	private static final long serialVersionUID = 1L;

	public void setSenha(String senha) {
		CriptografiaString senhaCriptografada = new CriptografiaString();
		this.senha = senhaCriptografada.obterHashString(senha);
	}
	
}
