package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.IdProfessorTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;

public interface AtualizarProfessorTurmaPortIn {

    public ProfessorTurmaDTO atualizar(final ProfessorTurmaDTO professorTurmaDTO)
            throws ProfessorTurmaNaoEncontradaException, IdProfessorTurmaObrigatorioException;

}