package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EmpresaDTO {
    private Integer idEmpresa;

    @NonNull
    private String nome;
    private String cnpj;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
}
