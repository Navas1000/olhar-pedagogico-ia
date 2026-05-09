package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.dto.StatusMatricula;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/aluno-turma")
public class AlunoTurmaAdapter {

    @GetMapping("/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/aluno/{idAluno}")
    public ResponseEntity<AlunoTurmaDTO> consultaAlunoTurma(@PathVariable Integer idEmpresa,
                                                            @PathVariable Integer idUnidade,
                                                            @PathVariable Integer idTurma,
                                                            @PathVariable Integer idPessoa,
                                                            @PathVariable Integer idAluno) {

        AlunoTurmaDTO alunoTurmaConsultado = new AlunoTurmaDTO();

        alunoTurmaConsultado.setIdEmpresa(idEmpresa);
        alunoTurmaConsultado.setIdUnidade(idUnidade);
        alunoTurmaConsultado.setIdTurma(idTurma);
        alunoTurmaConsultado.setIdPessoa(idPessoa);
        alunoTurmaConsultado.setIdAluno(idAluno);
        alunoTurmaConsultado.setStatusMatricula(StatusMatricula.ATIVO);
        alunoTurmaConsultado.setDataIngresso(LocalDate.now());
        alunoTurmaConsultado.setDataCriacao(LocalDateTime.now());

        return ResponseEntity.ok(alunoTurmaConsultado);
    }

    @PostMapping
    public ResponseEntity<AlunoTurmaDTO> cadastraAlunoTurma(@RequestBody AlunoTurmaDTO alunoTurmaDTO) {

        System.out.println("Estou cadastrando o vínculo aluno-turma");
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoTurmaDTO);
    }
    @DeleteMapping("/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/aluno/{idAluno}")
    public ResponseEntity<Void> removerAlunoTurma (@PathVariable Integer idEmpresa,
                                                   @PathVariable Integer idUnidade,
                                                   @PathVariable Integer idTurma,
                                                   @PathVariable Integer idPessoa,
                                                   @PathVariable Integer idAluno) {

        System.out.println("Removendo Aluno da Turma");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<AlunoTurmaDTO> atualizaAlunoTurma (@RequestBody AlunoTurmaDTO alunoTurmaDTO) {

        System.out.println("Estou atualizando o aluno da turma " + alunoTurmaDTO.getIdTurma());
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoTurmaDTO);
    }
}