package br.com.olharpedagogicoia.adapters.out.diarioEducacional.entity;

import br.com.olharpedagogicoia.application.dto.StatusProcessamento;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t061_diar_educ_base")
public class DiarioEducacionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diario")
    private Integer idDiario;

    @Column(name = "t042_id_aula")
    private Integer idAula;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_processamento")
    private StatusProcessamento statusProcessamento;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}