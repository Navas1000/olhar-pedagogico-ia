package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class DiarioEducacionalStub {

    public static DiarioEducacionalDTO getDiarioEducacionalCompleta() {
        return RecursoUtil.getObject(
                "diarioEducacional/diarioEducacionalCompleta.json",
                DiarioEducacionalDTO.class
        );
    }

    public static DiarioEducacionalDTO getDiarioEducacionalCadastrar() {
        return RecursoUtil.getObject(
                "diarioEducacional/diarioEducacionalCadastrar.json",
                DiarioEducacionalDTO.class
        );
    }

    public static DiarioEducacionalDTO getDiarioEducacionalAlterada() {
        return RecursoUtil.getObject(
                "diarioEducacional/diarioEducacionalAlterada.json",
                DiarioEducacionalDTO.class
        );
    }
}