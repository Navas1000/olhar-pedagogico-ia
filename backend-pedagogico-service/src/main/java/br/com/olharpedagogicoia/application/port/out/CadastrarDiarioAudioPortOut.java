package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;

public interface CadastrarDiarioAudioPortOut {

    public DiarioAudioDTO cadastrar(final DiarioAudioDTO diarioAudioDTO);
}