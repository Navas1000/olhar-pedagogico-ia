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
public class ProfessorTurmaDTO {

    private Integer idAlocacao;
    private Integer idFuncionario;
    private Integer idTurma;

    @NotNull(message = "Precisa informar se o professor é principal")
    private Boolean professorPrincipal;

    private LocalDateTime dataCriacao;
}