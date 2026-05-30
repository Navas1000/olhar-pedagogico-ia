package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;

public interface RemoverPapelFuncaoPortIn {

    public void remover(final Integer id) throws PapelFuncaoNaoEncontradoException;

}