package br.com.olharpedagogicoia.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PessoaDTO {
    private Integer idPessoa;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
}