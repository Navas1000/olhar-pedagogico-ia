package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarAlunoPortIn;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoAdapter {

    private final ConsultarAlunoPortIn consultarAlunoPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaAluno(@PathVariable final Integer id) {

        log.info("Consulta de Aluno: {}", id);

        try {
            final AlunoDTO alunoConsultado = consultarAlunoPortIn.consultar(id);
            return ResponseEntity.ok(alunoConsultado);

        } catch (AlunoNaoEncontradoException excecao) {

            log.error("Erro ao consultar Aluno: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}