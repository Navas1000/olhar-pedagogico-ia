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
public class TranscricaoDTO {

    private Integer idTranscricao;

    @NotNull(message = "O ID do áudio é obrigatório")
    private Integer idAudio;

    @NotNull(message = "A transcrição é obrigatória")
    private String transcricao;

    private String transcricaoJson;

    private LocalDateTime dataCriacao;
}