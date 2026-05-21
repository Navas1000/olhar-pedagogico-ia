package br.com.olharpedagogicoia.adapters.out.turma.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t041_turm_acad_base")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurma;

    @Column(name = "t002_id_unidade")
    private Integer idUnidade;

    @Column(name = "nome")
    private String nome;

    @Column(name = "anoLetivo")
    private Integer anoLetivo;

    @Column(name = "ativo")
    private Short ativo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao")
    private LocalDateTime dataModificacao;
}
