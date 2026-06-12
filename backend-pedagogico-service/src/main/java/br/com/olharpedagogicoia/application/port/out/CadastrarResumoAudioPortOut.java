package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;

public interface CadastrarResumoAudioPortOut {

    public ResumoAudioDTO cadastrar(final ResumoAudioDTO resumoAudioDTO);
}