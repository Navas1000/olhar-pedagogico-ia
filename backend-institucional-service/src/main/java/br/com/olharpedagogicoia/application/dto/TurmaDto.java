package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TurmaDto {
    private Integer idTurma;
    private Integer idEmpresa;
    private Integer idUnidade;
    private String nome;
    private Integer anoLetivo;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
}
