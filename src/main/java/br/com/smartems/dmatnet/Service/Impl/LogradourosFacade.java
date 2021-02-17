package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.smartems.dmatnet.DAO.LogradouroDAO;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@Named
@RequestScoped
public class LogradourosFacade {

	@Inject
	private LogradouroDAO logradourosEAO;

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
