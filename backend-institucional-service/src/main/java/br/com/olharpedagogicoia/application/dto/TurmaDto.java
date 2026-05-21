package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TurmaDto {
    private Integer idTurma;
    private Integer idUnidade;

    @NotNull(message = "O parâmetro nome é obrigatório")
    private String nome;
    @NotNull(message = "O ano letivo é obrigatório")
    private Integer anoLetivo;
    @NotNull(message = "Precisa informar se a Turma está ativa")
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
}
