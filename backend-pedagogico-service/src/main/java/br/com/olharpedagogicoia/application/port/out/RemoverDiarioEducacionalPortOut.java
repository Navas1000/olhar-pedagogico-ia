package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;

public interface RemoverDiarioEducacionalPortOut {

    public void remover(final Integer id) throws DiarioEducacionalNaoEncontradoException;
}