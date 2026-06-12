package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;

public interface RemoverResumoEducacionalPortIn {

    public void remover(final Integer id) throws ResumoEducacionalNaoEncontradoException;
}