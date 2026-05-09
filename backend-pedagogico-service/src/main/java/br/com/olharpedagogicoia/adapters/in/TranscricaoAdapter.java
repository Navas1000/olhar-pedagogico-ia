package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/transcricao")
public class TranscricaoAdapter {

    @GetMapping("/audio/{idAudio}/aula/{idAula}/diario/{idDiario}/aula/{idAula}/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/funcionario/{idFuncionario}")
    public ResponseEntity<TranscricaoDTO> consultaTranscricao(@PathVariable Integer idAudio,
                                                              @PathVariable Integer idDiario,
                                                              @PathVariable Integer idAula,
                                                              @PathVariable Integer idEmpresa,
                                                              @PathVariable Integer idUnidade,
                                                              @PathVariable Integer idTurma,
                                                              @PathVariable Integer idPessoa,
                                                              @PathVariable Integer idFuncionario) {

        TranscricaoDTO transcricaoConsultada = new TranscricaoDTO();

        transcricaoConsultada.setIdAudio(idAudio);
        transcricaoConsultada.setIdDiario(idDiario);
        transcricaoConsultada.setIdAula(idAula);
        transcricaoConsultada.setIdEmpresa(idEmpresa);
        transcricaoConsultada.setIdUnidade(idUnidade);
        transcricaoConsultada.setIdTurma(idTurma);
        transcricaoConsultada.setIdPessoa(idPessoa);
        transcricaoConsultada.setIdFuncionario(idFuncionario);
        transcricaoConsultada.setTranscricao("Texto da transcrição da aula.");
        transcricaoConsultada.setTranscricaoJson("Transcricao");
        transcricaoConsultada.setDataCriacao(LocalDateTime.now());

        return ResponseEntity.ok(transcricaoConsultada);
    }

    @PostMapping
    public ResponseEntity<TranscricaoDTO> cadastraTranscricao(@RequestBody TranscricaoDTO transcricaoDTO) {

        System.out.println("Estou cadastrando a transcrição");
        return ResponseEntity.status(HttpStatus.CREATED).body(transcricaoDTO);
    }
    @DeleteMapping("/audio/{idAudio}/aula/{idAula}/diario/{idDiario}/aula/{idAula}/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/funcionario/{idFuncionario}")
    public ResponseEntity<Void> removerTranscricao (@PathVariable Integer idAudio,
                                                    @PathVariable Integer idDiario,
                                                    @PathVariable Integer idAula,
                                                    @PathVariable Integer idEmpresa,
                                                    @PathVariable Integer idUnidade,
                                                    @PathVariable Integer idTurma,
                                                    @PathVariable Integer idPessoa,
                                                    @PathVariable Integer idFuncionario) {

        System.out.println("Removendo Transcricao");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping("/{id}")
    public ResponseEntity<TranscricaoDTO> atualizaTranscricao (@PathVariable Integer id, @RequestBody TranscricaoDTO transcricaoDTO) {

        System.out.println("Estou atualizando a transcricao " + transcricaoDTO.getTranscricao());
        return ResponseEntity.status(HttpStatus.CREATED).body(transcricaoDTO);
    }
}