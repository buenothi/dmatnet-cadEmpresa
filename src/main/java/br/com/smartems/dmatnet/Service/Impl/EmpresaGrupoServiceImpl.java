package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.smartems.dmatnet.DAO.DAOImpl.EmpresaGrupoDAOImpl;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;

@RequestScoped
public class EmpresaGrupoServiceImpl {

	@Inject
	private EmpresaGrupoDAOImpl empresaGrupoEAO;

	public EmpresaGrupoEntity read(long pk) {
		return empresaGrupoEAO.read(pk);
	}

	public void create(EmpresaGrupoEntity entity) {
		empresaGrupoEAO.create(entity);
	}

	public EmpresaGrupoEntity update(EmpresaGrupoEntity entity) {
		return empresaGrupoEAO.update(entity);
	}

	public void delete(EmpresaGrupoEntity entity) {
		empresaGrupoEAO.delete(entity);
	}

	public List<EmpresaGrupoEntity> findAll() {
		return empresaGrupoEAO.findAll();
	}

	public List<EmpresaGrupoEntity> listarGrupoEmpresas(UsuarioEntity usuarioLogado) {
		return empresaGrupoEAO.listarGrupoEmpresas(usuarioLogado);
	}

}
