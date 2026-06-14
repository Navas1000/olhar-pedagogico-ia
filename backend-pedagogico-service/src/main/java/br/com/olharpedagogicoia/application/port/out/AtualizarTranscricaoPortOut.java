package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;

public interface AtualizarTranscricaoPortOut {

    public TranscricaoDTO atualizar(final TranscricaoDTO transcricaoDTO);
}