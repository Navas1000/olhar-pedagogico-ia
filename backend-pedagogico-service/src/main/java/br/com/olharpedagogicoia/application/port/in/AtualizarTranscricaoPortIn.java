package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.IdTranscricaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;

public interface AtualizarTranscricaoPortIn {

    public TranscricaoDTO atualizar(final TranscricaoDTO transcricaoDTO)
            throws TranscricaoNaoEncontradaException, IdTranscricaoObrigatorioException;
}