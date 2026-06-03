package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;

public interface RemoverAulaPortOut {

    public void remover(final Integer id) throws AulaNaoEncontradaException;

}