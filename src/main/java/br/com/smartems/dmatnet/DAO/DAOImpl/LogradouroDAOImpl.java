package br.com.smartems.dmatnet.DAO.DAOImpl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.DAO.AbstractDAO;
import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@Typed(LogradouroDAOImpl.class)
@RequestScoped
public class LogradouroDAOImpl extends AbstractDAO<EnderecoTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public LogradouroDAOImpl() {
		super(EnderecoTipoEntity.class);
	}

}
