package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarTranscricaoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarTranscricaoUseCase implements CadastrarTranscricaoPortIn {

    final CadastrarTranscricaoPortOut cadastrarTranscricaoPortOut;

    @Override
    public TranscricaoDTO cadastrar(final TranscricaoDTO transcricaoDTO) {

        transcricaoDTO.setDataCriacao(LocalDateTime.now());

        final TranscricaoDTO transcricaoCadastrada =
                cadastrarTranscricaoPortOut.cadastrar(transcricaoDTO);

        log.info("Transcrição cadastrada com sucesso: {}", transcricaoCadastrada);

        return transcricaoCadastrada;
    }
}