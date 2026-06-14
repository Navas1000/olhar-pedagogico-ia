package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.IdResumoEducacionalObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.AtualizarResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverResumoEducacionalPortIn;
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
@RequestMapping("/resumo-educacional")
@AllArgsConstructor
public class ResumoEducacionalAdapter {

    private final ConsultarResumoEducacionalPortIn consultarResumoEducacionalPortIn;
    private final CadastrarResumoEducacionalPortIn cadastrarResumoEducacionalPortIn;
    private final RemoverResumoEducacionalPortIn removerResumoEducacionalPortIn;
    private final AtualizarResumoEducacionalPortIn atualizarResumoEducacionalPortIn;

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

    @PostMapping
    public ResponseEntity<ResumoEducacionalDTO> cadastraResumoEducacional(
            @RequestBody @Valid final ResumoEducacionalDTO resumoEducacionalDTO
    ) {

        log.info("Cadastro de Resumo Educacional: {}", resumoEducacionalDTO);

        final ResumoEducacionalDTO resumoEducacionalCadastrado =
                cadastrarResumoEducacionalPortIn.cadastrar(resumoEducacionalDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(resumoEducacionalCadastrado);
    }

    @DeleteMapping("/{idResumo}")
    public ResponseEntity<?> removerResumoEducacional(@PathVariable final Integer idResumo) {

        log.info("Remover Resumo Educacional: {}", idResumo);

        try {
            removerResumoEducacionalPortIn.remover(idResumo);

        } catch (ResumoEducacionalNaoEncontradoException excecao) {

            log.error("Erro ao remover Resumo Educacional: {}, mensagem: {}", idResumo, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaResumoEducacional(
            @RequestBody @Valid final ResumoEducacionalDTO resumoEducacionalDTO
    ) {

        log.info("Atualizar Resumo Educacional: {}", resumoEducacionalDTO);

        try {
            final ResumoEducacionalDTO resumoEducacionalAtualizado =
                    atualizarResumoEducacionalPortIn.atualizar(resumoEducacionalDTO);

            return ResponseEntity.ok(resumoEducacionalAtualizado);

        } catch (ResumoEducacionalNaoEncontradoException | IdResumoEducacionalObrigatorioException excecao) {

            log.error("Erro ao atualizar Resumo Educacional: {}, mensagem: {}",
                    resumoEducacionalDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}