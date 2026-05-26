package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.util.RecursoUtil;


public class EmpresaStub {

    public static EmpresaDto getEmpresaCompleta() {
        return RecursoUtil.getObject("empresa/empresaCompleta.json", EmpresaDto.class);
    }

    public static EmpresaDto getEmpresaAlterada() {
        return RecursoUtil.getObject("empresa/empresaAlterada.json", EmpresaDto.class);
    }

    public static EmpresaDto getEmpresaCadastrar() {
        return RecursoUtil.getObject("empresa/empresaCadastrar.json", EmpresaDto.class);
    }
}
