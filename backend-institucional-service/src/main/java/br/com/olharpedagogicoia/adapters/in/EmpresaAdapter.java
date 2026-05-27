package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdEmpresaObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverEmpresaPortIn;
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
@RequestMapping("/empresa")
@AllArgsConstructor
public class EmpresaAdapter {

    private final CadastrarEmpresaPortIn cadastrarEmpresaPortIn;
    private final ConsultarEmpresaPortIn consultarEmpresaPortIn;
    private final RemoverEmpresaPortIn removerEmpresaPortIn;
    private final AtualizarEmpresaPortIn atualizarEmpresaPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaEmpresa(@PathVariable final Integer id) {

        log.info("Consulta de Empresa: {}", id);

        try {
            final EmpresaDto empresaConsultada = consultarEmpresaPortIn.consultar(id);
            return ResponseEntity.ok(empresaConsultada);
        } catch (EmpresaNaoEncontradaException excecao) {

            log.error("Erro ao consultar Empresa: {}, mensagem: {}", id, excecao.getMessage());
            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<EmpresaDto> cadastraEmpresa(@RequestBody @Valid EmpresaDto empresaDTO) {

        log.info("Cadastro da Empresa: {}", empresaDTO);
        final EmpresaDto empresaCadastrada = cadastrarEmpresaPortIn.cadastrar(empresaDTO);

         return  ResponseEntity.status(HttpStatus.CREATED).body(empresaCadastrada);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity<?> removerEmpresa(@PathVariable Integer idEmpresa) {

        log.info("Remover Empresa: {}", idEmpresa);
        try {
            removerEmpresaPortIn.remover(idEmpresa);

        } catch (EmpresaNaoEncontradaException excecao) {

            log.error("Erro ao deletar Empresa: {}, mensagem: {}", idEmpresa, excecao.getMessage());
            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping()
    public ResponseEntity<?> atualizaEmpresa(@RequestBody @Valid EmpresaDto empresaDTO) {

        log.info("Atualizar Empresa: {}", empresaDTO);
        try {
            final EmpresaDto empresaAtualizada = atualizarEmpresaPortIn.atualizar(empresaDTO);

            return ResponseEntity.ok(empresaAtualizada);
        } catch (EmpresaNaoEncontradaException | IdEmpresaObrigatorioException excecao) {

            log.error("Erro ao atualizar Empresa: {}, mensagem: {}", empresaDTO, excecao.getMessage());
            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}


