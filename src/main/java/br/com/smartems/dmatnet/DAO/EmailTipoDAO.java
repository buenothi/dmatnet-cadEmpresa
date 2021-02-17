package br.com.smartems.dmatnet.DAO;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.EmailTipoEntity;

@Typed(EmailTipoDAO.class)
@RequestScoped
public class EmailTipoDAO extends AbstractDAO<EmailTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public EmailTipoDAO() {
		super(EmailTipoEntity.class);
	}
}
