package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;

public interface CadastrarProfessorTurmaPortIn {

    public ProfessorTurmaDTO cadastrar(final ProfessorTurmaDTO professorTurmaDTO);

}