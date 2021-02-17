package br.com.smartems.dmatnet.Service.Impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.smartems.dmatnet.DAO.EstadosDAO;
import br.com.smartems.dmatnet.entities.cidades.CidadeEntity;
import br.com.smartems.dmatnet.entities.cidades.EstadoEntity;

@Named
@RequestScoped
public class EstadoFacade {

	@Inject
	private EstadosDAO estadosEAO;

	public EstadoEntity read(long pk) {
		return estadosEAO.read(pk);
	}

	public void create(EstadoEntity entity) {
		estadosEAO.create(entity);
	}

	public EstadoEntity update(EstadoEntity entity) {
		return estadosEAO.update(entity);
	}

	public void delete(EstadoEntity entity) {
		estadosEAO.delete(entity);
	}

	public List<EstadoEntity> findAll() {
		return estadosEAO.findAll();
	}
	
	public List<CidadeEntity> listarCidadesPorEstado(EstadoEntity estado){
		return estadosEAO.listarCidadesPorEstado(estado);
	}

}
