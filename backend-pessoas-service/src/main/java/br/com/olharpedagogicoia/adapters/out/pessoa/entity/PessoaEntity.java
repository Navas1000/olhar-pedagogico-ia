package br.com.olharpedagogicoia.adapters.out.pessoa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t021_pess_pers_base")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao")
    private LocalDateTime dataModificacao;
}