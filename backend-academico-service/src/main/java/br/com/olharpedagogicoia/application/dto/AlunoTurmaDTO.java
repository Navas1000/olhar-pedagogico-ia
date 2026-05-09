package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AlunoTurmaDTO {
    private Integer idEmpresa;
    private Integer idUnidade;
    private Integer idTurma;
    private Integer idPessoa;
    private Integer idAluno;
    private StatusMatricula statusMatricula;
    private LocalDate dataIngresso;
    private LocalDateTime dataCriacao;
}