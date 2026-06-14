package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.IdTranscricaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverTranscricaoPortIn;
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
@RequestMapping("/transcricao")
@AllArgsConstructor
public class TranscricaoAdapter {

    private final ConsultarTranscricaoPortIn consultarTranscricaoPortIn;
    private final CadastrarTranscricaoPortIn cadastrarTranscricaoPortIn;
    private final RemoverTranscricaoPortIn removerTranscricaoPortIn;
    private final AtualizarTranscricaoPortIn atualizarTranscricaoPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaTranscricao(@PathVariable final Integer id) {

        log.info("Consulta de Transcrição: {}", id);

        try {
            final TranscricaoDTO transcricaoConsultada =
                    consultarTranscricaoPortIn.consultar(id);

            return ResponseEntity.ok(transcricaoConsultada);

        } catch (TranscricaoNaoEncontradaException excecao) {

            log.error("Erro ao consultar Transcrição: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<TranscricaoDTO> cadastraTranscricao(
            @RequestBody @Valid final TranscricaoDTO transcricaoDTO
    ) {

        log.info("Cadastro de Transcrição: {}", transcricaoDTO);

        final TranscricaoDTO transcricaoCadastrada =
                cadastrarTranscricaoPortIn.cadastrar(transcricaoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(transcricaoCadastrada);
    }

    @DeleteMapping("/{idTranscricao}")
    public ResponseEntity<?> removerTranscricao(@PathVariable final Integer idTranscricao) {

        log.info("Remover Transcrição: {}", idTranscricao);

        try {
            removerTranscricaoPortIn.remover(idTranscricao);

        } catch (TranscricaoNaoEncontradaException excecao) {

            log.error("Erro ao remover Transcrição: {}, mensagem: {}", idTranscricao, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaTranscricao(
            @RequestBody @Valid final TranscricaoDTO transcricaoDTO
    ) {

        log.info("Atualizar Transcrição: {}", transcricaoDTO);

        try {
            final TranscricaoDTO transcricaoAtualizada =
                    atualizarTranscricaoPortIn.atualizar(transcricaoDTO);

            return ResponseEntity.ok(transcricaoAtualizada);

        } catch (TranscricaoNaoEncontradaException | IdTranscricaoObrigatorioException excecao) {

            log.error("Erro ao atualizar Transcrição: {}, mensagem: {}",
                    transcricaoDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}