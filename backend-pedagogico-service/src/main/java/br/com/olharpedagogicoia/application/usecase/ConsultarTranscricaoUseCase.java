package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarTranscricaoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarTranscricaoUseCase implements ConsultarTranscricaoPortIn {

    final ConsultarTranscricaoPortOut consultarTranscricaoPortOut;

    @Override
    public TranscricaoDTO consultar(final Integer id) throws TranscricaoNaoEncontradaException {

        final TranscricaoDTO transcricaoDTO = consultarTranscricaoPortOut.consultar(id);

        log.info("Transcrição consultada com sucesso: {}", transcricaoDTO);

        return transcricaoDTO;
    }
}