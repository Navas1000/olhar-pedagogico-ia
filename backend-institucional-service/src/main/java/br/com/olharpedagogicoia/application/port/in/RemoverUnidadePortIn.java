package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;

public interface RemoverUnidadePortIn {

    public void remover(final Integer id) throws UnidadeNaoEncontradaException;

}
