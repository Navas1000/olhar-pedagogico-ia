package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;

public interface ConsultarResumoAudioPortOut {

    public ResumoAudioDTO consultar(final Integer id) throws ResumoAudioNaoEncontradoException;
}