package br.com.olharpedagogicoia.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DiarioAudioDTO {
    private Integer idAudio;
    private Integer idDiario;
    private Integer idAula;
    private Integer idEmpresa;
    private Integer idUnidade;
    private Integer idTurma;
    private Integer idPessoa;
    private Integer idFuncionario;
    private String nomeBucket;
    private String chaveObjeto;
    private Long tamanhoArquivo;
    private String extensao;
    private Integer duracaoSegundos;
    private String checksum;
    private LocalDateTime dataCriacao;
}