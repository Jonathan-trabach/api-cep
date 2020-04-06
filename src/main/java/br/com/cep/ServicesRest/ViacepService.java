package br.com.cep.ServicesRest;

import br.com.cep.model.dto.ViacepResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViacepService {

    //Declarando a Base URL e o tipo de Formato que ira receber
    @Value("${viacep.url}")
    private String viacep_url_base ;
    @Value("${viacep.type-format}")
    private String viacep_type_format ;

    public ViacepResponse findCep(String cep){
        String uri = viacep_url_base.concat(cep).concat(viacep_type_format);
        return restTemplate().getForObject(uri, ViacepResponse.class);
    }

    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

}
