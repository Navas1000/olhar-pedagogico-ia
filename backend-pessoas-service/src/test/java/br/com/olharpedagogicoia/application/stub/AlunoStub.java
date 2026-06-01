package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class AlunoStub {

    public static AlunoDTO getAlunoCompleta() {
        return RecursoUtil.getObject("aluno/alunoCompleta.json", AlunoDTO.class);
    }

    public static AlunoDTO getAlunoAlterada() {
        return RecursoUtil.getObject("aluno/alunoAlterada.json", AlunoDTO.class);
    }

    public static AlunoDTO getAlunoCadastrar() {
        return RecursoUtil.getObject("aluno/alunoCadastrar.json", AlunoDTO.class);
    }
}