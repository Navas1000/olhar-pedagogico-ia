package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LoginDTO {

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