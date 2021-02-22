package br.com.smartems.dmatnet.DAO;

import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

public interface IUsuarioDAO extends IAbstractDAO<UsuarioEntity, Long> {

	public UsuarioEntity logarUsuario(String login, String senha) throws NoResultException;

	public List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuario) throws NoResultException;

	public String gerarNovaSenha(UsuarioEntity usuario);

	public UsuarioEntity salvarNovoUsuario(UsuarioEntity usuario, UsuarioEntity usuarioPai,
			PessoaFisicaDocumentosEntity documento, EnderecoEntity endereco, Set<EmailEntity> emails,
			Set<TelefoneEntity> telefones, List<EmpresaEntity> empresasAtribuidas);

	public UsuarioEntity alterarUsuario(UsuarioEntity usuarioAtual, PessoaFisicaDocumentosEntity documento,
			List<EnderecoEntity> enderecos, Set<EmailEntity> emails, Set<TelefoneEntity> telefones,
			List<EmpresaEntity> empresasAtribuidas);
 
	public EnderecoEntity selecionarEnderecoUsuarioAtual(UsuarioEntity usuario) throws Exception;

	public List<EnderecoEntity> selecionarEnderecosUsuarioHistorico(EnderecoEntity enderecoAtual,
			UsuarioEntity usuarioSelecionado) throws Exception;

	public EmailEntity selecionarEmailUsuarioPrincipal(UsuarioEntity usuarioSelecionado) throws Exception;

	public Set<EmailEntity> selecionarEmailsSecundarios(EmailEntity emailPrincipal, UsuarioEntity usuarioSelecionado)
			throws Exception;

	public Set<TelefoneEntity> obterTelefonesUsuario(UsuarioEntity usuarioSelecionado) throws Exception;
	
	public UsuarioEntity excluirUsuarioDaEmpresa(UsuarioEntity usuarioSelecionado) throws Exception;
}