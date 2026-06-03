package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;

public interface RemoverProfessorTurmaPortIn {

    public void remover(final Integer id) throws ProfessorTurmaNaoEncontradaException;

}