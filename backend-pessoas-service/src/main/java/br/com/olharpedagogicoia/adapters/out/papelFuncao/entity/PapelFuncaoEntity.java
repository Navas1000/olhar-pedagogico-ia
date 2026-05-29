package br.com.olharpedagogicoia.adapters.out.papelFuncao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t024_pfun_eqpe_conf")
public class PapelFuncaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_papel")
    private Integer idPapel;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nivel_hierarquico")
    private Short nivelHierarquico;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao")
    private LocalDateTime dataModificacao;
}