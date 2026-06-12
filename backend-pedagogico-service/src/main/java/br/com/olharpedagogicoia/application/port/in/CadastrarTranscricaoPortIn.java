package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;

public interface CadastrarTranscricaoPortIn {

    public TranscricaoDTO cadastrar(final TranscricaoDTO transcricaoDTO);
}