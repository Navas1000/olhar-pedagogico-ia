package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;

public interface RemoverResumoEducacionalPortOut {

    public void remover(final Integer id) throws ResumoEducacionalNaoEncontradoException;
}