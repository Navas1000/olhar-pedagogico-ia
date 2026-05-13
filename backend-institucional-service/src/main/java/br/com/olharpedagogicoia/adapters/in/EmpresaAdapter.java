package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverEmpresaPortIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/empresa")
@AllArgsConstructor
public class EmpresaAdapter {

    private final CadastrarEmpresaPortIn cadastrarEmpresaPortIn;
    private final ConsultarEmpresaPortIn consultarEmpresaPortIn;
    private final RemoverEmpresaPortIn removerEmpresaPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaEmpresa(@PathVariable final Integer id) {

        try {
            final EmpresaDTO empresaConsultada = consultarEmpresaPortIn.consultar(id);
            return ResponseEntity.ok(empresaConsultada);
        } catch (EmpresaNaoEncontradaException excecao) {

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> cadastraEmpresa(@RequestBody EmpresaDTO empresaDTO) {

        final EmpresaDTO empresaCadastrada = cadastrarEmpresaPortIn.cadastrar(empresaDTO);

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
    public ResponseEntity<EmpresaDTO> atualizaEmpresa(@RequestBody EmpresaDTO empresaDTO) {

        System.out.println("Estou atualizando a empresa " + empresaDTO.getIdEmpresa());
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaDTO);
    }
}


