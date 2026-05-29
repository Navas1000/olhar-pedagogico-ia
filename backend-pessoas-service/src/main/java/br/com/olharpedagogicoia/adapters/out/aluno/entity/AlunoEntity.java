package br.com.olharpedagogicoia.adapters.out.aluno.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t022_alun_pers_base")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Integer idAluno;

    @Column(name = "t021_id_pessoa")
    private Integer idPessoa;

    @Column(name = "nm_chamada")
    private String nomeChamada;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao")
    private LocalDateTime dataModificacao;
}