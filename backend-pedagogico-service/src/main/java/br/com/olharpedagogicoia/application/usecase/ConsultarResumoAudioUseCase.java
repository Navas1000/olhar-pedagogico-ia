package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarResumoAudioPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoAudioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarResumoAudioUseCase implements ConsultarResumoAudioPortIn {

    final ConsultarResumoAudioPortOut consultarResumoAudioPortOut;

    @Override
    public ResumoAudioDTO consultar(final Integer id) throws ResumoAudioNaoEncontradoException {

        final ResumoAudioDTO resumoAudioDTO = consultarResumoAudioPortOut.consultar(id);

        log.info("Resumo áudio consultado com sucesso: {}", resumoAudioDTO);

        return resumoAudioDTO;
    }
}