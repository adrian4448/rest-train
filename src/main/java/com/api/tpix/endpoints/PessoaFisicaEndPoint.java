package com.api.tpix.endpoints;

import com.api.tpix.dto.PessoaFisicaDTO;
import com.api.tpix.model.Cobranca;
import com.api.tpix.model.PessoaFisica;
import com.api.tpix.service.PessoaFisicaService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/pessoa/fisica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaFisicaEndPoint {

    private static PessoaFisicaService service = new PessoaFisicaService();
    private static Gson jsonConverter = new Gson();
    private static ModelMapper modelMapper = new ModelMapper();

    @GET
    public Response findAll() {
        List<PessoaFisicaDTO> pessoasFisicas = new ArrayList<>();
        service.findAll().forEach(p -> pessoasFisicas.add(modelMapper.map(p, PessoaFisicaDTO.class)));
        return Response.ok(jsonConverter.toJson(pessoasFisicas)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        if(service.findById(id) == null) {
            return Response.noContent().build();
        }
        return Response.ok(jsonConverter.toJson(modelMapper.map(service.findById(id), PessoaFisicaDTO.class))).build();
    }

    @POST
    public Response addPessoaFisica(PessoaFisicaDTO pessoaFisica) {
        service.addPessoaFisica(modelMapper.map(pessoaFisica, PessoaFisica.class));
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePessoaFisica(PessoaFisicaDTO pessoaFisicaDTO, @PathParam("id") Integer id) {
        PessoaFisica pessoaFisica = modelMapper.map(pessoaFisicaDTO, PessoaFisica.class);
        if(pessoaFisica.getCpf() == null || pessoaFisica.getNome() == null) {
            return Response.status(Response.Status.EXPECTATION_FAILED).build();
        }
        return Response.ok(jsonConverter.toJson(service.updatePessoaFisica(pessoaFisica, id))).build();
    }

}
