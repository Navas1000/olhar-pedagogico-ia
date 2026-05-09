package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/resumo-audio")
public class ResumoAudioAdapter {

    @GetMapping("/resumo/{idResumo}")
    public ResponseEntity<ResumoAudioDTO> consultaResumoAudio(@PathVariable Integer idResumo) {

        ResumoAudioDTO resumoAudioConsultado = new ResumoAudioDTO();

        resumoAudioConsultado.setIdResumo(idResumo);
        resumoAudioConsultado.setNomeBucket("olhar-pedagogico-resumos");
        resumoAudioConsultado.setChaveObjeto("Chave");
        resumoAudioConsultado.setDuracaoSegundos(60);
        resumoAudioConsultado.setFormato("mp3");
        resumoAudioConsultado.setTamanhoBytes(1024L);
        resumoAudioConsultado.setDataCriacao(LocalDateTime.now());

        return ResponseEntity.ok(resumoAudioConsultado);
    }

    @PostMapping
    public ResponseEntity<ResumoAudioDTO> cadastraResumoAudio(@RequestBody ResumoAudioDTO resumoAudioDTO) {

        System.out.println("Estou cadastrando o áudio do resumo");
        return ResponseEntity.status(HttpStatus.CREATED).body(resumoAudioDTO);
    }
    @DeleteMapping("/resumo/{idResumo}")
    public ResponseEntity<Void> removerResumoAudio (@PathVariable Integer idResumo) {

        System.out.println("Removendo o resumo do audio");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<ResumoAudioDTO> atualizaResumoAudio (@RequestBody ResumoAudioDTO resumoAudioDTO) {

        System.out.println("Estou atualizando o resumo do audio " + resumoAudioDTO.getIdResumo());
        return ResponseEntity.status(HttpStatus.CREATED).body(resumoAudioDTO);
    }
}