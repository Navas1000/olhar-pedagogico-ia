package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.exceptions.IdTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.*;
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
@RequestMapping("/turma")
@AllArgsConstructor
public class TurmaAdapter {

    private final ConsultarTurmaPortIn consultarTurmaPortIn;
    private final RemoverTurmaPortIn removerTurmaPortIn;
    private final CadastrarTurmaPortIn cadastrarTurmaPortIn;
    private final AtualizarTurmaPortIn atualizarTurmaPortIn;


    @GetMapping("/{id}")
    public ResponseEntity<?> consultaTurma(@PathVariable Integer id) {
        log.info("Consulta de Turma: {}", id);

        try {
            final TurmaDto turmaConsultada = consultarTurmaPortIn.consultar(id);
            return ResponseEntity.ok(turmaConsultada);

        } catch (TurmaNaoEncontradaException excecao) {
            log.error("Erro ao consultar Turma: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<TurmaDto> cadastraTurma(@RequestBody @Valid TurmaDto turmaDto) {
        log.info("Cadastro de Turma: {}", turmaDto);

        final TurmaDto turmaCadastrada = cadastrarTurmaPortIn.cadastrar(turmaDto);

        return  ResponseEntity.status(HttpStatus.CREATED).body(turmaCadastrada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerTurma (@PathVariable Integer id) {
        log.info("Remover de Turma: {}", id);
        try {
            removerTurmaPortIn.remover(id);

        } catch (TurmaNaoEncontradaException excecao) {
            log.error("Erro ao remover Turma: {}, mensagem: {}", id, excecao.getMessage());
            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping()
    public ResponseEntity<?> atualizaTurma (@RequestBody @Valid TurmaDto turmaDTO){

        log.info("Atualizar de Turma: {}", turmaDTO);
            try {
                final TurmaDto turmaAtualizada = atualizarTurmaPortIn.atualizar(turmaDTO);

                return ResponseEntity.ok(turmaAtualizada);

            } catch (TurmaNaoEncontradaException | IdTurmaObrigatorioException excecao) {
                log.error("Erro ao atualizar Turma: {}, mensagem: {}", turmaDTO, excecao.getMessage());
                final Map<String, String> erro = new HashMap<>();
                erro.put("mensagem", excecao.getMessage());

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
            }
        }
}