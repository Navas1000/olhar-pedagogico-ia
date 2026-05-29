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
public class FuncionarioDTO {

    private Integer idFuncionario;
    private Integer idPessoa;
    private Integer idPapel;

    @NotNull(message = "O nome de usuário é obrigatório")
    private String nomeUsuario;

    @NotNull(message = "A senha é obrigatória")
    private String senha;

    private LocalDateTime ultimoLogin;

    @NotNull(message = "Precisa informar se o funcionário está ativo")
    private Boolean ativo;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataModificacao;
}