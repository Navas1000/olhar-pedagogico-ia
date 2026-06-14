package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class ResumoEducacionalStub {

    public static ResumoEducacionalDTO getResumoEducacionalCompleta() {
        return RecursoUtil.getObject(
                "resumoEducacional/resumoEducacionalCompleta.json",
                ResumoEducacionalDTO.class
        );
    }

    public static ResumoEducacionalDTO getResumoEducacionalCadastrar() {
        return RecursoUtil.getObject(
                "resumoEducacional/resumoEducacionalCadastrar.json",
                ResumoEducacionalDTO.class
        );
    }

    public static ResumoEducacionalDTO getResumoEducacionalAlterada() {
        return RecursoUtil.getObject(
                "resumoEducacional/resumoEducacionalAlterada.json",
                ResumoEducacionalDTO.class
        );
    }
}