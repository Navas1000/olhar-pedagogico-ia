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
public class PapelFuncaoDTO {

    private Integer idPapel;

    @NotNull(message = "A sigla é obrigatória")
    private String sigla;

    @NotNull(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull(message = "O nível hierárquico é obrigatório")
    private Integer nivelHierarquico;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataModificacao;
}