package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarPessoaPortIn;
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

    private final ConsultarPessoaPortIn consultarPessoaPortIn;

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
}