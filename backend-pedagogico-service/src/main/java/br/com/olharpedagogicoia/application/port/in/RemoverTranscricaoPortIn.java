package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;

public interface RemoverTranscricaoPortIn {

    public void remover(final Integer id) throws TranscricaoNaoEncontradaException;
}