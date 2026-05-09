package br.com.olharpedagogicoia.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FuncionarioDTO {
    private Integer idFuncionario;
    private Integer idPessoa;
    private Integer idPapel;
    private String nomeUsuario;
    private String senha;
    private LocalDateTime ultimoLogin;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
}