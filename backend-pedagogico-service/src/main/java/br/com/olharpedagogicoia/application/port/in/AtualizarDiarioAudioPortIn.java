package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdDiarioAudioObrigatorioException;

public interface AtualizarDiarioAudioPortIn {

    public DiarioAudioDTO atualizar(final DiarioAudioDTO diarioAudioDTO)
            throws DiarioAudioNaoEncontradoException, IdDiarioAudioObrigatorioException;
}