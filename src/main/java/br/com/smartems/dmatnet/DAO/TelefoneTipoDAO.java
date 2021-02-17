package br.com.smartems.dmatnet.DAO;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.TelefoneTipoEntity;

@Typed(TelefoneTipoDAO.class)
@RequestScoped
public class TelefoneTipoDAO extends AbstractDAO<TelefoneTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public TelefoneTipoDAO() {
		super(TelefoneTipoEntity.class);
	}

}
