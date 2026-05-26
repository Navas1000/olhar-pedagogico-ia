package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.util.RecursoUtil;
import br.com.olharpedagogicoia.domain.Turma;


public class TurmaStub {

    public static TurmaDto getTurmaCompleta() {
        return RecursoUtil.getObject("turma/turmaCompleta.json", TurmaDto.class);
    }
    public static TurmaDto getTurmaAlterada() {
        return RecursoUtil.getObject("turma/turmaAlterada.json", TurmaDto.class);
    }
    public static TurmaDto getTurmaCadastrar() {
        return RecursoUtil.getObject("turma/turmaCadastrar.json", TurmaDto.class);
    }
}
