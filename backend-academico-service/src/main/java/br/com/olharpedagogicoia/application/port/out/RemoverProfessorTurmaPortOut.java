package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;

public interface RemoverProfessorTurmaPortOut {

    public void remover(final Integer id) throws ProfessorTurmaNaoEncontradaException;

}