package br.com.olharpedagogicoia.adapters.out.professorTurma.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t043_prtu_acad_link")
public class ProfessorTurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alocacao")
    private Integer idAlocacao;

    @Column(name = "t023_id_funcionario")
    private Integer idFuncionario;

    @Column(name = "t041_id_turma")
    private Integer idTurma;

    @Column(name = "professor_principal")
    private Short professorPrincipal;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}