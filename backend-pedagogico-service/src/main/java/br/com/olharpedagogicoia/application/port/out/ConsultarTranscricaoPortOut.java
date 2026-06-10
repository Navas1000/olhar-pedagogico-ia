package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;

public interface ConsultarTranscricaoPortOut {

    public TranscricaoDTO consultar(final Integer id) throws TranscricaoNaoEncontradaException;
}