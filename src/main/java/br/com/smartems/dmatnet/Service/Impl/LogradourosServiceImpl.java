package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.smartems.dmatnet.DAO.DAOImpl.LogradouroDAOImpl;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@RequestScoped
public class LogradourosServiceImpl {

	@Inject
	private LogradouroDAOImpl logradourosEAO;

	public EnderecoTipoEntity read(long pk) {
		return logradourosEAO.read(pk);
	}

	public void create(EnderecoTipoEntity entity) {
		logradourosEAO.create(entity);
	}

	public EnderecoTipoEntity update(EnderecoTipoEntity entity) {
		return logradourosEAO.update(entity);
	}

	public void delete(EnderecoTipoEntity entity) {
		logradourosEAO.delete(entity);
	}

	public List<EnderecoTipoEntity> findAll() {
		return logradourosEAO.findAll();
	}

}
