package br.com.cep.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ViacepResponse {

    private String cep;

    private String bairro;

    private String logradouro;

    private String complemento;

    private String unidade;

    private String localidade;

    private String ibge;

    private String uf;

}
