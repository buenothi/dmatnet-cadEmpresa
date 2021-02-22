package br.com.smartems.dmatnet.DAO.DAOImpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.smartems.dmatnet.DAO.AbstractDAO;
import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Typed(EstadosDAOImpl.class)
@RequestScoped
public class EstadosDAOImpl extends AbstractDAO<EstadoEntity, Long>{

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;
	
	public EstadosDAOImpl() {
		super(EstadoEntity.class);
	}

	@SuppressWarnings("unchecked")
	public List<CidadeEntity> listarCidadesPorEstado(EstadoEntity estado){
		Query query = entityManager.createNamedQuery("Estados.listarTodasCidadesPorEstado", CidadeEntity.class);
		query.setParameter("estado", estado);		
		return (List<CidadeEntity>) query.getResultList();
	}
	
}
