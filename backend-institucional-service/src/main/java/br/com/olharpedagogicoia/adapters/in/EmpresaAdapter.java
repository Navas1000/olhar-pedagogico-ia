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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

        try {
            final EmpresaDto empresaConsultada = consultarEmpresaPortIn.consultar(id);
            return ResponseEntity.ok(empresaConsultada);
        } catch (EmpresaNaoEncontradaException excecao) {

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<EmpresaDto> cadastraEmpresa(@RequestBody @Valid EmpresaDto empresaDTO) {

        final EmpresaDto empresaCadastrada = cadastrarEmpresaPortIn.cadastrar(empresaDTO);

         return  ResponseEntity.status(HttpStatus.CREATED).body(empresaCadastrada);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity<?> removerEmpresa(@PathVariable Integer idEmpresa) {


        try {
            removerEmpresaPortIn.remover(idEmpresa);

        } catch (EmpresaNaoEncontradaException excecao) {

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping()
    public ResponseEntity<?> atualizaEmpresa(@RequestBody @Valid EmpresaDto empresaDTO) {

        try {
            final EmpresaDto empresaAtualizada = atualizarEmpresaPortIn.atualizar(empresaDTO);

            return ResponseEntity.ok(empresaAtualizada);
        } catch (EmpresaNaoEncontradaException | IdEmpresaObrigatorioException excecao) {

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }
}


