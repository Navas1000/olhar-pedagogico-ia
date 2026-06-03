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
public class AulaDTO {

    private Integer idAula;
    private Integer idAlocacao;

    @NotNull(message = "A data e hora da aula são obrigatórias")
    private LocalDateTime dataHoraAula;

    private LocalDateTime dataCriacao;
}