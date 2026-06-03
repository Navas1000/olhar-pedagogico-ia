package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.IdProfessorTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverProfessorTurmaPortIn;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/professor-turma")
@AllArgsConstructor
public class ProfessorTurmaAdapter {

    private final CadastrarProfessorTurmaPortIn cadastrarProfessorTurmaPortIn;
    private final ConsultarProfessorTurmaPortIn consultarProfessorTurmaPortIn;
    private final RemoverProfessorTurmaPortIn removerProfessorTurmaPortIn;
    private final AtualizarProfessorTurmaPortIn atualizarProfessorTurmaPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaProfessorTurma(@PathVariable final Integer id) {

        log.info("Consulta de Professor Turma: {}", id);

        try {
            final ProfessorTurmaDTO professorTurmaConsultado = consultarProfessorTurmaPortIn.consultar(id);
            return ResponseEntity.ok(professorTurmaConsultado);

        } catch (ProfessorTurmaNaoEncontradaException excecao) {

            log.error("Erro ao consultar Professor Turma: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<ProfessorTurmaDTO> cadastraProfessorTurma(@RequestBody @Valid ProfessorTurmaDTO professorTurmaDTO) {

        log.info("Cadastro de Professor Turma: {}", professorTurmaDTO);

        final ProfessorTurmaDTO professorTurmaCadastrado = cadastrarProfessorTurmaPortIn.cadastrar(professorTurmaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(professorTurmaCadastrado);
    }

    @DeleteMapping("/{idAlocacao}")
    public ResponseEntity<?> removerProfessorTurma(@PathVariable Integer idAlocacao) {

        log.info("Remover Professor Turma: {}", idAlocacao);

        try {
            removerProfessorTurmaPortIn.remover(idAlocacao);

        } catch (ProfessorTurmaNaoEncontradaException excecao) {

            log.error("Erro ao deletar Professor Turma: {}, mensagem: {}", idAlocacao, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaProfessorTurma(@RequestBody @Valid ProfessorTurmaDTO professorTurmaDTO) {

        log.info("Atualizar Professor Turma: {}", professorTurmaDTO);

        try {
            final ProfessorTurmaDTO professorTurmaAtualizado =
                    atualizarProfessorTurmaPortIn.atualizar(professorTurmaDTO);

            return ResponseEntity.ok(professorTurmaAtualizado);

        } catch (ProfessorTurmaNaoEncontradaException | IdProfessorTurmaObrigatorioException excecao) {

            log.error("Erro ao atualizar Professor Turma: {}, mensagem: {}", professorTurmaDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}