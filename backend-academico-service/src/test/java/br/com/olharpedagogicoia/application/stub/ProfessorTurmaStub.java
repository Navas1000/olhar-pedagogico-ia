package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class ProfessorTurmaStub {

    public static ProfessorTurmaDTO getProfessorTurmaCompleta() {
        return RecursoUtil.getObject("professorTurma/professorTurmaCompleta.json", ProfessorTurmaDTO.class);
    }

    public static ProfessorTurmaDTO getProfessorTurmaAlterada() {
        return RecursoUtil.getObject("professorTurma/professorTurmaAlterada.json", ProfessorTurmaDTO.class);
    }

    public static ProfessorTurmaDTO getProfessorTurmaCadastrar() {
        return RecursoUtil.getObject("professorTurma/professorTurmaCadastrar.json", ProfessorTurmaDTO.class);
    }
}