package br.com.olharpedagogicoia.adapters.out.resumoAudio.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t065_resa_educ_base")
public class ResumoAudioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_audio")
    private Integer idAudio;

    @Column(name = "t064_id_resumo")
    private Integer idResumo;

    @Column(name = "nome_bucket")
    private String nomeBucket;

    @Column(name = "chave_objeto")
    private String chaveObjeto;

    @Column(name = "duracao_segundos")
    private Integer duracaoSegundos;

    @Column(name = "formato")
    private String formato;

    @Column(name = "tamanho_bytes")
    private Long tamanhoBytes;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}