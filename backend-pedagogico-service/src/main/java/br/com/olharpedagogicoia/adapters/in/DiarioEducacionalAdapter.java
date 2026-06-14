package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdDiarioEducacionalObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverDiarioEducacionalPortIn;
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
@RequestMapping("/diario-educacional")
@AllArgsConstructor
public class DiarioEducacionalAdapter {

    private final ConsultarDiarioEducacionalPortIn consultarDiarioEducacionalPortIn;
    private final CadastrarDiarioEducacionalPortIn cadastrarDiarioEducacionalPortIn;
    private final RemoverDiarioEducacionalPortIn removerDiarioEducacionalPortIn;
    private final AtualizarDiarioEducacionalPortIn atualizarDiarioEducacionalPortIn;

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

    @PostMapping
    public ResponseEntity<DiarioEducacionalDTO> cadastraDiarioEducacional(
            @RequestBody @Valid final DiarioEducacionalDTO diarioEducacionalDTO
    ) {

        log.info("Cadastro de Diário Educacional: {}", diarioEducacionalDTO);

        final DiarioEducacionalDTO diarioEducacionalCadastrado =
                cadastrarDiarioEducacionalPortIn.cadastrar(diarioEducacionalDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(diarioEducacionalCadastrado);
    }

    @DeleteMapping("/{idDiario}")
    public ResponseEntity<?> removerDiarioEducacional(@PathVariable final Integer idDiario) {

        log.info("Remover Diário Educacional: {}", idDiario);

        try {
            removerDiarioEducacionalPortIn.remover(idDiario);

        } catch (DiarioEducacionalNaoEncontradoException excecao) {

            log.error("Erro ao remover Diário Educacional: {}, mensagem: {}", idDiario, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping
    public ResponseEntity<?> atualizaDiarioEducacional(
            @RequestBody @Valid final DiarioEducacionalDTO diarioEducacionalDTO
    ) {

        log.info("Atualizar Diário Educacional: {}", diarioEducacionalDTO);

        try {
            final DiarioEducacionalDTO diarioEducacionalAtualizado =
                    atualizarDiarioEducacionalPortIn.atualizar(diarioEducacionalDTO);

            return ResponseEntity.ok(diarioEducacionalAtualizado);

        } catch (DiarioEducacionalNaoEncontradoException | IdDiarioEducacionalObrigatorioException excecao) {

            log.error("Erro ao atualizar Diário Educacional: {}, mensagem: {}",
                    diarioEducacionalDTO, excecao.getMessage());

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}