package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;

public interface RemoverDiarioAudioPortOut {

    public void remover(final Integer id) throws DiarioAudioNaoEncontradoException;
}