package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.IdResumoAudioObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;

public interface AtualizarResumoAudioPortIn {

    public ResumoAudioDTO atualizar(final ResumoAudioDTO resumoAudioDTO)
            throws ResumoAudioNaoEncontradoException, IdResumoAudioObrigatorioException;
}