package br.com.olharpedagogicoia.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiarioAudioDTO {

    private Integer idAudio;

    @NotNull(message = "O ID do diário é obrigatório")
    private Integer idDiario;

    @NotNull(message = "O nome do bucket é obrigatório")
    @Size(max = 100, message = "O nome do bucket deve ter no máximo 100 caracteres")
    private String nomeBucket;

    @NotNull(message = "A chave do objeto é obrigatória")
    @Size(max = 1024, message = "A chave do objeto deve ter no máximo 1024 caracteres")
    private String chaveObjeto;

    @NotNull(message = "O tamanho do arquivo é obrigatório")
    private Long tamanhoArquivo;

    @NotNull(message = "A extensão é obrigatória")
    @Size(max = 10, message = "A extensão deve ter no máximo 10 caracteres")
    private String extensao;

    @NotNull(message = "A duração em segundos é obrigatória")
    private Integer duracaoSegundos;

    @NotNull(message = "O checksum é obrigatório")
    @Size(max = 64, message = "O checksum deve ter no máximo 64 caracteres")
    private String checksum;

    private LocalDateTime dataCriacao;
}