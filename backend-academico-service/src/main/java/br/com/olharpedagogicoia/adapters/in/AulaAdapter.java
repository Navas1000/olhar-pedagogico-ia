package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdAulaObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/aula")
@AllArgsConstructor
public class AulaAdapter {

    private final CadastrarAulaPortIn cadastrarAulaPortIn;
    private final ConsultarAulaPortIn consultarAulaPortIn;
    private final RemoverAulaPortIn removerAulaPortIn;
    private final AtualizarAulaPortIn atualizarAulaPortIn;
    private final ConsultarAulaPorAlocacaoPortIn consultarAulaPorAlocacaoPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaAula(@PathVariable final Integer id) {

        log.info("Consulta de Aula: {}", id);

        try {
            final AulaDTO aulaConsultada = consultarAulaPortIn.consultar(id);
            return ResponseEntity.ok(aulaConsultada);

        } catch (AulaNaoEncontradaException excecao) {

            log.error("Erro ao consultar Aula: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @GetMapping("/alocacao/{idAlocacao}")
    public ResponseEntity<List<AulaDTO>> consultarPorAlocacao(
            @PathVariable final Integer idAlocacao) {

        log.info(
                "Consulta de aulas por alocação: {}",
                idAlocacao
        );

        final List<AulaDTO> aulas =
                consultarAulaPorAlocacaoPortIn
                        .consultarPorAlocacao(idAlocacao);

        return ResponseEntity.ok(aulas);
    }

    @PostMapping
    public ResponseEntity<AulaDTO> cadastraAula(@RequestBody @Valid AulaDTO aulaDTO) {

        log.info("Cadastro da Aula: {}", aulaDTO);

        final AulaDTO aulaCadastrada = cadastrarAulaPortIn.cadastrar(aulaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(aulaCadastrada);
    }

    @DeleteMapping("/{idAula}")
    public ResponseEntity<?> removerAula(@PathVariable Integer idAula) {

        log.info("Remover Aula: {}", idAula);

        try {
            removerAulaPortIn.remover(idAula);

        } catch (AulaNaoEncontradaException excecao) {

            log.error("Erro ao deletar Aula: {}, mensagem: {}", idAula, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaAula(@RequestBody @Valid AulaDTO aulaDTO) {

        log.info("Atualizar Aula: {}", aulaDTO);

        try {
            final AulaDTO aulaAtualizada = atualizarAulaPortIn.atualizar(aulaDTO);

            return ResponseEntity.ok(aulaAtualizada);

        } catch (AulaNaoEncontradaException | IdAulaObrigatorioException excecao) {

            log.error("Erro ao atualizar Aula: {}, mensagem: {}", aulaDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}