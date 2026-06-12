package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;

public interface CadastrarResumoAudioPortIn {

    public ResumoAudioDTO cadastrar(final ResumoAudioDTO resumoAudioDTO);
}