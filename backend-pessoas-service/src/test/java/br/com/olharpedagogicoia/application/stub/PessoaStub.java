package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class PessoaStub {

    public static PessoaDTO getPessoaCompleta() {
        return RecursoUtil.getObject("pessoa/pessoaCompleta.json", PessoaDTO.class);
    }

    public static PessoaDTO getPessoaAlterada() {
        return RecursoUtil.getObject("pessoa/pessoaAlterada.json", PessoaDTO.class);
    }

    public static PessoaDTO getPessoaCadastrar() {
        return RecursoUtil.getObject("pessoa/pessoaCadastrar.json", PessoaDTO.class);
    }
}