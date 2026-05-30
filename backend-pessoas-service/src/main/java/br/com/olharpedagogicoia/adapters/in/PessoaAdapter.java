package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.IdPessoaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarPessoaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarPessoaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarPessoaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverPessoaPortIn;
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
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaAdapter {

    private final CadastrarPessoaPortIn cadastrarPessoaPortIn;
    private final ConsultarPessoaPortIn consultarPessoaPortIn;
    private final RemoverPessoaPortIn removerPessoaPortIn;
    private final AtualizarPessoaPortIn atualizarPessoaPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaPessoa(@PathVariable final Integer id) {

        log.info("Consulta de Pessoa: {}", id);

        try {
            final PessoaDTO pessoaConsultada = consultarPessoaPortIn.consultar(id);
            return ResponseEntity.ok(pessoaConsultada);

        } catch (PessoaNaoEncontradaException excecao) {

            log.error("Erro ao consultar Pessoa: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> cadastraPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {

        log.info("Cadastro da Pessoa: {}", pessoaDTO);

        final PessoaDTO pessoaCadastrada = cadastrarPessoaPortIn.cadastrar(pessoaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCadastrada);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<?> removerPessoa(@PathVariable Integer idPessoa) {

        log.info("Remover Pessoa: {}", idPessoa);

        try {
            removerPessoaPortIn.remover(idPessoa);

        } catch (PessoaNaoEncontradaException excecao) {

            log.error("Erro ao deletar Pessoa: {}, mensagem: {}", idPessoa, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {

        log.info("Atualizar Pessoa: {}", pessoaDTO);

        try {
            final PessoaDTO pessoaAtualizada = atualizarPessoaPortIn.atualizar(pessoaDTO);

            return ResponseEntity.ok(pessoaAtualizada);

        } catch (PessoaNaoEncontradaException | IdPessoaObrigatorioException excecao) {

            log.error("Erro ao atualizar Pessoa: {}, mensagem: {}", pessoaDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}