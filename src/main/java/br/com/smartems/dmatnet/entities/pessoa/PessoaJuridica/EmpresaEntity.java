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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.smartems.dmatnet.entities.LocalTrabalho.LocalTrabalhoEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "Empresa")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "tbl_Empresa")
@NamedQueries({
		@NamedQuery(name = "Empresa.listarEmpresasPorUsuario", query = "SELECT empresa FROM EmpresaEntity empresa inner join empresa.usuarioCriador usuario WHERE usuario.idPessoa in :idUsuario") })
@Getter
@Setter
@NoArgsConstructor
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

	@Getter
	private static final long serialVersionUID = 1L;

}
