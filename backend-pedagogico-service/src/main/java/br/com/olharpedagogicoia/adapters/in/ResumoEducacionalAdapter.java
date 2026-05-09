package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.dto.TipoResumo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/resumo-educacional")
public class ResumoEducacionalAdapter {

    @GetMapping("/turma/{idTurma}/empresaTurma/{idEmpresaTurma}/unidadeTurma/{idUnidadeTurma}/aula/{idAula}/empresaAula/{idEmpresaAula}/unidadeAula/{idUnidadeAula}/turmaAula/{idTurmaAula}" +
            "/pessoaAula/{idPessoaAula}/funcionarioAula/{idFuncionarioAula}/aluno/{idAluno}/pessoaAluno/{idPessoaAluno}")
    public ResponseEntity<ResumoEducacionalDTO> consultaResumoEducacional(@PathVariable Integer idTurma,
                                                                          @PathVariable Integer idEmpresaTurma,
                                                                          @PathVariable Integer idUnidadeTurma,
                                                                          @PathVariable Integer idAula,
                                                                          @PathVariable Integer idEmpresaAula,
                                                                          @PathVariable Integer idUnidadeAula,
                                                                          @PathVariable Integer idTurmaAula,
                                                                          @PathVariable Integer idPessoaAula,
                                                                          @PathVariable Integer idFuncionarioAula,
                                                                          @PathVariable Integer idAluno,
                                                                          @PathVariable Integer idPessoaAluno) {

        ResumoEducacionalDTO resumoConsultado = new ResumoEducacionalDTO();

        resumoConsultado.setIdTurma(idTurma);
        resumoConsultado.setIdEmpresaTurma(idEmpresaTurma);
        resumoConsultado.setIdUnidadeTurma(idUnidadeTurma);
        resumoConsultado.setIdAula(idAula);
        resumoConsultado.setIdEmpresaAula(idEmpresaAula);
        resumoConsultado.setIdUnidadeAula(idUnidadeAula);
        resumoConsultado.setIdTurmaAula(idTurmaAula);
        resumoConsultado.setIdPessoaAula(idPessoaAula);
        resumoConsultado.setIdFuncionarioAula(idFuncionarioAula);
        resumoConsultado.setIdAluno(idAluno);
        resumoConsultado.setIdPessoaAluno(idPessoaAluno);
        resumoConsultado.setTipoResumo(TipoResumo.AULA);
        resumoConsultado.setDataInicio(LocalDateTime.now());
        resumoConsultado.setDataFim(LocalDateTime.now());
        resumoConsultado.setResumoTexto("Resumo pedagógico da aula");
        resumoConsultado.setDataCriacao(LocalDateTime.now());

        return ResponseEntity.ok(resumoConsultado);
    }

    @PostMapping
    public ResponseEntity<ResumoEducacionalDTO> cadastraResumoEducacional(@RequestBody ResumoEducacionalDTO resumoEducacionalDTO) {

        System.out.println("Estou cadastrando o resumo educacional");
        return ResponseEntity.status(HttpStatus.CREATED).body(resumoEducacionalDTO);
    }
    @DeleteMapping("/turma/{idTurma}/empresaTurma/{idEmpresaTurma}/unidadeTurma/{idUnidadeTurma}/aula/{idAula}/empresaAula/{idEmpresaAula}/unidadeAula/{idUnidadeAula}/turmaAula/{idTurmaAula}\" +\n" +
            "/pessoaAula/{idPessoaAula}/funcionarioAula/{idFuncionarioAula}/aluno/{idAluno}/pessoaAluno/{idPessoaAluno}")
    public ResponseEntity<Void> removerResumoEducacional (@PathVariable Integer idTurma,
                                                          @PathVariable Integer idEmpresaTurma,
                                                          @PathVariable Integer idUnidadeTurma,
                                                          @PathVariable Integer idAula,
                                                          @PathVariable Integer idEmpresaAula,
                                                          @PathVariable Integer idUnidadeAula,
                                                          @PathVariable Integer idTurmaAula,
                                                          @PathVariable Integer idPessoaAula,
                                                          @PathVariable Integer idFuncionarioAula,
                                                          @PathVariable Integer idAluno,
                                                          @PathVariable Integer idPessoaAluno) {

        System.out.println("Removendo o resumo educacional");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<ResumoEducacionalDTO> atualizaResumoEducacional (@RequestBody ResumoEducacionalDTO resumoEducacionalDTO) {
        System.out.println("Estou atualizando o resumo educacional " + resumoEducacionalDTO.getResumoTexto());
        return ResponseEntity.status(HttpStatus.CREATED).body(resumoEducacionalDTO);
    }
}