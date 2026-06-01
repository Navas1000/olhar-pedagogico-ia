package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class PapelFuncaoStub {

    public static PapelFuncaoDTO getPapelFuncaoCompleta() {
        return RecursoUtil.getObject("papelFuncao/papelFuncaoCompleta.json", PapelFuncaoDTO.class);
    }

    public static PapelFuncaoDTO getPapelFuncaoAlterada() {
        return RecursoUtil.getObject("papelFuncao/papelFuncaoAlterada.json", PapelFuncaoDTO.class);
    }

    public static PapelFuncaoDTO getPapelFuncaoCadastrar() {
        return RecursoUtil.getObject("papelFuncao/papelFuncaoCadastrar.json", PapelFuncaoDTO.class);
    }
}