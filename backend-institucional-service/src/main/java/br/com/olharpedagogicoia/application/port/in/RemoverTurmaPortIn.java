package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;

public interface RemoverTurmaPortIn {

    public void remover(final Integer id) throws TurmaNaoEncontradaException;

}
