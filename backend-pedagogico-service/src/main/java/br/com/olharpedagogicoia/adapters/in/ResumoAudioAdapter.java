package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.CadastrarResumoAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarResumoAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverResumoAudioPortIn;
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
@RequestMapping("/resumo-audio")
@AllArgsConstructor
public class ResumoAudioAdapter {

    private final ConsultarResumoAudioPortIn consultarResumoAudioPortIn;
    private final CadastrarResumoAudioPortIn cadastrarResumoAudioPortIn;
    private final RemoverResumoAudioPortIn removerResumoAudioPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaResumoAudio(@PathVariable final Integer id) {

        log.info("Consulta de Resumo Áudio: {}", id);

        try {
            final ResumoAudioDTO resumoAudioConsultado =
                    consultarResumoAudioPortIn.consultar(id);

            return ResponseEntity.ok(resumoAudioConsultado);

        } catch (ResumoAudioNaoEncontradoException excecao) {

            log.error("Erro ao consultar Resumo Áudio: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<ResumoAudioDTO> cadastraResumoAudio(
            @RequestBody @Valid final ResumoAudioDTO resumoAudioDTO
    ) {

        log.info("Cadastro de Resumo Áudio: {}", resumoAudioDTO);

        final ResumoAudioDTO resumoAudioCadastrado =
                cadastrarResumoAudioPortIn.cadastrar(resumoAudioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(resumoAudioCadastrado);
    }

    @DeleteMapping("/{idAudio}")
    public ResponseEntity<?> removerResumoAudio(@PathVariable final Integer idAudio) {

        log.info("Remover Resumo Áudio: {}", idAudio);

        try {
            removerResumoAudioPortIn.remover(idAudio);

        } catch (ResumoAudioNaoEncontradoException excecao) {

            log.error("Erro ao remover Resumo Áudio: {}, mensagem: {}", idAudio, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}