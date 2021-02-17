package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.smartems.dmatnet.DAO.TelefoneTipoDAO;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneTipoEntity;

@Named
@RequestScoped
public class TelefoneTipoFacade {
	
	@Inject
	private TelefoneTipoDAO telefoneTipoEAO;

	public TelefoneTipoEntity read(long pk) {
		return telefoneTipoEAO.read(pk);
	}

	public void create(TelefoneTipoEntity entity) {
		telefoneTipoEAO.create(entity);
	}

	public TelefoneTipoEntity update(TelefoneTipoEntity entity) {
		return telefoneTipoEAO.update(entity);
	}

	public void delete(TelefoneTipoEntity entity) {
		telefoneTipoEAO.delete(entity);
	}

	public List<TelefoneTipoEntity> findAll() {
		return telefoneTipoEAO.findAll();
	}

}
