package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.util.RecursoUtil;


public class UnidadeStub {

    public static UnidadeDto getUnidadeCompleta() {
        return RecursoUtil.getObject("unidade/unidadeCompleta.json", UnidadeDto.class);
    }
    public static UnidadeDto getUnidadeAlterada() {
        return RecursoUtil.getObject("unidade/unidadeAlterada.json", UnidadeDto.class);
    }
    public static UnidadeDto getUnidadeCadastrar() {
        return RecursoUtil.getObject("unidade/unidadeCadastrar.json", UnidadeDto.class);
    }
}
