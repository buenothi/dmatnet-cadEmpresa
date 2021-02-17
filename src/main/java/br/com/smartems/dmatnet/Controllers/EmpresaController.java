package br.com.smartems.dmatnet.Controllers;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Hibernate;

import br.com.smartems.dmatnet.Service.Impl.PessoaJuridicaFacade;
import br.com.smartems.dmatnet.entities.pessoa.PessoaFisica.Usuario.UsuarioEntity;
import br.com.smartems.dmatnet.entities.pessoa.PessoaJuridica.EmpresaEntity;

@Path("/empresa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpresaController {

	@Inject
	private PessoaJuridicaFacade pessoaJuridicaService;
	
	@GET
	@Path("/{id}")
	public Response read(@PathParam("id") Long pk) {
		EmpresaEntity empresa = pessoaJuridicaService.read(pk);
		Hibernate.initialize(empresa);
		return Response.ok(empresa).build();
	}

	@POST
	public Response create(@Context UriInfo uriInfo, EmpresaEntity entity) {
		pessoaJuridicaService.create(entity);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		URI location = uriBuilder.path("/{id}").build(entity.getIdPessoa());
		return Response.created(location).build();
	}
	
	public EmpresaEntity update(EmpresaEntity entity) {
		return pessoaJuridicaService.update(entity);
	}

	public void delete(EmpresaEntity entity) {
		pessoaJuridicaService.delete(entity);
	}
	
	@GET
	public Response findAll() {
		return Response.ok(pessoaJuridicaService.findAll()).build();
	}

	public List<EmpresaEntity> listarEmpresas(UsuarioEntity usuarioLogado) {
		return pessoaJuridicaService.listarEmpresas(usuarioLogado);

	}
}
