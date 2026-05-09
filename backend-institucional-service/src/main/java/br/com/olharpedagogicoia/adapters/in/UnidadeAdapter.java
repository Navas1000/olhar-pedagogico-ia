package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.TurmaDTO;
import br.com.olharpedagogicoia.application.dto.UnidadeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/unidade")
public class UnidadeAdapter {

    @GetMapping("/{id}/empresa/{idEmpresa}")
    public ResponseEntity<UnidadeDTO> consultaUnidade(@PathVariable Integer id,
                                                      @PathVariable Integer idEmpresa) {

        UnidadeDTO unidadeConsultada = new UnidadeDTO();

        unidadeConsultada.setIdUnidade(id);
        unidadeConsultada.setIdEmpresa(idEmpresa);
        unidadeConsultada.setNome("Unidade Centro");
        unidadeConsultada.setEndereco("Rua Exemplo, 123");
        unidadeConsultada.setTelefone("19999999999");
        unidadeConsultada.setEmailContato("contato@unidade.com");
        unidadeConsultada.setDataCriacao(LocalDateTime.now());
        unidadeConsultada.setDataModificacao(LocalDateTime.now());

        return ResponseEntity.ok(unidadeConsultada);
    }

    @PostMapping
    public ResponseEntity<UnidadeDTO> cadastraUnidade(@RequestBody UnidadeDTO unidadeDTO) {

        System.out.println("Estou cadastrando a unidade");
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadeDTO);
    }
    @DeleteMapping("/{id}/empresa/{idEmpresa}")
    public ResponseEntity<Void> removerUnidade (@PathVariable Integer id,
                                                @PathVariable Integer idEmpresa) {

        System.out.println("Removendo unidade");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<UnidadeDTO> atualizaUnidade (@RequestBody UnidadeDTO unidadeDTO) {

        System.out.println("Estou atualizando a unidade " + unidadeDTO.getIdUnidade());
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadeDTO);
    }
}