package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class AulaStub {

    public static AulaDTO getAulaCompleta() {
        return RecursoUtil.getObject("aula/aulaCompleta.json", AulaDTO.class);
    }

    public static AulaDTO getAulaAlterada() {
        return RecursoUtil.getObject("aula/aulaAlterada.json", AulaDTO.class);
    }

    public static AulaDTO getAulaCadastrar() {
        return RecursoUtil.getObject("aula/aulaCadastrar.json", AulaDTO.class);
    }
}