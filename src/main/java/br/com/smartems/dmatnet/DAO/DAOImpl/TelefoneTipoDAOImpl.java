package br.com.smartems.dmatnet.DAO.DAOImpl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.DAO.AbstractDAO;
import br.com.smartems.dmatnet.entities.pessoa.TelefoneTipoEntity;

@Typed(TelefoneTipoDAOImpl.class)
@RequestScoped
public class TelefoneTipoDAOImpl extends AbstractDAO<TelefoneTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public TelefoneTipoDAOImpl() {
		super(TelefoneTipoEntity.class);
	}

}
