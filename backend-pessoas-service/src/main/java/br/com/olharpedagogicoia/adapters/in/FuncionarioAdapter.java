package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarFuncionarioPortIn;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/funcionario")
@AllArgsConstructor
public class FuncionarioAdapter {

    private final ConsultarFuncionarioPortIn consultarFuncionarioPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaFuncionario(@PathVariable final Integer id) {

        log.info("Consulta de Funcionário: {}", id);

        try {
            final FuncionarioDTO funcionarioConsultado = consultarFuncionarioPortIn.consultar(id);
            return ResponseEntity.ok(funcionarioConsultado);

        } catch (FuncionarioNaoEncontradoException excecao) {

            log.error("Erro ao consultar Funcionário: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}