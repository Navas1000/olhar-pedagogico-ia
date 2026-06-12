package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.RemoverResumoAudioPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverResumoAudioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverResumoAudioUseCase implements RemoverResumoAudioPortIn {

    final RemoverResumoAudioPortOut removerResumoAudioPortOut;

    @Override
    public void remover(final Integer id) throws ResumoAudioNaoEncontradoException {

        removerResumoAudioPortOut.remover(id);

        log.info("Resumo áudio removido com sucesso: {}", id);
    }
}