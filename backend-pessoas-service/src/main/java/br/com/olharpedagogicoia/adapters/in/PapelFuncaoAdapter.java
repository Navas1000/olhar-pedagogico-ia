package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarPapelFuncaoPortIn;
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

    private final ConsultarPapelFuncaoPortIn consultarPapelFuncaoPortIn;

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
}