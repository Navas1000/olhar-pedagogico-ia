package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/aula")
public class AulaAdapter {

    @GetMapping("/{id}")
    public ResponseEntity<AulaDTO> consultaAula(@PathVariable Integer id) {

        AulaDTO aulaConsultada = new AulaDTO();

        aulaConsultada.setIdAula(1);
        aulaConsultada.setIdEmpresa(1);
        aulaConsultada.setIdUnidade(1);
        aulaConsultada.setIdTurma(1);
        aulaConsultada.setIdPessoa(1);
        aulaConsultada.setIdFuncionario(1);
        aulaConsultada.setDataHoraAula(LocalDateTime.now());
        aulaConsultada.setDataCriacao(LocalDateTime.now());

        return ResponseEntity.ok(aulaConsultada);
    }

    @PostMapping
    public ResponseEntity<AulaDTO> cadastraAula(@RequestBody AulaDTO aulaDTO) {

        System.out.println("Estou cadastrando a aula");
        return ResponseEntity.status(HttpStatus.CREATED).body(aulaDTO);
    }
    @DeleteMapping("/{id}/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/funcionario/{idFuncionario}")
    public ResponseEntity<Void> removerAula (@PathVariable Integer id,
                                             @PathVariable Integer idEmpresa,
                                             @PathVariable Integer idUnidade,
                                             @PathVariable Integer idTurma,
                                             @PathVariable Integer idPessoa,
                                             @PathVariable Integer idFuncionario) {

        System.out.println("Removendo Aula");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<AulaDTO> atualizaAula (@RequestBody AulaDTO aulaDTO) {

        System.out.println("Estou atualizando a aula " + aulaDTO.getIdAula());
        return ResponseEntity.status(HttpStatus.CREATED).body(aulaDTO);
    }
}