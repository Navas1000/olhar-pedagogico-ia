package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiarioEducacionalDTO {

    private Integer idDiario;

    @NotNull(message = "O ID da aula é obrigatório")
    private Integer idAula;

    @NotNull(message = "O status de processamento é obrigatório")
    private StatusProcessamento statusProcessamento;

    private LocalDateTime dataCriacao;
}