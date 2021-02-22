package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.smartems.dmatnet.DAO.IUsuarioDAO;
import br.com.smartems.dmatnet.Service.IUsuarioService;
import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@RequestScoped
public class UsuarioServiceImpl implements IUsuarioService<UsuarioEntity> {

	@Inject
	private IUsuarioDAO usuarioDAO;

	public UsuarioServiceImpl() {
	}

	public UsuarioEntity read(long pk) {
		return usuarioDAO.read(pk);
	}

	public void create(UsuarioEntity usuario) {
		usuarioDAO.create(usuario);
	}

	public UsuarioEntity update(UsuarioEntity usuario) {
		return usuarioDAO.update(usuario);
	}

	public void delete(UsuarioEntity usuario) {
		usuarioDAO.delete(usuario);
	}

	public List<UsuarioEntity> findAll() {
		return usuarioDAO.findAll();
	}

	public UsuarioEntity logarUsuario(String login, String senha) {
		return usuarioDAO.logarUsuario(login, senha);
	}

	public List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuarioPai) {
		return usuarioDAO.listarUsuariosFilhos(usuarioPai);
	}

	public String gerarNovaSenha(UsuarioEntity usuario) {
		return usuarioDAO.gerarNovaSenha(usuario);
	}

	public UsuarioEntity salvarNovoUsuario(UsuarioEntity usuario, UsuarioEntity usuarioPai,
			PessoaFisicaDocumentosEntity documento, EnderecoEntity endereço, Set<EmailEntity> emails,
			Set<TelefoneEntity> telefones, List<EmpresaEntity> empresasAtribuidas) {
		return usuarioDAO.salvarNovoUsuario(usuario, usuarioPai, documento, endereço, emails, telefones,
				empresasAtribuidas);
	}

	public UsuarioEntity alterarUsuario(UsuarioEntity usuarioAtual, PessoaFisicaDocumentosEntity documento,
			List<EnderecoEntity> enderecos, Set<EmailEntity> emails, Set<TelefoneEntity> telefones,
			List<EmpresaEntity> empresasAtribuidas) {
		return usuarioDAO.alterarUsuario(usuarioAtual, documento, enderecos, emails, telefones, empresasAtribuidas);
	}

	public EnderecoEntity selecionarEnderecoUsuarioAtual(UsuarioEntity usuario) throws Exception {
		return usuarioDAO.selecionarEnderecoUsuarioAtual(usuario);
	}

	public List<EnderecoEntity> selecionarEnderecosUsuarioHistorico(EnderecoEntity enderecoAtual,
			UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioDAO.selecionarEnderecosUsuarioHistorico(enderecoAtual, usuarioSelecionado);
	}

	public EmailEntity selecionarEmailUsuarioPrincipal(UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioDAO.selecionarEmailUsuarioPrincipal(usuarioSelecionado);
	}

	public Set<EmailEntity> selecionarEmailsSecundarios(EmailEntity emailPrincipal, UsuarioEntity usuarioSelecionado)
			throws Exception {
		return usuarioDAO.selecionarEmailsSecundarios(emailPrincipal, usuarioSelecionado);
	}

	public Set<TelefoneEntity> obterTelefonesUsuario(UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioDAO.obterTelefonesUsuario(usuarioSelecionado);
	}

	public UsuarioEntity excluirUsuarioDaEmpresa(UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioDAO.excluirUsuarioDaEmpresa(usuarioSelecionado);
	}
	
}
