package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarDiarioEducacionalPortIn;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/diario-educacional")
@AllArgsConstructor
public class DiarioEducacionalAdapter {

    private final ConsultarDiarioEducacionalPortIn consultarDiarioEducacionalPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaDiarioEducacional(@PathVariable final Integer id) {

        log.info("Consulta de Diário Educacional: {}", id);

        try {
            final DiarioEducacionalDTO diarioEducacionalConsultado =
                    consultarDiarioEducacionalPortIn.consultar(id);

            return ResponseEntity.ok(diarioEducacionalConsultado);

        } catch (DiarioEducacionalNaoEncontradoException excecao) {

            log.error("Erro ao consultar Diário Educacional: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}