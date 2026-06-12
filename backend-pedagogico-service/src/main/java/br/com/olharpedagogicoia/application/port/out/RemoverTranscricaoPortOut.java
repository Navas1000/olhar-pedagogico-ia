package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;

public interface RemoverTranscricaoPortOut {

    public void remover(final Integer id) throws TranscricaoNaoEncontradaException;
}