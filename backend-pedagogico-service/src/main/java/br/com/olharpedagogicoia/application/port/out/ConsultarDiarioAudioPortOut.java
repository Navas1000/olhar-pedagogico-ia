package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;

public interface ConsultarDiarioAudioPortOut {

    public DiarioAudioDTO consultar(final Integer id) throws DiarioAudioNaoEncontradoException;
}