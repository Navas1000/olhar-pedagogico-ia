package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class AlunoTurmaStub {

    public static AlunoTurmaDTO getAlunoTurmaCompleta() {
        return RecursoUtil.getObject("alunoTurma/alunoTurmaCompleta.json", AlunoTurmaDTO.class);
    }

    public static AlunoTurmaDTO getAlunoTurmaAlterada() {
        return RecursoUtil.getObject("alunoTurma/alunoTurmaAlterada.json", AlunoTurmaDTO.class);
    }

    public static AlunoTurmaDTO getAlunoTurmaCadastrar() {
        return RecursoUtil.getObject("alunoTurma/alunoTurmaCadastrar.json", AlunoTurmaDTO.class);
    }
}