package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioAudioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarDiarioAudioUseCase implements ConsultarDiarioAudioPortIn {

    final ConsultarDiarioAudioPortOut consultarDiarioAudioPortOut;

    @Override
    public DiarioAudioDTO consultar(final Integer id) throws DiarioAudioNaoEncontradoException {

        final DiarioAudioDTO diarioAudioDTO = consultarDiarioAudioPortOut.consultar(id);

        log.info("Diário áudio consultado com sucesso: {}", diarioAudioDTO);

        return diarioAudioDTO;
    }
}