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
public class AlunoDTO {

    private Integer idAluno;
    private Integer idPessoa;

    @NotNull(message = "O parâmetro nome de chamada é obrigatório")
    private String nomeChamada;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataModificacao;
}