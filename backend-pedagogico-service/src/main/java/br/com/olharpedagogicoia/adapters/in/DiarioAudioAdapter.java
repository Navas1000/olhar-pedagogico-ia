package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/diario-audio")
public class DiarioAudioAdapter {

    @GetMapping("diario/{idDiario}/aula/{idAula}/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/funcionario/{idFuncionario}")
    public ResponseEntity<DiarioAudioDTO> consultaDiarioAudio(@PathVariable Integer idDiario,
                                                              @PathVariable Integer idAula,
                                                              @PathVariable Integer idEmpresa,
                                                              @PathVariable Integer idUnidade,
                                                              @PathVariable Integer idTurma,
                                                              @PathVariable Integer idPessoa,
                                                              @PathVariable Integer idFuncionario) {

        DiarioAudioDTO diarioAudioConsultado = new DiarioAudioDTO();

        diarioAudioConsultado.setIdDiario(idDiario);
        diarioAudioConsultado.setIdAula(idAula);
        diarioAudioConsultado.setIdEmpresa(idEmpresa);
        diarioAudioConsultado.setIdUnidade(idUnidade);
        diarioAudioConsultado.setIdTurma(idTurma);
        diarioAudioConsultado.setIdPessoa(idPessoa);
        diarioAudioConsultado.setIdFuncionario(idFuncionario);
        diarioAudioConsultado.setNomeBucket("olhar-pedagogico-audios");
        diarioAudioConsultado.setChaveObjeto("Chave");
        diarioAudioConsultado.setTamanhoArquivo(1024L);
        diarioAudioConsultado.setExtensao("mp3");
        diarioAudioConsultado.setDuracaoSegundos(60);
        diarioAudioConsultado.setChecksum("checksum");
        diarioAudioConsultado.setDataCriacao(LocalDateTime.now());

        return ResponseEntity.ok(diarioAudioConsultado);
    }

    @PostMapping
    public ResponseEntity<DiarioAudioDTO> cadastraDiarioAudio(@RequestBody DiarioAudioDTO diarioAudioDTO) {

        System.out.println("Estou cadastrando o áudio do diário");
        return ResponseEntity.status(HttpStatus.CREATED).body(diarioAudioDTO);
    }
    @DeleteMapping("diario/{idDiario}/aula/{idAula}/empresa/{idEmpresa}/unidade/{idUnidade}/turma/{idTurma}/pessoa/{idPessoa}/funcionario/{idFuncionario}")
    public ResponseEntity<Void> removerDiarioAudio (@PathVariable Integer idDiario,
                                                    @PathVariable Integer idAula,
                                                    @PathVariable Integer idEmpresa,
                                                    @PathVariable Integer idUnidade,
                                                    @PathVariable Integer idTurma,
                                                    @PathVariable Integer idPessoa,
                                                    @PathVariable Integer idFuncionario) {

        System.out.println("Removendo audio do diário");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping("/{id}")
    public ResponseEntity<DiarioAudioDTO> atualizaDiarioAudio (@RequestBody DiarioAudioDTO diarioAudioDTO) {

        System.out.println("Estou atualizando o audio do diário " + diarioAudioDTO.getIdAudio());
        return ResponseEntity.status(HttpStatus.CREATED).body(diarioAudioDTO);
    }
}