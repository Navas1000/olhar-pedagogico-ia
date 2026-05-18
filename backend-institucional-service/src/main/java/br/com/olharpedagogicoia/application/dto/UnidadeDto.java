package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UnidadeDto {
    private Integer idUnidade;
    private Integer idEmpresa;

    @NotNull(message = "O parâmetro nome é obrigatório")
    private String nome;
    @NotNull(message = "O endereço é obrigatório")
    private String endereco;
    @NotNull(message = "O telefone é obrigatório")
    @Size(min = 10, max = 20, message = "O telefone precisa ter 10 caracteres")
    @Pattern(regexp = "^\\d+$", message = "O telefone pode conter somente dígitos")
    private String telefone;
    @NotNull(message = "Email é obrigatório")
    private String emailContato;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
}