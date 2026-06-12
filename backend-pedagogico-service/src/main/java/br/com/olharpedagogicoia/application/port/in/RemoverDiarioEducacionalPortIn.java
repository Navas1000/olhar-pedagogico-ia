package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;

public interface RemoverDiarioEducacionalPortIn {

    public void remover(final Integer id) throws DiarioEducacionalNaoEncontradoException;
}