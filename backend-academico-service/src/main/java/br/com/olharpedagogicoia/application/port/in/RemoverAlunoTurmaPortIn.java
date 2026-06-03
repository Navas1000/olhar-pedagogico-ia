package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;

public interface RemoverAlunoTurmaPortIn {

    public void remover(final Integer id) throws AlunoTurmaNaoEncontradaException;

}