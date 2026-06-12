package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.RemoverDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverDiarioAudioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverDiarioAudioUseCase implements RemoverDiarioAudioPortIn {

    final RemoverDiarioAudioPortOut removerDiarioAudioPortOut;

    @Override
    public void remover(final Integer id) throws DiarioAudioNaoEncontradoException {

        removerDiarioAudioPortOut.remover(id);

        log.info("Diário áudio removido com sucesso: {}", id);
    }
}