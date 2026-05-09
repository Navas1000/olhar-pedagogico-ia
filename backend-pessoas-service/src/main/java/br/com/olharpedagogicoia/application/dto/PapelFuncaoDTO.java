package br.com.olharpedagogicoia.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PapelFuncaoDTO {
    private Integer idPapel;
    private String sigla;
    private String descricao;
    private Integer nivelHierarquico;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
}