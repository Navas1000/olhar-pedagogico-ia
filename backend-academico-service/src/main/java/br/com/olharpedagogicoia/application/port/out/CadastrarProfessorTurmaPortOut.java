package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;

public interface CadastrarProfessorTurmaPortOut {

    public ProfessorTurmaDTO cadastrar(final ProfessorTurmaDTO professorTurmaDTO);

}