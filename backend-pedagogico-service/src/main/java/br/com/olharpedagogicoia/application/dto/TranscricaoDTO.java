package br.com.olharpedagogicoia.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TranscricaoDTO {
    private Integer idTranscricao;
    private Integer idAudio;
    private Integer idDiario;
    private Integer idAula;
    private Integer idEmpresa;
    private Integer idUnidade;
    private Integer idTurma;
    private Integer idPessoa;
    private Integer idFuncionario;
    private String transcricao;
    private String transcricaoJson;
    private LocalDateTime dataCriacao;
}