package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarTranscricaoPortIn;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaTranscricao(@PathVariable final Integer id) {

        log.info("Consulta de Transcrição: {}", id);

        try {
            final TranscricaoDTO transcricaoConsultada = consultarTranscricaoPortIn.consultar(id);

            return ResponseEntity.ok(transcricaoConsultada);

        } catch (TranscricaoNaoEncontradaException excecao) {

            log.error("Erro ao consultar Transcrição: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}