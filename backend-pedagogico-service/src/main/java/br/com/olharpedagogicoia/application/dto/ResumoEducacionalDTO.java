package br.com.olharpedagogicoia.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResumoEducacionalDTO {
    private Integer idResumo;
    private Integer idTurma;
    private Integer idEmpresaTurma;
    private Integer idUnidadeTurma;
    private Integer idAula;
    private Integer idEmpresaAula;
    private Integer idUnidadeAula;
    private Integer idTurmaAula;
    private Integer idPessoaAula;
    private Integer idFuncionarioAula;
    private Integer idAluno;
    private Integer idPessoaAluno;
    private TipoResumo tipoResumo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String resumoTexto;
    private LocalDateTime dataCriacao;
}