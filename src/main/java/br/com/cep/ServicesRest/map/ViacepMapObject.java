package br.com.cep.ServicesRest.map;

import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;
import br.com.cep.model.dto.ViacepResponse;
import org.springframework.stereotype.Component;

@Component
public class ViacepMapObject {

    //Mapear o Objeto JSON
    public Cep viacepMapRespToCep(ViacepResponse viacepResponse) {
        return Cep.builder()
                .cep(viacepResponse.getCep())
                .logradouro(viacepResponse.getLogradouro())
                .complemento(viacepResponse.getComplemento())
                .bairro(viacepResponse.getBairro())
                .cidade(Cidade.builder()
                        .localidade(viacepResponse.getLocalidade())
                        .uf(viacepResponse.getUf())
                        .ibge(viacepResponse.getIbge())
                        .build())
                .build();
    }

}
