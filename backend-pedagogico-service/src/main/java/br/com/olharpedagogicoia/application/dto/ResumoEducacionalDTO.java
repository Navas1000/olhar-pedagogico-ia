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
public class ResumoEducacionalDTO {

    private Integer idResumo;

    @NotNull(message = "O ID do aluno é obrigatório")
    private Integer idAluno;

    @NotNull(message = "O ID da turma é obrigatório")
    private Integer idTurma;

    @NotNull(message = "O ID da aula é obrigatório")
    private Integer idAula;

    @NotNull(message = "O tipo de resumo é obrigatório")
    private TipoResumo tipoResumo;

    @NotNull(message = "A data de início é obrigatória")
    private LocalDateTime dataInicio;

    @NotNull(message = "A data de fim é obrigatória")
    private LocalDateTime dataFim;

    @NotNull(message = "O texto do resumo é obrigatório")
    private String resumoTexto;

    private LocalDateTime dataCriacao;
}