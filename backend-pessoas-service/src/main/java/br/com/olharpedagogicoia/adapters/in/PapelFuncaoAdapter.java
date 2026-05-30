package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.IdPapelFuncaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.AtualizarPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverPapelFuncaoPortIn;
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
@RequestMapping("/papel-funcao")
@AllArgsConstructor
public class PapelFuncaoAdapter {

    private final CadastrarPapelFuncaoPortIn cadastrarPapelFuncaoPortIn;
    private final ConsultarPapelFuncaoPortIn consultarPapelFuncaoPortIn;
    private final RemoverPapelFuncaoPortIn removerPapelFuncaoPortIn;
    private final AtualizarPapelFuncaoPortIn atualizarPapelFuncaoPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaPapelFuncao(@PathVariable final Integer id) {

        log.info("Consulta de Papel Função: {}", id);

        try {
            final PapelFuncaoDTO papelFuncaoConsultado = consultarPapelFuncaoPortIn.consultar(id);
            return ResponseEntity.ok(papelFuncaoConsultado);

        } catch (PapelFuncaoNaoEncontradoException excecao) {

            log.error("Erro ao consultar Papel Função: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<PapelFuncaoDTO> cadastraPapelFuncao(@RequestBody @Valid PapelFuncaoDTO papelFuncaoDTO) {

        log.info("Cadastro do Papel Função: {}", papelFuncaoDTO);

        final PapelFuncaoDTO papelFuncaoCadastrado = cadastrarPapelFuncaoPortIn.cadastrar(papelFuncaoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(papelFuncaoCadastrado);
    }

    @DeleteMapping("/{idPapelFuncao}")
    public ResponseEntity<?> removerPapelFuncao(@PathVariable Integer idPapelFuncao) {

        log.info("Remover Papel Função: {}", idPapelFuncao);

        try {
            removerPapelFuncaoPortIn.remover(idPapelFuncao);

        } catch (PapelFuncaoNaoEncontradoException excecao) {

            log.error("Erro ao deletar Papel Função: {}, mensagem: {}", idPapelFuncao, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaPapelFuncao(@RequestBody @Valid PapelFuncaoDTO papelFuncaoDTO) {

        log.info("Atualizar Papel Função: {}", papelFuncaoDTO);

        try {
            final PapelFuncaoDTO papelFuncaoAtualizado = atualizarPapelFuncaoPortIn.atualizar(papelFuncaoDTO);

            return ResponseEntity.ok(papelFuncaoAtualizado);

        } catch (PapelFuncaoNaoEncontradoException | IdPapelFuncaoObrigatorioException excecao) {

            log.error("Erro ao atualizar Papel Função: {}, mensagem: {}", papelFuncaoDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}