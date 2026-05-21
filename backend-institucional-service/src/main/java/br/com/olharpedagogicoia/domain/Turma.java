package br.com.olharpedagogicoia.domain;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class Turma {

    private Integer idTurma;
    private Integer idUnidade;
    private String nome;
    private Integer anoLetivo;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

}
