package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;

public interface RemoverTurmaPortOut {

    public void remover(final Integer id) throws TurmaNaoEncontradaException;

}
