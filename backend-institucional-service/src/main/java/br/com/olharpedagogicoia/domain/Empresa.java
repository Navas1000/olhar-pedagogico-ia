package br.com.olharpedagogicoia.domain;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class Empresa {

    private Integer idEmpresa;
    private String nome;
    private String cnpj;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

}
