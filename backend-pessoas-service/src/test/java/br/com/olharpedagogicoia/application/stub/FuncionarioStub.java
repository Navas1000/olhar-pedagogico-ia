package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class FuncionarioStub {

    public static FuncionarioDTO getFuncionarioCompleta() {
        return RecursoUtil.getObject("funcionario/funcionarioCompleta.json", FuncionarioDTO.class);
    }

    public static FuncionarioDTO getFuncionarioAlterada() {
        return RecursoUtil.getObject("funcionario/funcionarioAlterada.json", FuncionarioDTO.class);
    }

    public static FuncionarioDTO getFuncionarioCadastrar() {
        return RecursoUtil.getObject("funcionario/funcionarioCadastrar.json", FuncionarioDTO.class);
    }
}