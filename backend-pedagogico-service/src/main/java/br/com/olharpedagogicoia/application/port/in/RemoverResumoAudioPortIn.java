package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;

public interface RemoverResumoAudioPortIn {

    public void remover(final Integer id) throws ResumoAudioNaoEncontradoException;
}