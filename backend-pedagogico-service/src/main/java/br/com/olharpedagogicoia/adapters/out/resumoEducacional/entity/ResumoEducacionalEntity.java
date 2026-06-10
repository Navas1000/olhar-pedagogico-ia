package br.com.olharpedagogicoia.adapters.out.resumoEducacional.entity;

import br.com.olharpedagogicoia.application.dto.TipoResumo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t064_resi_educ_base")
public class ResumoEducacionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resumo")
    private Integer idResumo;

    @Column(name = "t022_id_aluno")
    private Integer idAluno;

    @Column(name = "t041_id_turma")
    private Integer idTurma;

    @Column(name = "t042_id_aula")
    private Integer idAula;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_resumo")
    private TipoResumo tipoResumo;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @Column(name = "resumo_texto")
    private String resumoTexto;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}