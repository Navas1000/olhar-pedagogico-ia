package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;

public interface ConsultarDiarioAudioPortIn {

    public DiarioAudioDTO consultar(final Integer id) throws DiarioAudioNaoEncontradoException;
}