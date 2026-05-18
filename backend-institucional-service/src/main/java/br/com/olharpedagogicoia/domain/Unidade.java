package br.com.olharpedagogicoia.domain;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class Unidade {

    private Integer idUnidade;
    private Integer idEmpresa;
    private String nome;
    private String endereco;
    private String telefone;
    private String emailContato;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

}
