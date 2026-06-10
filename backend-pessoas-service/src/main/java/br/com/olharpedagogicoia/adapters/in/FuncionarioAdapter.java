package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdFuncionarioObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.in.ValidarFuncionarioPortIn;
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
@RequestMapping("/funcionario")
@AllArgsConstructor
public class FuncionarioAdapter {

    private final CadastrarFuncionarioPortIn cadastrarFuncionarioPortIn;
    private final ConsultarFuncionarioPortIn consultarFuncionarioPortIn;
    private final RemoverFuncionarioPortIn removerFuncionarioPortIn;
    private final AtualizarFuncionarioPortIn atualizarFuncionarioPortIn;
    private final ValidarFuncionarioPortIn validarFuncionarioPortIn;

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

    @PostMapping
    public ResponseEntity<FuncionarioDTO> cadastraFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {

        log.info("Cadastro do Funcionário: {}", funcionarioDTO);

        final FuncionarioDTO funcionarioCadastrado = cadastrarFuncionarioPortIn.cadastrar(funcionarioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioCadastrado);
    }

    @PostMapping("/validar")
    public ResponseEntity<?> validarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {

        log.info("Validação de Funcionário: {}", funcionarioDTO.getNomeUsuario());

        try {
            final FuncionarioDTO funcionarioValidado = validarFuncionarioPortIn.validar(funcionarioDTO);

            return ResponseEntity.ok(funcionarioValidado);

        } catch (FuncionarioNaoEncontradoException excecao) {

            log.error("Erro ao validar Funcionário: {}, mensagem: {}", funcionarioDTO.getNomeUsuario(), excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @DeleteMapping("/{idFuncionario}")
    public ResponseEntity<?> removerFuncionario(@PathVariable Integer idFuncionario) {

        log.info("Remover Funcionário: {}", idFuncionario);

        try {
            removerFuncionarioPortIn.remover(idFuncionario);

        } catch (FuncionarioNaoEncontradoException excecao) {

            log.error("Erro ao deletar Funcionário: {}, mensagem: {}", idFuncionario, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {

        log.info("Atualizar Funcionário: {}", funcionarioDTO);

        try {
            final FuncionarioDTO funcionarioAtualizado = atualizarFuncionarioPortIn.atualizar(funcionarioDTO);

            return ResponseEntity.ok(funcionarioAtualizado);

        } catch (FuncionarioNaoEncontradoException | IdFuncionarioObrigatorioException excecao) {

            log.error("Erro ao atualizar Funcionário: {}, mensagem: {}", funcionarioDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}