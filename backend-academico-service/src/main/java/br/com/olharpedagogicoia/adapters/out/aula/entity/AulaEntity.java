package br.com.olharpedagogicoia.adapters.out.aula.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t042_aula_acad_base")
public class AulaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Integer idAula;

    @Column(name = "t043_id_alocacao")
    private Integer idAlocacao;

    @Column(name = "data_hora_aula")
    private LocalDateTime dataHoraAula;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}