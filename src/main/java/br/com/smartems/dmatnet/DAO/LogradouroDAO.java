package br.com.smartems.dmatnet.DAO;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.smartems.dmatnet.entities.pessoa.EnderecoTipoEntity;

@Typed(LogradouroDAO.class)
@RequestScoped
public class LogradouroDAO extends AbstractDAO<EnderecoTipoEntity, Long> {

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public LogradouroDAO() {
		super(EnderecoTipoEntity.class);
	}

}
