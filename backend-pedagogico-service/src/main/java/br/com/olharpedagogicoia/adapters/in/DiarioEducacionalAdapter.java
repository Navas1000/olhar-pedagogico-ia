package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.dto.StatusProcessamento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/diario-educacional")
public class DiarioEducacionalAdapter {

    @GetMapping("/aula/{idAula}/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/funcionario/{idFuncionario}")
    public ResponseEntity<DiarioEducacionalDTO> consultaDiarioEducacional(@PathVariable Integer idAula,
                                                                          @PathVariable Integer idEmpresa,
                                                                          @PathVariable Integer idUnidade,
                                                                          @PathVariable Integer idTurma,
                                                                          @PathVariable Integer idPessoa,
                                                                          @PathVariable Integer idFuncionario) {

        DiarioEducacionalDTO diarioConsultado = new DiarioEducacionalDTO();

        diarioConsultado.setIdAula(idAula);
        diarioConsultado.setIdEmpresa(idEmpresa);
        diarioConsultado.setIdUnidade(idUnidade);
        diarioConsultado.setIdTurma(idTurma);
        diarioConsultado.setIdPessoa(idPessoa);
        diarioConsultado.setIdFuncionario(idFuncionario);
        diarioConsultado.setStatusProcessamento(StatusProcessamento.PROCESSADO);
        diarioConsultado.setDataCriacao(LocalDateTime.now());

        return ResponseEntity.ok(diarioConsultado);
    }

    @PostMapping
    public ResponseEntity<DiarioEducacionalDTO> cadastraDiarioEducacional(@RequestBody DiarioEducacionalDTO diarioEducacionalDTO) {

        System.out.println("Estou cadastrando o diário educacional");
        return ResponseEntity.status(HttpStatus.CREATED).body(diarioEducacionalDTO);
    }
    @DeleteMapping("/aula/{idAula}/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/funcionario/{idFuncionario}")
    public ResponseEntity<Void> removerDiarioEducacional (@PathVariable Integer idAula,
                                                          @PathVariable Integer idEmpresa,
                                                          @PathVariable Integer idUnidade,
                                                          @PathVariable Integer idTurma,
                                                          @PathVariable Integer idPessoa,
                                                          @PathVariable Integer idFuncionario) {

        System.out.println("Removendo o diario educacional");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<DiarioEducacionalDTO> atualizaDiarioEducacional (@RequestBody DiarioEducacionalDTO diarioEducacionalDTO) {

        System.out.println("Estou atualizando o diário educacional " + diarioEducacionalDTO.getIdDiario());
        return ResponseEntity.status(HttpStatus.CREATED).body(diarioEducacionalDTO);
    }
}