package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarResumoEducacionalPortIn;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/resumo-educacional")
@AllArgsConstructor
public class ResumoEducacionalAdapter {

    private final ConsultarResumoEducacionalPortIn consultarResumoEducacionalPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaResumoEducacional(@PathVariable final Integer id) {

        log.info("Consulta de Resumo Educacional: {}", id);

        try {
            final ResumoEducacionalDTO resumoEducacionalConsultado =
                    consultarResumoEducacionalPortIn.consultar(id);

            return ResponseEntity.ok(resumoEducacionalConsultado);

        } catch (ResumoEducacionalNaoEncontradoException excecao) {

            log.error("Erro ao consultar Resumo Educacional: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}