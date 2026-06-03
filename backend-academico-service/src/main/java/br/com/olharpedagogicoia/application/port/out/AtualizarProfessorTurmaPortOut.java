package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;

public interface AtualizarProfessorTurmaPortOut {

    public ProfessorTurmaDTO atualizar(final ProfessorTurmaDTO professorTurmaDTO);

}