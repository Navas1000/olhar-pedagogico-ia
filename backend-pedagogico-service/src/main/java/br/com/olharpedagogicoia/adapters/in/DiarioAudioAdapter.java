package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarDiarioAudioPortIn;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/diario-audio")
@AllArgsConstructor
public class DiarioAudioAdapter {

    private final ConsultarDiarioAudioPortIn consultarDiarioAudioPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaDiarioAudio(@PathVariable final Integer id) {

        log.info("Consulta de Diário Áudio: {}", id);

        try {
            final DiarioAudioDTO diarioAudioConsultado = consultarDiarioAudioPortIn.consultar(id);

            return ResponseEntity.ok(diarioAudioConsultado);

        } catch (DiarioAudioNaoEncontradoException excecao) {

            log.error("Erro ao consultar Diário Áudio: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}