package br.com.olharpedagogicoia.adapters.out.funcionario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t023_func_eqpe_base")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Integer idFuncionario;

    @Column(name = "t024_id_papel")
    private Integer idPapel;

    @Column(name = "t021_id_pessoa")
    private Integer idPessoa;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "senha")
    private String senha;

    @Column(name = "ultimo_login")
    private LocalDateTime ultimoLogin;

    @Column(name = "ativo")
    private Short ativo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao")
    private LocalDateTime dataModificacao;
}