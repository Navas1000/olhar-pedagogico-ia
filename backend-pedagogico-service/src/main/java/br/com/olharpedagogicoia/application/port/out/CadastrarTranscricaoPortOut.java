package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;

public interface CadastrarTranscricaoPortOut {

    public TranscricaoDTO cadastrar(final TranscricaoDTO transcricaoDTO);
}