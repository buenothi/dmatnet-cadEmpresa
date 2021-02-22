package br.com.smartems.dmatnet.DAO.DAOImpl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.DAO.AbstractDAO;
import br.com.smartems.dmatnet.entities.pessoa.EmailTipoEntity;

@Typed(EmailTipoDAOImpl.class)
@RequestScoped
public class EmailTipoDAOImpl extends AbstractDAO<EmailTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public EmailTipoDAOImpl() {
		super(EmailTipoEntity.class);
	}
}
