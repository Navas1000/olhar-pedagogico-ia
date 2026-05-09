package br.com.olharpedagogicoia.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DiarioEducacionalDTO {
    private Integer idDiario;
    private Integer idAula;
    private Integer idEmpresa;
    private Integer idUnidade;
    private Integer idTurma;
    private Integer idPessoa;
    private Integer idFuncionario;
    private StatusProcessamento statusProcessamento;
    private LocalDateTime dataCriacao;
}