package br.com.olharpedagogicoia.adapters.out.transcricao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t063_tran_educ_base")
public class TranscricaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transcricao")
    private Integer idTranscricao;

    @Column(name = "t062_id_audio")
    private Integer idAudio;

    @Column(name = "transcricao")
    private String transcricao;

    @Column(name = "transcricao_json")
    private String transcricaoJson;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}