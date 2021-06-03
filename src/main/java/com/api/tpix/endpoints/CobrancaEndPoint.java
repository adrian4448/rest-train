package com.api.tpix.endpoints;

import com.api.tpix.dto.CobrancaDTO;
import com.api.tpix.model.Cobranca;
import com.api.tpix.service.CobrancaService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/cobranca")
@Produces(MediaType.APPLICATION_JSON)
public class CobrancaEndPoint {

    private static CobrancaService service = new CobrancaService();
    private static Gson jsonConverter = new Gson();
    private static ModelMapper modelMapper = new ModelMapper();

    @GET
    @Path("{txId}")
    public Response findByTxId(@PathParam("txId") String txId) {
        Cobranca cobranca = service.findByTxId(txId);
        CobrancaDTO dto = modelMapper.map(cobranca, CobrancaDTO.class);
        dto.getDevedor().setDataNascimento(null);
        dto.getCalendario().setDataInicio(null);
        return Response.ok(jsonConverter.toJson(dto)).build();
    }

    @GET
    @Path("/pessoa/fisica/{id}")
    public Response findCobrancasByPessoaFisica(@PathParam("id") Integer id) {
        List<CobrancaDTO> cobrancas = new ArrayList<>();
        service.findCobrancasByPessoaFisica(id).forEach(c -> cobrancas.add(modelMapper.map(c, CobrancaDTO.class)));
        return Response.ok(jsonConverter.toJson(cobrancas)).build();
    }
}
