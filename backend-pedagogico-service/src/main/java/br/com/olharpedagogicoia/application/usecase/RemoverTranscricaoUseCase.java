package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverTranscricaoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverTranscricaoUseCase implements RemoverTranscricaoPortIn {

    final RemoverTranscricaoPortOut removerTranscricaoPortOut;

    @Override
    public void remover(final Integer id) throws TranscricaoNaoEncontradaException {

        removerTranscricaoPortOut.remover(id);

        log.info("Transcrição removida com sucesso: {}", id);
    }
}