package br.com.olharpedagogicoia.adapters.out.alunoTurma.entity;

import br.com.olharpedagogicoia.application.dto.StatusMatricula;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t044_altu_acad_link")
public class AlunoTurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Integer idMatricula;

    @Column(name = "t022_id_aluno")
    private Integer idAluno;

    @Column(name = "t041_id_turma")
    private Integer idTurma;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_matricula")
    private StatusMatricula statusMatricula;

    @Column(name = "data_ingresso")
    private LocalDate dataIngresso;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}