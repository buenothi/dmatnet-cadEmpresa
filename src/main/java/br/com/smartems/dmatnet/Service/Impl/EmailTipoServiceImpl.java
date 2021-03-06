package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.smartems.dmatnet.DAO.DAOImpl.EmailTipoDAOImpl;
import br.com.smartems.dmatnet.entities.pessoa.EmailTipoEntity;

@RequestScoped
public class EmailTipoServiceImpl {

	
	@Inject
	private EmailTipoDAOImpl emailTipoEAO;

	public EmailTipoEntity read(long pk) {
		return emailTipoEAO.read(pk);
	}

	public void create(EmailTipoEntity entity) {
		emailTipoEAO.create(entity);
	}

	public EmailTipoEntity update(EmailTipoEntity entity) {
		return emailTipoEAO.update(entity);
	}

	public void delete(EmailTipoEntity entity) {
		emailTipoEAO.delete(entity);
	}

	public List<EmailTipoEntity> findAll() {
		return emailTipoEAO.findAll();
	}

}
