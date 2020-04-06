package br.com.cep.contract;

import br.com.cep.contract.dto.CepFilterDto;
import br.com.cep.model.Cep;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value= "/")
@Api(value="Api REST cosulta de Cep")
@CrossOrigin(origins = "*")
public interface CepApi {

    @ApiOperation(value="Metodo Para buscar somente um CEP")
    @GetMapping(value= "/cep/{cep}")
    public ResponseEntity<Cep> findUniqueCep(@PathVariable("cep") final String cep );

    @ApiOperation(value="Metodo Para buscar todos os CEPs")
    @GetMapping(value= "/ceps")
    public ResponseEntity<List<Cep>> findAllCeps(@SpringQueryMap @Valid final CepFilterDto filters);

}
