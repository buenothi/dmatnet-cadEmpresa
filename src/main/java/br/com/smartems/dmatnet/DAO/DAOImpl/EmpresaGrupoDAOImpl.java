package br.com.smartems.dmatnet.DAO.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.smartems.dmatnet.DAO.AbstractDAO;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaGrupoEntity;

@Typed(EmpresaGrupoDAOImpl.class)
@RequestScoped
public class EmpresaGrupoDAOImpl extends AbstractDAO<EmpresaGrupoEntity, Long>{

	@PersistenceContext(unitName = "dmatnet-pu")
	private EntityManager entityManager;

	public EmpresaGrupoDAOImpl() {
		super(EmpresaGrupoEntity.class);
	}

	@SuppressWarnings("unchecked")
	public List<EmpresaGrupoEntity> listarGrupoEmpresas(UsuarioEntity usuarioLogado) throws NoResultException {
		List<EmpresaGrupoEntity> listaGruposEmpresa = new ArrayList<EmpresaGrupoEntity>();
		//verificar se o usuário é Master, caso seja lista todos, caso não somente o que o usuário tem autorização
		if (usuarioLogado.getGrupo().getIdGrupo() == 1) {
			listaGruposEmpresa = findAll();
		} else {
			Query query = entityManager.createNamedQuery("EmpresaGrupo.listarGruposPorUsuario", EmpresaGrupoEntity.class);
			query.setParameter("idUsuario", usuarioLogado.getIdPessoa());
			listaGruposEmpresa = (List<EmpresaGrupoEntity>) query.getResultList();
			entityManager.flush();
		}
		return listaGruposEmpresa;
	}
}
