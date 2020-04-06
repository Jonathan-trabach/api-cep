package br.com.cep.controller;

import br.com.cep.contract.CepApi;
import br.com.cep.contract.dto.CepFilterDto;
import br.com.cep.model.Cep;
import br.com.cep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class CepController implements CepApi {

	@Autowired
	private CepService cepService;


	@Override
	public ResponseEntity<Cep> findUniqueCep(@PathVariable("cep") String cep ){
		return ResponseEntity.ok(cepService.findCep(cep));
	}

	@Override
	public ResponseEntity<List<Cep>> findAllCeps(@Valid CepFilterDto  filters) {
		return ResponseEntity.ok(cepService.findCeps(filters));
	}

}
