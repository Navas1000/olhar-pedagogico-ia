package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;

public interface CadastrarDiarioAudioPortIn {

    public DiarioAudioDTO cadastrar(final DiarioAudioDTO diarioAudioDTO);
}