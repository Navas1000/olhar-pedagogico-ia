package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;

public interface AtualizarResumoAudioPortOut {

    public ResumoAudioDTO atualizar(final ResumoAudioDTO resumoAudioDTO);
}