package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarAlunoPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarAlunoPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarAlunoPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverAlunoPortIn;
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
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoAdapter {

    private final CadastrarAlunoPortIn cadastrarAlunoPortIn;
    private final ConsultarAlunoPortIn consultarAlunoPortIn;
    private final RemoverAlunoPortIn removerAlunoPortIn;
    private final AtualizarAlunoPortIn atualizarAlunoPortIn;

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

    @PostMapping
    public ResponseEntity<AlunoDTO> cadastraAluno(@RequestBody @Valid AlunoDTO alunoDTO) {

        log.info("Cadastro do Aluno: {}", alunoDTO);

        final AlunoDTO alunoCadastrado = cadastrarAlunoPortIn.cadastrar(alunoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCadastrado);
    }

    @DeleteMapping("/{idAluno}")
    public ResponseEntity<?> removerAluno(@PathVariable Integer idAluno) {

        log.info("Remover Aluno: {}", idAluno);

        try {
            removerAlunoPortIn.remover(idAluno);

        } catch (AlunoNaoEncontradoException excecao) {

            log.error("Erro ao deletar Aluno: {}, mensagem: {}", idAluno, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaAluno(@RequestBody @Valid AlunoDTO alunoDTO) {

        log.info("Atualizar Aluno: {}", alunoDTO);

        try {
            final AlunoDTO alunoAtualizado = atualizarAlunoPortIn.atualizar(alunoDTO);

            return ResponseEntity.ok(alunoAtualizado);

        } catch (AlunoNaoEncontradoException | IdAlunoObrigatorioException excecao) {

            log.error("Erro ao atualizar Aluno: {}, mensagem: {}", alunoDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}