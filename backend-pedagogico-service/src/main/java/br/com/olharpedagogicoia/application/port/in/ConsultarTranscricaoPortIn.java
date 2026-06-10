package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;

public interface ConsultarTranscricaoPortIn {

    public TranscricaoDTO consultar(final Integer id) throws TranscricaoNaoEncontradaException;
}