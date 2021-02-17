package br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.smartems.dmatnet.entities.LocalTrabalho.LocalTrabalhoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;

@XmlRootElement(name = "empresa")
@Entity
@Table(name = "tbl_Empresa")
@NamedQueries({
		@NamedQuery(name = "Empresa.listarEmpresasPorUsuario", query = "SELECT empresa FROM EmpresaEntity empresa inner join empresa.usuarioCriador usuario WHERE usuario.idPessoa in :idUsuario") })
public class EmpresaEntity extends AbstractPessoaJuridicaEntity implements Serializable {

	private long codESocialEmpresa;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "grupo_ID")
	private EmpresaGrupoEntity grupo;
	
	@JsonManagedReference
	@XmlElement(name = "cadastros")
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_ID")
	private Set<EmpresaCadastroEntity> cadastros;

	@JsonManagedReference
	@XmlElement(name = "locais")
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_ID")
	private Set<LocalTrabalhoEntity> locais;
	
	@JsonManagedReference
	@XmlElement(name = "trabalhadores")
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_ID")
	private Set<TrabalhadorEntity> trabalhadores;

	@JsonManagedReference
	@XmlElement(name = "usuarios")
	@ManyToMany(mappedBy = "empresasGerenciadas", fetch = FetchType.EAGER)
	private Set<UsuarioEntity> usuarios;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresaFoto_ID")
	private EmpresaFoto empresaFotoFachada;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE }, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "empresaLogotipo_ID")
	private EmpresaLogotipo empresaLogotipo;

	private String tipoEstabelecimento;

	private static final long serialVersionUID = 1L;

	public EmpresaEntity() {
		super();
	}

	public long getCodESocialEmpresa() {
		return this.codESocialEmpresa;
	}

	public void setCodESocialEmpresa(long codESocialEmpresa) {
		this.codESocialEmpresa = codESocialEmpresa;
	}

	public EmpresaGrupoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(EmpresaGrupoEntity grupo) {
		this.grupo = grupo;
	}

	public Set<EmpresaCadastroEntity> getCadastros() {
		return cadastros;
	}

	public void setCadastros(Set<EmpresaCadastroEntity> cadastros) {
		this.cadastros = cadastros;
	}

	public Set<LocalTrabalhoEntity> getLocais() {
		return locais;
	}

	public void setLocais(Set<LocalTrabalhoEntity> locais) {
		this.locais = locais;
	}

	public Set<TrabalhadorEntity> getTrabalhadores() {
		return trabalhadores;
	}

	public void setTrabalhadores(Set<TrabalhadorEntity> trabalhadores) {
		this.trabalhadores = trabalhadores;
	}

	public String getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(String tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public Set<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	public EmpresaFoto getEmpresaFotoFachada() {
		return empresaFotoFachada;
	}

	public void setEmpresaFotoFachada(EmpresaFoto empresaFotoFachada) {
		this.empresaFotoFachada = empresaFotoFachada;
	}

	public EmpresaLogotipo getEmpresaLogotipo() {
		return empresaLogotipo;
	}

	public void setEmpresaLogotipo(EmpresaLogotipo empresaLogotipo) {
		this.empresaLogotipo = empresaLogotipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
