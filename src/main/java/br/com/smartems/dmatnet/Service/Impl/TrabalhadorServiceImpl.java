package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.smartems.dmatnet.DAO.DAOImpl.TrabalhadorDAOImpl;
import br.com.smartems.dmatnet.entities.pessoa.EmailEntity;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoEntity;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.PessoaFisicaDocumentosEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.DeficienciaFisicaEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorCadastroEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Trabalhador.TrabalhadorEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@RequestScoped
public class TrabalhadorServiceImpl {

	public TrabalhadorServiceImpl() {
	}

	@Inject
	private TrabalhadorDAOImpl trabalhadorEAO;

	public TrabalhadorEntity read(long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(TrabalhadorEntity entity) {
		// TODO Auto-generated method stub

	}

	public TrabalhadorEntity update(TrabalhadorEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(TrabalhadorEntity entity) {
		// TODO Auto-generated method stub

	}

	public List<TrabalhadorEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvarNovoTrabalhador(UsuarioEntity usuario, EmpresaEntity empresaSelecionada,
			TrabalhadorEntity trabalhadorNovo, TrabalhadorCadastroEntity trabalhadorCadastroAtual,
			List<TrabalhadorCadastroEntity> trabalhadorListaCadastroHistorico,
			PessoaFisicaDocumentosEntity trabalhadorDocumentos, EnderecoEntity enderecoAtual,
			List<EnderecoEntity> enderecosHistorico, EmailEntity emailAtual, List<EmailEntity> emailsHistorico,
			TelefoneEntity telefonePrincipal, List<TelefoneEntity> telefones,
			DeficienciaFisicaEntity deficienciaFisica)
			throws Exception {
		trabalhadorEAO.salvarNovoTrabalhador(usuario, empresaSelecionada, trabalhadorNovo, trabalhadorCadastroAtual,
				trabalhadorListaCadastroHistorico, trabalhadorDocumentos, enderecoAtual, enderecosHistorico, emailAtual,
				emailsHistorico, telefonePrincipal, telefones);
	}

}
