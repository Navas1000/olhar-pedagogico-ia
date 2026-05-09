package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/papel-funcao")
public class PapelFuncaoAdapter {

    @GetMapping("/{id}")
    public ResponseEntity<PapelFuncaoDTO> consultaPapelFuncao(@PathVariable Integer id) {

        PapelFuncaoDTO papelFuncaoConsultado = new PapelFuncaoDTO();

        papelFuncaoConsultado.setIdPapel(1);
        papelFuncaoConsultado.setSigla("PROFESSOR");
        papelFuncaoConsultado.setDescricao("Professor responsável pelas aulas e diários");
        papelFuncaoConsultado.setNivelHierarquico(4);
        papelFuncaoConsultado.setDataCriacao(LocalDateTime.now());
        papelFuncaoConsultado.setDataModificacao(LocalDateTime.now());

        return ResponseEntity.ok(papelFuncaoConsultado);
    }

    @PostMapping
    public ResponseEntity<PapelFuncaoDTO> cadastraPapelFuncao(@RequestBody PapelFuncaoDTO papelFuncaoDTO) {

        System.out.println("Estou cadastrando o papel/função");
        return ResponseEntity.status(HttpStatus.CREATED).body(papelFuncaoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPapelFuncao (@PathVariable Integer id) {

        System.out.println("Removendo função");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<PapelFuncaoDTO> atualizaPapelFuncao (@RequestBody PapelFuncaoDTO papelFuncaoDTO) {

        System.out.println("Estou atualizando a função " + papelFuncaoDTO.getIdPapel());
        return ResponseEntity.status(HttpStatus.CREATED).body(papelFuncaoDTO);
    }
}