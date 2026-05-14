package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/turma")
public class TurmaAdapter {

    @GetMapping("/{id}/empresa/{idEmpresa}/unidade/{idUnidade}")
    public ResponseEntity<TurmaDto> consultaTurma(@PathVariable Integer id,
                                                  @PathVariable Integer idEmpresa,
                                                  @PathVariable Integer idUnidade) {

        TurmaDto turmaConsultada = new TurmaDto();

        turmaConsultada.setIdTurma(id);
        turmaConsultada.setIdEmpresa(idEmpresa);
        turmaConsultada.setIdUnidade(idUnidade);
        turmaConsultada.setNome("Turma 1º Ano A");
        turmaConsultada.setAnoLetivo(2026);
        turmaConsultada.setAtivo(true);
        turmaConsultada.setDataCriacao(LocalDateTime.now());
        turmaConsultada.setDataModificacao(LocalDateTime.now());

        return ResponseEntity.ok(turmaConsultada);
    }

    @PostMapping
    public ResponseEntity<TurmaDto> cadastraTurma(@RequestBody TurmaDto turmaDTO) {

        System.out.println("Estou cadastrando a turma");
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaDTO);
    }
    @DeleteMapping("/{id}/empresa/{idEmpresa}/unidade/{idUnidade}")
    public ResponseEntity<Void> removerTurma (@PathVariable Integer id,
                                              @PathVariable Integer idEmpresa,
                                              @PathVariable Integer idUnidade) {

        System.out.println("Removendo turma");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<TurmaDto> atualizaTurma (@RequestBody TurmaDto turmaDTO) {

        System.out.println("Estou atualizando a turma " + turmaDTO.getIdTurma());
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaDTO);
    }
}