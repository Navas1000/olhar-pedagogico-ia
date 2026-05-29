package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PessoaDTO {

    private Integer idPessoa;

    @NotNull(message = "O parâmetro nome é obrigatório")
    private String nome;

    @NotNull(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF precisa ter 11 caracteres")
    @Pattern(regexp = "^\\d+$", message = "O CPF pode conter somente dígitos")
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @NotNull(message = "O e-mail é obrigatório")
    @Email(message = "O e-mail informado é inválido")
    private String email;

    @NotNull(message = "O telefone é obrigatório")
    private String telefone;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataModificacao;
}