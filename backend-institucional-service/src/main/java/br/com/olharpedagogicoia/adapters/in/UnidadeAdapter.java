package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/unidade")
@AllArgsConstructor
public class UnidadeAdapter {

    private final ConsultarUnidadePortIn consultarUnidadePortIn;
    private final RemoverUnidadePortIn removerUnidadePortIn;
    private final CadastrarUnidadePortIn cadastrarUnidadePortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaUnidade(@PathVariable Integer id) {

        try {
            final UnidadeDto unidadeConsultada = consultarUnidadePortIn.consultar(id);
            return ResponseEntity.ok(unidadeConsultada);
        } catch (UnidadeNaoEncontradaException excecao) {

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<UnidadeDto> cadastraUnidade(@RequestBody @Valid UnidadeDto unidadeDTO) {

        final UnidadeDto unidadeCadastrada = cadastrarUnidadePortIn.cadastrar(unidadeDTO);

        return  ResponseEntity.status(HttpStatus.CREATED).body(unidadeCadastrada);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerUnidade (@PathVariable Integer id) {

        try {
            removerUnidadePortIn.remover(id);

        } catch (UnidadeNaoEncontradaException excecao) {

            final Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping()
    public ResponseEntity<UnidadeDto> atualizaUnidade (@RequestBody UnidadeDto unidadeDTO) {

        System.out.println("Estou atualizando a unidade " + unidadeDTO.getIdUnidade());
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadeDTO);
    }
}