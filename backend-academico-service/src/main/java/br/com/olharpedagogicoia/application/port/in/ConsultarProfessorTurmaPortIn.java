package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;

public interface ConsultarProfessorTurmaPortIn {

    public ProfessorTurmaDTO consultar(final Integer id) throws ProfessorTurmaNaoEncontradaException;

}