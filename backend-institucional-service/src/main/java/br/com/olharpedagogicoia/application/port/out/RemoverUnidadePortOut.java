package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;

public interface RemoverUnidadePortOut {

    public void remover(final Integer id) throws UnidadeNaoEncontradaException;

}
