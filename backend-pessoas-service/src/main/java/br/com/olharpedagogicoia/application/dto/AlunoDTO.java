package br.com.olharpedagogicoia.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AlunoDTO {
    private Integer idAluno;
    private Integer idPessoa;
    private String nomeChamada;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
}