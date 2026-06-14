package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;

public interface AtualizarDiarioAudioPortOut {

    public DiarioAudioDTO atualizar(final DiarioAudioDTO diarioAudioDTO);
}