package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.smartems.dmatnet.DAO.UsuarioDAO;
import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Named
@RequestScoped
public class UsuarioFacade {

	@Inject
	private UsuarioDAO usuarioEAO;

	public UsuarioFacade() {
	}

	public UsuarioEntity read(long pk) {
		return usuarioEAO.read(pk);
	}

	public void create(UsuarioEntity usuario) {
		usuarioEAO.create(usuario);
	}

	public UsuarioEntity update(UsuarioEntity usuario) {
		return usuarioEAO.update(usuario);
	}

	public void delete(UsuarioEntity usuario) {
		usuarioEAO.delete(usuario);
	}

	public List<UsuarioEntity> findAll() {
		return usuarioEAO.findAll();
	}

	public UsuarioEntity logarUsuario(String login, String senha) {
		return usuarioEAO.logarUsuario(login, senha);
	}

	public List<UsuarioEntity> listarUsuariosFilhos(UsuarioEntity usuarioPai) {
		return usuarioEAO.listarUsuariosFilhos(usuarioPai);
	}

	public String gerarNovaSenha(UsuarioEntity usuario) {
		return usuarioEAO.gerarNovaSenha(usuario);
	}

	public UsuarioEntity salvarNovoUsuario(UsuarioEntity usuario, UsuarioEntity usuarioPai,
			PessoaFisicaDocumentosEntity documento, EnderecoEntity endereço, Set<EmailEntity> emails,
			Set<TelefoneEntity> telefones, List<EmpresaEntity> empresasAtribuidas) {
		return usuarioEAO.salvarNovoUsuario(usuario, usuarioPai, documento, endereço, emails, telefones,
				empresasAtribuidas);
	}

	public UsuarioEntity alterarUsuario(UsuarioEntity usuarioAtual, PessoaFisicaDocumentosEntity documento,
			List<EnderecoEntity> enderecos, Set<EmailEntity> emails, Set<TelefoneEntity> telefones,
			List<EmpresaEntity> empresasAtribuidas) {
		return usuarioEAO.alterarUsuario(usuarioAtual, documento, enderecos, emails, telefones, empresasAtribuidas);
	}

	public EnderecoEntity selecionarEnderecoUsuarioAtual(UsuarioEntity usuario) throws Exception {
		return usuarioEAO.selecionarEnderecoUsuarioAtual(usuario);
	}

	public List<EnderecoEntity> selecionarEnderecosUsuarioHistorico(EnderecoEntity enderecoAtual,
			UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioEAO.selecionarEnderecosUsuarioHistorico(enderecoAtual, usuarioSelecionado);
	}

	public EmailEntity selecionarEmailUsuarioPrincipal(UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioEAO.selecionarEmailUsuarioPrincipal(usuarioSelecionado);
	}

	public Set<EmailEntity> selecionarEmailsSecundarios(EmailEntity emailPrincipal, UsuarioEntity usuarioSelecionado)
			throws Exception {
		return usuarioEAO.selecionarEmailsSecundarios(emailPrincipal, usuarioSelecionado);
	}

	public Set<TelefoneEntity> obterTelefonesUsuario(UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioEAO.obterTelefonesUsuario(usuarioSelecionado);
	}

	public UsuarioEntity excluirUsuarioDaEmpresa(UsuarioEntity usuarioSelecionado) throws Exception {
		return usuarioEAO.excluirUsuarioDaEmpresa(usuarioSelecionado);
	}
	
}
