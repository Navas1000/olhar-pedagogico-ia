package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.IdResumoEducacionalObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;

public interface AtualizarResumoEducacionalPortIn {

    public ResumoEducacionalDTO atualizar(final ResumoEducacionalDTO resumoEducacionalDTO)
            throws ResumoEducacionalNaoEncontradoException, IdResumoEducacionalObrigatorioException;
}