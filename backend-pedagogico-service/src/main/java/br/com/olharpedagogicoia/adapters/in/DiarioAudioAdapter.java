package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.CadastrarDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverDiarioAudioPortIn;
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
@RequestMapping("/diario-audio")
@AllArgsConstructor
public class DiarioAudioAdapter {

    private final ConsultarDiarioAudioPortIn consultarDiarioAudioPortIn;
    private final CadastrarDiarioAudioPortIn cadastrarDiarioAudioPortIn;
    private final RemoverDiarioAudioPortIn removerDiarioAudioPortIn;

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

    @PostMapping
    public ResponseEntity<DiarioAudioDTO> cadastraDiarioAudio(
            @RequestBody @Valid DiarioAudioDTO diarioAudioDTO
    ) {

        log.info("Cadastro de Diário Áudio: {}", diarioAudioDTO);

        final DiarioAudioDTO diarioAudioCadastrado =
                cadastrarDiarioAudioPortIn.cadastrar(diarioAudioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(diarioAudioCadastrado);
    }

    @DeleteMapping("/{idAudio}")
    public ResponseEntity<?> removerDiarioAudio(@PathVariable final Integer idAudio) {

        log.info("Remover Diário Áudio: {}", idAudio);

        try {
            removerDiarioAudioPortIn.remover(idAudio);

        } catch (DiarioAudioNaoEncontradoException excecao) {

            log.error("Erro ao remover Diário Áudio: {}, mensagem: {}", idAudio, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}