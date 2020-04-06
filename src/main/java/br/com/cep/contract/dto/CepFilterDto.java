package br.com.cep.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class CepFilterDto {
    @NotNull
    private String ibge;

    @Max(2)
    @Min(2)
    private String uf;
}
