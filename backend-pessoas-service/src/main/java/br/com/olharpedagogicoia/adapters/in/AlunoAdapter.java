package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/aluno")
public class AlunoAdapter {

 @GetMapping("/{id}/pessoa/{idPessoa}")

    public ResponseEntity<AlunoDTO> consultaAluno(@PathVariable Integer id, @PathVariable Integer idPessoa) {

        AlunoDTO alunoConsultado = new AlunoDTO();

        alunoConsultado.setIdAluno(id);
        alunoConsultado.setIdPessoa(idPessoa);
        alunoConsultado.setNomeChamada("Joãozinho");
        alunoConsultado.setDataCriacao(LocalDateTime.now());
        alunoConsultado.setDataModificacao(LocalDateTime.now());

        return ResponseEntity.ok(alunoConsultado);
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> cadastraAluno(@RequestBody AlunoDTO alunoDTO) {

        System.out.println("Estou cadastrando o aluno");
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
    }
    @DeleteMapping("/{id}/pessoa/{idPessoa}")
    public ResponseEntity<Void> removerAluno (@PathVariable Integer id,
                                              @PathVariable Integer idPessoa) {

        System.out.println("Removendo Aluno");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<AlunoDTO> atualizaAluno (@RequestBody AlunoDTO alunoDTO) {

        System.out.println("Estou atualizando o aluno " + alunoDTO.getIdAluno());
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
    }
}