package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.IdUnidadeObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
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
@RequestMapping("/unidade")
@AllArgsConstructor
public class UnidadeAdapter {

    private final ConsultarUnidadePortIn consultarUnidadePortIn;
    private final RemoverUnidadePortIn removerUnidadePortIn;
    private final CadastrarUnidadePortIn cadastrarUnidadePortIn;
    private final AtualizarUnidadePortIn atualizarUnidadePortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaUnidade(@PathVariable Integer id) {
        log.info("Condulta de Unidade: {}", id);

        try {
            final UnidadeDto unidadeConsultada = consultarUnidadePortIn.consultar(id);
            return ResponseEntity.ok(unidadeConsultada);
        } catch (UnidadeNaoEncontradaException excecao) {
            log.error("Erro ao consultar Unidade: {}, mensagem: {}", id, excecao.getMessage());
            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<UnidadeDto> cadastraUnidade(@RequestBody @Valid UnidadeDto unidadeDTO) {

        log.info("Cadastro de Unidade: {}", unidadeDTO);
        final UnidadeDto unidadeCadastrada = cadastrarUnidadePortIn.cadastrar(unidadeDTO);

        return  ResponseEntity.status(HttpStatus.CREATED).body(unidadeCadastrada);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerUnidade (@PathVariable Integer id) {
        log.info("Remover de Unidade: {}", id);
        try {
            removerUnidadePortIn.remover(id);

        } catch (UnidadeNaoEncontradaException excecao) {
            log.error("Erro ao remover Unidade: {}, mensagem: {}", id, excecao.getMessage());
            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping()
    public ResponseEntity<?> atualizaUnidade (@RequestBody @Valid UnidadeDto unidadeDTO) {
        log.info("Atualizar de Unidade: {}", unidadeDTO);
        try {
            final UnidadeDto unidadeAtualizada = atualizarUnidadePortIn.atualizar(unidadeDTO);

            return ResponseEntity.ok(unidadeAtualizada);
        } catch (UnidadeNaoEncontradaException | IdUnidadeObrigatorioException excecao) {
            log.error("Erro ao atualizar Unidade: {}, mensagem: {}", unidadeDTO, excecao.getMessage());
            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}