package br.com.olharpedagogicoia.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResumoAudioDTO {
    private Integer idAudio;
    private Integer idResumo;
    private String nomeBucket;
    private String chaveObjeto;
    private Integer duracaoSegundos;
    private String formato;
    private Long tamanhoBytes;
    private LocalDateTime dataCriacao;
}