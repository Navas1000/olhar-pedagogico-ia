package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;

public interface ConsultarResumoAudioPortIn {

    public ResumoAudioDTO consultar(final Integer id) throws ResumoAudioNaoEncontradoException;
}