package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AlunoTurmaDTO {

    private Integer idMatricula;
    private Integer idAluno;
    private Integer idTurma;

    @NotNull(message = "O status da matrícula é obrigatório")
    private StatusMatricula statusMatricula;

    @NotNull(message = "A data de ingresso é obrigatória")
    private LocalDate dataIngresso;

    private LocalDateTime dataCriacao;
}