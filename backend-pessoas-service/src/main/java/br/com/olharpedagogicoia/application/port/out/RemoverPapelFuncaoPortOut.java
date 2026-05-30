package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;

public interface RemoverPapelFuncaoPortOut {

    public void remover(final Integer id) throws PapelFuncaoNaoEncontradoException;

}