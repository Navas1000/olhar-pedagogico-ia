package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;

public interface ConsultarProfessorTurmaPortOut {

    public ProfessorTurmaDTO consultar(final Integer id) throws ProfessorTurmaNaoEncontradaException;

}