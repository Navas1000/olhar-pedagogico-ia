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
public class EmpresaDto {

    private Integer idEmpresa;

    @NotNull(message = "O parâmetro nome é obrigatório")
    private String nome;
    @NotNull(message = "O CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "O CNPJ precisa ter 14 caracteres")
    @Pattern(regexp = "^\\d+$", message = "O CPNJ pode conter somente dígitos")
    private String cnpj;
    @NotNull(message = "Precisa informar se a Empresa está ativa")
    private Boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
}
