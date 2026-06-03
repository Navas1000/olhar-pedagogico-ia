package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverAlunoTurmaPortIn;
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
@RequestMapping("/aluno-turma")
@AllArgsConstructor
public class AlunoTurmaAdapter {

    private final CadastrarAlunoTurmaPortIn cadastrarAlunoTurmaPortIn;
    private final ConsultarAlunoTurmaPortIn consultarAlunoTurmaPortIn;
    private final RemoverAlunoTurmaPortIn removerAlunoTurmaPortIn;
    private final AtualizarAlunoTurmaPortIn atualizarAlunoTurmaPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaAlunoTurma(@PathVariable final Integer id) {

        log.info("Consulta de Aluno Turma: {}", id);

        try {
            final AlunoTurmaDTO alunoTurmaConsultado = consultarAlunoTurmaPortIn.consultar(id);
            return ResponseEntity.ok(alunoTurmaConsultado);

        } catch (AlunoTurmaNaoEncontradaException excecao) {

            log.error("Erro ao consultar Aluno Turma: {}, mensagem: {}", id, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<AlunoTurmaDTO> cadastraAlunoTurma(@RequestBody @Valid AlunoTurmaDTO alunoTurmaDTO) {

        log.info("Cadastro de Aluno Turma: {}", alunoTurmaDTO);

        final AlunoTurmaDTO alunoTurmaCadastrado = cadastrarAlunoTurmaPortIn.cadastrar(alunoTurmaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoTurmaCadastrado);
    }

    @DeleteMapping("/{idMatricula}")
    public ResponseEntity<?> removerAlunoTurma(@PathVariable Integer idMatricula) {

        log.info("Remover Aluno Turma: {}", idMatricula);

        try {
            removerAlunoTurmaPortIn.remover(idMatricula);

        } catch (AlunoTurmaNaoEncontradaException excecao) {

            log.error("Erro ao deletar Aluno Turma: {}, mensagem: {}", idMatricula, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaAlunoTurma(@RequestBody @Valid AlunoTurmaDTO alunoTurmaDTO) {

        log.info("Atualizar Aluno Turma: {}", alunoTurmaDTO);

        try {
            final AlunoTurmaDTO alunoTurmaAtualizado = atualizarAlunoTurmaPortIn.atualizar(alunoTurmaDTO);

            return ResponseEntity.ok(alunoTurmaAtualizado);

        } catch (AlunoTurmaNaoEncontradaException | IdAlunoTurmaObrigatorioException excecao) {

            log.error("Erro ao atualizar Aluno Turma: {}, mensagem: {}", alunoTurmaDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}