package br.com.cep.service;

import br.com.cep.ServicesRest.ViacepService;
import br.com.cep.ServicesRest.map.ViacepMapObject;
import br.com.cep.contract.dto.CepFilterDto;
import br.com.cep.model.Cep;

import br.com.cep.model.dto.ViacepResponse;
import br.com.cep.repository.CepRepository;
import br.com.cep.repository.CidadeRepository;
import br.com.cep.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Component
public class CepService {

    @Autowired
    private ViacepService viacepService;

    @Autowired
    private ViacepMapObject viacepMapObject;

    @Autowired
    private CepRepository cepRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    public Cep findCep(String cep){

        Optional<Cep> obj = cepRepository.findById(cep);

        //Verifica o Tamanho do CEP
        if(cep.length() != 8){
            //Retorna exception CEP inválido
            return obj.orElseThrow(() -> new ObjectNotFoundException("'CEP' não encontrado! Cep: " + cep + " Tipo: " + Cep.class.getName()));
        }

        //Operação de busca cep por ID
        Optional<Cep> cepById = cepRepository.findById(cep);

        if(cepById.isPresent()){
            //Retorna Status OK
            return cepById.get();
        }

        //Operação para a busca do Cep
        ViacepResponse viaCepResponse = viacepService.findCep(cep);

        if(viaCepResponse.getCep() == null){
            //Retorna exception CEP não encontrado
            return obj.orElseThrow(() -> new ObjectNotFoundException("'CEP' não encontrado! Cep: " + cep + " Tipo: " + Cep.class.getName()));
        }

        //Operação de salvar o CEP
        Cep cepSaved = cepRepository.save(viacepMapObject.viacepMapRespToCep(viaCepResponse));

        return cepSaved;
    }

    public  List<Cep> findCeps(final CepFilterDto filters){

        if(filters.getUf() != null) {
            //Operação de busca com UF e IBGE
            List<Cep> byUfAndIbge = cepRepository.findByUfAndIbge(filters.getIbge(), filters.getUf().toUpperCase());
            if(byUfAndIbge.isEmpty()){
                throw  new ObjectNotFoundException("Não foi encontrado nenhum Cep com os parametros IBJE:" + filters.getIbge() + " e UF:" + filters.getUf() );
            }

            return byUfAndIbge;
        }

        List<Cep> byIbge = cepRepository.findByIbge(filters.getIbge());
        if(byIbge.isEmpty())
            throw  new ObjectNotFoundException("Não foi encontrado nenhum Cep com os parametro IBJE:" + filters.getIbge());

        return  byIbge;
    }


}
