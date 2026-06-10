package br.com.olharpedagogicoia.adapters.out.diarioAudio.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t062_diau_educ_base")
public class DiarioAudioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_audio")
    private Integer idAudio;

    @Column(name = "t061_id_diario")
    private Integer idDiario;

    @Column(name = "nome_bucket")
    private String nomeBucket;

    @Column(name = "chave_objeto")
    private String chaveObjeto;

    @Column(name = "tamanho_arquivo")
    private Long tamanhoArquivo;

    @Column(name = "extensao")
    private String extensao;

    @Column(name = "duracao_segundos")
    private Integer duracaoSegundos;

    @Column(name = "checksum")
    private String checksum;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}