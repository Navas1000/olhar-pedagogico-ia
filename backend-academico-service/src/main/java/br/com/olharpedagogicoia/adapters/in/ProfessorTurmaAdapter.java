package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/professor-turma")
public class ProfessorTurmaAdapter {

    @GetMapping("/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/funcionario/{idFuncionario}")
    public ResponseEntity<ProfessorTurmaDTO> consultaProfessorTurma(@PathVariable Integer idEmpresa,
                                                                    @PathVariable Integer idUnidade,
                                                                    @PathVariable Integer idTurma,
                                                                    @PathVariable Integer idPessoa,
                                                                    @PathVariable Integer idFuncionario) {

        ProfessorTurmaDTO professorTurmaConsultado = new ProfessorTurmaDTO();

        professorTurmaConsultado.setIdEmpresa(idEmpresa);
        professorTurmaConsultado.setIdUnidade(idUnidade);
        professorTurmaConsultado.setIdTurma(idTurma);
        professorTurmaConsultado.setIdPessoa(idPessoa);
        professorTurmaConsultado.setIdFuncionario(idFuncionario);
        professorTurmaConsultado.setProfessorPrincipal(true);
        professorTurmaConsultado.setDataCriacao(LocalDateTime.now());

        return ResponseEntity.ok(professorTurmaConsultado);
    }

    @PostMapping
    public ResponseEntity<ProfessorTurmaDTO> cadastraProfessorTurma(@RequestBody ProfessorTurmaDTO professorTurmaDTO) {

        System.out.println("Estou cadastrando o vínculo professor-turma");
        return ResponseEntity.status(HttpStatus.CREATED).body(professorTurmaDTO);
    }

    @DeleteMapping("/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/funcionario/{idFuncionario}")
    public ResponseEntity<Void> removerProfessorTurma (@PathVariable Integer idEmpresa,
                                                       @PathVariable Integer idUnidade,
                                                       @PathVariable Integer idTurma,
                                                       @PathVariable Integer idPessoa,
                                                       @PathVariable Integer idFuncionario) {

        System.out.println("Removendo Professor da Turma");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<ProfessorTurmaDTO> atualizaProfessorTurma (@RequestBody ProfessorTurmaDTO professorTurmaDTO) {

        System.out.println("Estou atualizando o Professor da Turma " + professorTurmaDTO.getIdTurma());
        return ResponseEntity.status(HttpStatus.CREATED).body(professorTurmaDTO);
    }
}